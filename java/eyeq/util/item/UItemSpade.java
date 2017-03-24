package eyeq.util.item;

import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UItemSpade extends ItemSpade implements IItemEnchanted, IItemUsePotion {
    protected List<EnchantmentData> enchants = new ArrayList<>();

    private ClearPotionType clear = ClearPotionType.NONE;
    private Map<PotionEffect, Float> potions = new HashMap<>();
    private int useItemDamage = 1;

    public UItemSpade(ToolMaterial material) {
        super(material);
    }

    public UItemSpade(ToolMaterial material, float damage, float speed) {
        this(material);
        this.damageVsEntity = damage + material.getDamageVsEntity();
        this.attackSpeed = speed;
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int itemSlot, boolean isSelected) {
        super.onUpdate(itemStack, world, entity, itemSlot, isSelected);
        IItemEnchanted.updateEnchantment(itemStack, enchants);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if(world.isRemote) {
            return super.onItemRightClick(world, player, hand);
        }
        ItemStack itemStack = player.getHeldItem(hand);
        IItemUsePotion.clearPotion(player, clear);
        if(IItemUsePotion.usePotion(player, potions)) {
            if(useItemDamage != 0) {
                itemStack.damageItem(useItemDamage, player);
            }
            player.swingArm(hand);
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, itemStack);
    }

    @Override
    public UItemSpade setEnchantmentData(EnchantmentData enchant) {
        enchants.clear();
        return addEnchantmentData(enchant);
    }

    @Override
    public UItemSpade addEnchantmentData(EnchantmentData enchant) {
        enchants.add(enchant);
        return this;
    }

    @Override
    public boolean hasEffect(ItemStack item) {
        if(super.hasEffect(item)) {
            return true;
        }
        return !enchants.isEmpty();
    }

    @Override
    public UItemSpade setClearPotionType(ClearPotionType type) {
        clear = type;
        return this;
    }

    @Override
    public UItemSpade setPotionEffect(PotionEffect potion, float probability) {
        potions.clear();
        return addPotionEffect(potion, probability);
    }

    @Override
    public UItemSpade addPotionEffect(PotionEffect potion, float probability) {
        potions.put(potion, probability);
        return this;
    }

    @Override
    public UItemSpade setUseItemDamage(int damage) {
        this.useItemDamage = damage;
        return this;
    }
}