package eyeq.util.entity;

import eyeq.util.block.portal.IPortalPattern;
import eyeq.util.entity.player.EntityPlayerUtils;
import eyeq.util.world.UTeleporter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Random;

public class EntityUtils {
    public static ItemStack getArmor(Entity entity, EntityEquipmentSlot slot) {
        int index = slot.getIndex();
        Iterator<ItemStack> iterator = entity.getArmorInventoryList().iterator();
        while(iterator.hasNext()) {
            ItemStack itemStack = iterator.next();
            if(index <= 0) {
                return itemStack;
            }
            index--;
        }
        return ItemStack.EMPTY;
    }

    public static Entity travel(Entity entity, BlockPos pos, int dimensionId, IPortalPattern pattern, double scale) {
        // Entity setPortal
        if(entity.timeUntilPortal > 0) {
            entity.timeUntilPortal = entity.getPortalCooldown();
            return null;
        }
        entity.setPortal(pos);
        // inPortal = false;
        // Entity onEntityUpdate
        World entityWorld = entity.getEntityWorld();
        if(entityWorld.isRemote || !(entityWorld instanceof WorldServer)) {
            return null;
        }
        if(entity.isRiding()) {
            return null;
        }
        entity.timeUntilPortal = entity.getPortalCooldown();
        // Entity changeDimension
        if(entity.isDead) {
            return null;
        }
        if(!net.minecraftforge.common.ForgeHooks.onTravelToDimension(entity, dimensionId)) {
            return null;
        }
        entityWorld.removeEntity(entity);
        entity.isDead = false;

        MinecraftServer server = entity.getServer();
        int preDimensionId = entity.dimension;
        WorldServer preWorld = server.worldServerForDimension(preDimensionId);
        WorldServer world = server.worldServerForDimension(dimensionId);

        UTeleporter teleporter = new UTeleporter(world, pattern);
        BlockPos spawnPos = getNewPos(entity, world, dimensionId, teleporter, scale);
        if(entity instanceof EntityPlayerMP) {
            return EntityPlayerUtils.changeDimension(((EntityPlayerMP) entity), dimensionId, teleporter, spawnPos);
        }
        entity.dimension = dimensionId;
        preWorld.updateEntityWithOptionalForce(entity, false);

        Entity newEntity = EntityList.newEntity(entity.getClass(), world);
        if(newEntity != null) {
            try {
                copyDataFromOld(newEntity, entity);
            } catch(InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
            newEntity.moveToBlockPosAndAngles(spawnPos, newEntity.rotationYaw, newEntity.rotationPitch);
            boolean isForceSpawn = newEntity.forceSpawn;
            newEntity.forceSpawn = true;
            world.spawnEntity(newEntity);
            newEntity.forceSpawn = isForceSpawn;
            world.updateEntityWithOptionalForce(newEntity, false);
        }
        entity.isDead = true;
        preWorld.resetUpdateEntityTick();
        world.resetUpdateEntityTick();
        return newEntity;
    }

    private static BlockPos getNewPos(Entity entity, WorldServer world, int dimensionId, Teleporter teleporter, double scale) {
        if(scale == 0.0) {
            if(dimensionId == 0) {
                return world.getTopSolidOrLiquidBlock(world.getSpawnPoint());
            }
            return world.getSpawnCoordinate();
        }
        double x = entity.posX;
        double z = entity.posZ;
        x = MathHelper.clamp(x * scale, world.getWorldBorder().minX() + 16.0, world.getWorldBorder().maxX() - 16.0);
        z = MathHelper.clamp(z * scale, world.getWorldBorder().minZ() + 16.0, world.getWorldBorder().maxZ() - 16.0);
        x = MathHelper.clamp((int) x, -29999872, 29999872);
        z = MathHelper.clamp((int) z, -29999872, 29999872);
        entity.setLocationAndAngles(x, entity.posY, z, 90.0F, 0.0F);

        teleporter.placeInExistingPortal(entity, entity.rotationYaw);
        return new BlockPos(entity);
    }

    public static boolean isValidLightLevel(Entity entity, Random rand) {
        BlockPos pos = new BlockPos(entity.posX, entity.getEntityBoundingBox().minY, entity.posZ);

        World world = entity.world;
        if(world.getLightFor(EnumSkyBlock.SKY, pos) > rand.nextInt(32)) {
            return false;
        }
        int light = world.getLightFromNeighbors(pos);
        if(world.isThundering()) {
            int skylight = world.getSkylightSubtracted();
            world.setSkylightSubtracted(10);
            light = world.getLightFromNeighbors(pos);
            world.setSkylightSubtracted(skylight);
        }
        return light <= rand.nextInt(8);
    }

    public static void copyDataFromOld(Entity entity, Entity oldEntity) throws InvocationTargetException, IllegalAccessException {
        Method method = ReflectionHelper.findMethod(Entity.class, entity, new String[]{"copyDataFromOld", "func_180432_n"}, Entity.class);
        method.invoke(entity, oldEntity);
    }

    public static void setRidingEntity(Entity entity, Entity ridingEntity) {
        ObfuscationReflectionHelper.setPrivateValue(Entity.class, entity, ridingEntity, "ridingEntity", "");
    }
}
