package eyeq.util.oredict;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFlower;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.util.List;

public class UOreDictionary {
    public static final String OREDICT_LOG = "logWood";
    public static final String OREDICT_PLANKS = "plankWood";
    public static final String OREDICT_WOODEN_SLAB = "slabWood";
    public static final String OREDICT_WOODEN_STAIRS = "stairWood";
    public static final String OREDICT_STICK = "stickWood";
    public static final String OREDICT_SAPLING = "treeSapling";
    public static final String OREDICT_LEAVES = "treeLeaves";
    public static final String OREDICT_VINE = "vine";

    public static final String OREDICT_GOLD_ORE = "oreGold";
    public static final String OREDICT_IRON_ORE = "oreIron";
    public static final String OREDICT_LAPIS_ORE = "oreLapis";
    public static final String OREDICT_DIAMOND_ORE = "oreDiamond";
    public static final String OREDICT_REDSTONE_ORE = "oreRedstone";
    public static final String OREDICT_EMERALD_ORE = "oreEmerald";
    public static final String OREDICT_QUARTZ_ORE = "oreQuartz";
    public static final String OREDICT_COAL_ORE = "oreCoal";

    public static final String OREDICT_IRON_INGOT = "ingotIron";
    public static final String OREDICT_GOLD_INGOT = "ingotGold";
    public static final String OREDICT_BRICK = "ingotBrick";
    public static final String OREDICT_NETHERBRICK = "ingotBrickNether";
    public static final String OREDICT_IRON_NUGGET = "nuggetIron";
    public static final String OREDICT_GOLD_NUGGET = "nuggetGold";

    public static final String OREDICT_DIAMOND = "gemDiamond";
    public static final String OREDICT_EMERALD = "gemEmerald";
    public static final String OREDICT_QUARTZ = "gemQuartz";
    public static final String OREDICT_PRISMARINE_SHARD = "gemPrismarine";
    public static final String OREDICT_PRISMARINE_CRYSTALS = "dustPrismarine";
    public static final String OREDICT_REDSTONE = "dustRedstone";
    public static final String OREDICT_GLOWSTONE_DUST = "dustGlowstone";
    public static final String OREDICT_LAPIS = "gemLapis";

    public static final String OREDICT_GOLD_BLOCK = "blockGold";
    public static final String OREDICT_IRON_BLOCK = "blockIron";
    public static final String OREDICT_LAPIS_BLOCK = "blockLapis";
    public static final String OREDICT_DIAMOND_BLOCK = "blockDiamond";
    public static final String OREDICT_REDSTONE_BLOCK = "blockRedstone";
    public static final String OREDICT_EMERALD_BLOCK = "blockEmerald";
    public static final String OREDICT_QUARTZ_BLOCK = "blockQuartz";
    public static final String OREDICT_COAL_BLOCK = "blockCoal";
    public static final String OREDICT_CHARCOAL_BLOCK = "blockCharcoal";

    public static final String OREDICT_WHEAT = "cropWheat";
    public static final String OREDICT_POTATO = "cropPotato";
    public static final String OREDICT_CARROT = "cropCarrot";
    public static final String OREDICT_NETHER_WART = "cropNetherWart";
    public static final String OREDICT_REEDS = "sugarcane";
    public static final String OREDICT_CACTUS = "blockCactus";

    public static final String OREDICT_DYE = "dye";
    public static final String OREDICT_PAPER = "paper";

    public static final String OREDICT_SLIME_BALL = "slimeball";
    public static final String OREDICT_ENDER_PEARL = "enderpearl";
    public static final String OREDICT_BONE = "bone";
    public static final String OREDICT_GUNPOWDER = "gunpowder";
    public static final String OREDICT_STRING = "string";
    public static final String OREDICT_NETHER_STAR = "netherStar";
    public static final String OREDICT_LEATHER = "leather";
    public static final String OREDICT_FEATHER = "feather";
    public static final String OREDICT_EGG = "egg";

    public static final String OREDICT_RECORD = "record";

    public static final String OREDICT_DIRT = "dirt";
    public static final String OREDICT_GRASS = "grass";
    public static final String OREDICT_STONE = "stone";
    public static final String OREDICT_COBBLESTONE = "cobblestone";
    public static final String OREDICT_GRAVEL = "gravel";
    public static final String OREDICT_SAND = "sand";
    public static final String OREDICT_SANDSTONE = "sandstone";
    public static final String OREDICT_NETHERRACK = "netherrack";
    public static final String OREDICT_OBSIDIAN = "obsidian";
    public static final String OREDICT_GLOWSTONE = "glowstone";
    public static final String OREDICT_END_STONE = "endstone";
    public static final String OREDICT_TORCH = "torch";
    public static final String OREDICT_CRAFTING_TABLE = "workbench";
    public static final String OREDICT_SLIME_BLOCK = "blockSlime";
    public static final String OREDICT_PRISMARINE = "blockPrismarine";
    public static final String OREDICT_PRISMARINE_BRICK = "blockPrismarineBrick";
    public static final String OREDICT_PRISMARINE_DARK = "blockPrismarineDark";
    public static final String OREDICT_STONE_GRANITE = "stoneGranite";
    public static final String OREDICT_STONE_POLISHED_GRANITE = "stoneGranitePolished";
    public static final String OREDICT_STONE_DIORITE = "stoneDiorite";
    public static final String OREDICT_STONE_POLISHED_DIORITE = "stoneDioritePolished";
    public static final String OREDICT_STONE_ANDESITE = "stoneAndesite";
    public static final String OREDICT_STONE_POLISHED_ANDESITE = "stoneAndesitePolished";
    public static final String OREDICT_COLORLESS_GLASS = "blockGlassColorless";
    public static final String OREDICT_GLASS = "blockGlass";
    public static final String OREDICT_COLORLESS_GLASS_PANE = "paneGlassColorless";
    public static final String OREDICT_GLASS_PANE = "paneGlass";

    public static final String OREDICT_CHEST = "chest";
    public static final String OREDICT_WODDEN_CHEST = "chestWood";
    public static final String OREDICT_ENDER_CHEST = "chestEnder";
    public static final String OREDICT_TRAPPED_CHEST = "chestTrapped";

    public static final String OREDICT_MILK = "milk";
    public static final String OREDICT_GOLDEN_FOOD = "foodGold";
    public static final String OREDICT_COOKED = "cooked";
    public static final String OREDICT_COOKED_MEAT = "cookedMeat";
    public static final String OREDICT_COOKED_FISH = "cookedFish";
    public static final String OREDICT_SWEET = "sweet";
    public static final String OREDICT_FISH = "fish";
    public static final String OREDICT_MEAT = "meat";
    public static final String OREDICT_GRAIN = "grain";
    public static final String OREDICT_FRUIT = "fruit";
    public static final String OREDICT_VEGETABLE = "vegetable";
    public static final String OREDICT_MUSHROOM = "mushroom";
    public static final String OREDICT_FLOWER = "flower";
    public static final String OREDICT_STONE_IGNEOUS = "stoneIgneous";
    public static final String OREDICT_STONE_IGNEOUS_POLISHED = "stoneIgneousPolished";

    static {
        // なぜかLightGrayで登録されてる
        String silver = "Silver";
        ItemStack dye = new ItemStack(Items.DYE, 1, EnumDyeColor.SILVER.getDyeDamage());
        ItemStack block = new ItemStack(Blocks.STAINED_GLASS, 1, EnumDyeColor.SILVER.getMetadata());
        ItemStack pane = new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.SILVER.getMetadata());
        OreDictionary.registerOre("dye" + silver, dye);
        OreDictionary.registerOre("blockGlass" + silver, block);
        OreDictionary.registerOre("paneGlass" + silver, pane);

        registerOre(CategoryTypes.MILK, "bucket", Items.MILK_BUCKET);
        registerOre(CategoryTypes.PREFIX_CROP, "beetroot", Items.BEETROOT);
        registerOre(CategoryTypes.COOKED, "bread", Items.BREAD);
        registerOre(CategoryTypes.COOKED, "mushroomStew", Items.MUSHROOM_STEW);
        registerOre(CategoryTypes.COOKED, "beetrootSoup", Items.BEETROOT_SOUP);
        registerOre(CategoryTypes.COOKED, "potato", Items.BAKED_POTATO);
        registerOreAll(CategoryTypes.COOKED_FISH, "fish", Items.COOKED_FISH);
        registerOre(CategoryTypes.COOKED_MEAT, "cow", Items.COOKED_BEEF);
        registerOre(CategoryTypes.COOKED_MEAT, "pig", Items.COOKED_PORKCHOP);
        registerOre(CategoryTypes.COOKED_MEAT, "chicken", Items.COOKED_CHICKEN);
        registerOre(CategoryTypes.COOKED_MEAT, "sheep", Items.COOKED_MUTTON);
        registerOre(CategoryTypes.COOKED_MEAT, "rabbit", Items.COOKED_RABBIT);
        registerOre(CategoryTypes.SWEET, "cookie", Items.COOKIE);
        registerOre(CategoryTypes.SWEET, "pumpkinPie", Items.PUMPKIN_PIE);
        registerOre(CategoryTypes.SWEET, "cake", Items.CAKE);
        registerOreAll(CategoryTypes.FISH, "fish", Items.FISH);

        registerOre(CategoryTypes.PREFIX_FOOD_GOLD, "apple", new ItemStack(Items.GOLDEN_APPLE, 1, 1));
        registerOre(CategoryTypes.PREFIX_MEAT, "cow", Items.BEEF);
        registerOre(CategoryTypes.PREFIX_MEAT, "pig", Items.PORKCHOP);
        registerOre(CategoryTypes.PREFIX_MEAT, "chicken", Items.CHICKEN);
        registerOre(CategoryTypes.PREFIX_MEAT, "sheep", Items.MUTTON);
        registerOre(CategoryTypes.PREFIX_MEAT, "rabbit", Items.RABBIT);
        registerOre(CategoryTypes.PREFIX_GRAIN, "wheat", Items.WHEAT);
        registerOre(CategoryTypes.PREFIX_GRAIN, "cocoa", new ItemStack(Items.DYE, 1, EnumDyeColor.BROWN.getDyeDamage()));
        registerOre(CategoryTypes.PREFIX_FRUIT, "apple", Items.APPLE);
        registerOre(CategoryTypes.PREFIX_FRUIT, "chorus", Items.CHORUS_FRUIT);
        registerOre(CategoryTypes.PREFIX_VEGETABLE, "potato", Items.POTATO);
        registerOre(CategoryTypes.PREFIX_VEGETABLE, "carrot", Items.CARROT);
        registerOre(CategoryTypes.PREFIX_VEGETABLE, "beetroot", Items.BEETROOT);
        registerOre(CategoryTypes.PREFIX_VEGETABLE, "waterMelon", Items.MELON);
        registerOre(CategoryTypes.PREFIX_VEGETABLE, "pumpkin", Blocks.PUMPKIN);
        registerOre(CategoryTypes.PREFIX_MUSHROOM, "red", Blocks.RED_MUSHROOM);
        registerOre(CategoryTypes.PREFIX_MUSHROOM, "brown", Blocks.BROWN_MUSHROOM);
        registerOre(CategoryTypes.PREFIX_FLOWER, "dandelion", Blocks.YELLOW_FLOWER);
        registerOre(CategoryTypes.PREFIX_FLOWER, "lightBlue", new ItemStack(Blocks.RED_FLOWER, 1, BlockFlower.EnumFlowerType.BLUE_ORCHID.getMeta()));
        registerOre(CategoryTypes.PREFIX_FLOWER, "magenta", new ItemStack(Blocks.RED_FLOWER, 1, BlockFlower.EnumFlowerType.ALLIUM.getMeta()));
        registerOre(CategoryTypes.PREFIX_FLOWER, "silver", new ItemStack(Blocks.RED_FLOWER, 1, BlockFlower.EnumFlowerType.HOUSTONIA.getMeta()));
        registerOre(CategoryTypes.PREFIX_FLOWER, "red", new ItemStack(Blocks.RED_FLOWER, 1, BlockFlower.EnumFlowerType.RED_TULIP.getMeta()));
        registerOre(CategoryTypes.PREFIX_FLOWER, "orange", new ItemStack(Blocks.RED_FLOWER, 1, BlockFlower.EnumFlowerType.ORANGE_TULIP.getMeta()));
        registerOre(CategoryTypes.PREFIX_FLOWER, "silver", new ItemStack(Blocks.RED_FLOWER, 1, BlockFlower.EnumFlowerType.WHITE_TULIP.getMeta()));
        registerOre(CategoryTypes.PREFIX_FLOWER, "pink", new ItemStack(Blocks.RED_FLOWER, 1, BlockFlower.EnumFlowerType.PINK_TULIP.getMeta()));
        registerOre(CategoryTypes.PREFIX_FLOWER, "silver", new ItemStack(Blocks.RED_FLOWER, 1, BlockFlower.EnumFlowerType.OXEYE_DAISY.getMeta()));
        registerOre(CategoryTypes.PREFIX_FLOWER, "yellow", new ItemStack(Blocks.DOUBLE_PLANT, 1, BlockDoublePlant.EnumPlantType.SUNFLOWER.getMeta()));
        registerOre(CategoryTypes.PREFIX_FLOWER, "magenta", new ItemStack(Blocks.DOUBLE_PLANT, 1, BlockDoublePlant.EnumPlantType.SYRINGA.getMeta()));
        registerOre(CategoryTypes.PREFIX_FLOWER, "red", new ItemStack(Blocks.DOUBLE_PLANT, 1, BlockDoublePlant.EnumPlantType.ROSE.getMeta()));
        registerOre(CategoryTypes.PREFIX_FLOWER, "pink", new ItemStack(Blocks.DOUBLE_PLANT, 1, BlockDoublePlant.EnumPlantType.PAEONIA.getMeta()));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.CAKE), "MMM", "SES", "WWW",
                'M', CategoryTypes.MILK.getDictionaryName(""), 'S', Items.SUGAR, 'W', Items.WHEAT, 'E', Items.EGG));
    }

    public static void registerOre(CategoryType category, String name, Item ore) {
        registerOre(category, name, new ItemStack(ore));
    }

    public static void registerOreAll(CategoryType category, String name, Item ore) {
        registerOre(category, name, new ItemStack(ore, 1, OreDictionary.WILDCARD_VALUE));
    }

    public static void registerOre(CategoryType category, String name, Block ore) {
        registerOre(category, name, new ItemStack(ore));
    }

    public static void registerOreAll(CategoryType category, String name, Block ore) {
        registerOre(category, name, new ItemStack(ore, 1, OreDictionary.WILDCARD_VALUE));
    }

    public static void registerOre(CategoryType category, String name, ItemStack ore) {
        OreDictionary.registerOre(category.getDictionaryName(name), ore);
        CategoryType parent = category.getParentCategory();
        if(parent != null) {
            registerOre(parent, name, ore);
        }
    }

    public static List<ItemStack> getOres(CategoryType category, String name) {
        return getOres(category, name, true);
    }

    public static List<ItemStack> getOres(CategoryType category, String name, boolean alwaysCreateEntry) {
        return OreDictionary.getOres(category.getDictionaryName(name), alwaysCreateEntry);
    }

    public static boolean contains(ItemStack itemStack, String ore) {
        if(itemStack.isEmpty()) {
            return false;
        }
        int n = OreDictionary.getOreID(ore);
        for(int i : OreDictionary.getOreIDs(itemStack)) {
            if(n == i) {
                return true;
            }
        }
        return false;
    }
}
