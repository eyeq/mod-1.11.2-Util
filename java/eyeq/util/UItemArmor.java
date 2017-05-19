package eyeq.util;
// パッケージ間違えてたけど、面倒なので放置

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class UItemArmor extends ItemArmor {
    private final ResourceLocation armorName;

    public UItemArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlot, ResourceLocation armorName) {
        super(material, renderIndex, equipmentSlot);
        this.armorName = armorName;
    }

    @Override
    public String getArmorTexture(ItemStack itemStack, Entity entity, EntityEquipmentSlot slot, String type) {
        return getArmorTexture(armorName, slot, type);
    }

    public static String getArmorTexture(ResourceLocation resource, EntityEquipmentSlot slot, String type) {
        String domain = resource.getResourceDomain();
        String texture = resource.getResourcePath();
        int layer = slot == EntityEquipmentSlot.LEGS ? 2 : 1;
        return domain + ":textures/models/armor/" + texture + "_layer_" + layer  + (type == null ? "" : "_" + type) + ".png";
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        switch(armorType) {
        case HEAD:
            onArmorTickHead(world, player, itemStack);
            break;
        case CHEST:
            onArmorTickChest(world, player, itemStack);
            break;
        case LEGS:
            onArmorTickLegs(world, player, itemStack);
            break;
        case FEET:
            onArmorTickFeet(world, player, itemStack);
            break;
        }
    }

    protected void onArmorTickHead(World world, EntityPlayer player, ItemStack itemStack) {}

    protected void onArmorTickChest(World world, EntityPlayer player, ItemStack itemStack) {}

    protected void onArmorTickLegs(World world, EntityPlayer player, ItemStack itemStack) {}

    protected void onArmorTickFeet(World world, EntityPlayer player, ItemStack itemStack) {}
}
