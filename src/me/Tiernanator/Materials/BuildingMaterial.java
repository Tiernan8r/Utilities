package me.Tiernanator.Materials;

import org.bukkit.Material;

public enum BuildingMaterial {

	// private static List<BuildingMaterial> allBuildingMaterials = new
	// ArrayList<BuildingMaterial>();
	//
	// public static List<BuildingMaterial> getBuildingMaterials() {
	// return allBuildingMaterials;
	// }
	//
	// public BuildingMaterial(String name, Material material,
	// MaterialData materialData) {
	// super(name, material, materialData);
	//
	// }
	//
	// public String getName() {
	// return super.getName();
	// }
	//
	// public Material getMaterial() {
	// return this.getMaterial();
	// }
	//
	// public MaterialData getMaterialData() {
	// return this.getMaterialData();
	// }
	//
	//
	// public static void generateBuildingMaterialList() {
	//
	// List<CustomMaterial> allCustomMaterials =
	// CustomMaterial.getCustomMaterials();
	// for(CustomMaterial customMaterial : allCustomMaterials) {
	//
	// Material material = customMaterial.getMaterial();
	// if(material.isBlock()) {
	//
	// String buildingMaterialName = customMaterial.getName();
	// MaterialData buildingMaterialData = customMaterial.getMaterialData();
	//
	// BuildingMaterial buildingMaterial = new
	// BuildingMaterial(buildingMaterialName, material, buildingMaterialData);
	//
	// allBuildingMaterials.add(buildingMaterial);
	// }
	//
	// }
	//
	// }
	//
	// public static BuildingMaterial getBuildingMaterial(String name) {
	//
	// CustomMaterial customMaterial = CustomMaterial.getCustomMaterial(name);
	// if(customMaterial == null) {
	// return null;
	// }
	// Material material = customMaterial.getMaterial();
	// if(!material.isBlock()) {
	// return null;
	// }
	// String buildingMaterialName = customMaterial.getName();
	// MaterialData buildingMaterialData = customMaterial.getMaterialData();
	//
	// BuildingMaterial buildingMaterial = new
	// BuildingMaterial(buildingMaterialName, material, buildingMaterialData);
	//
	// return buildingMaterial;
	//
	// }
	//
	// @SuppressWarnings("deprecation")
	// public static BuildingMaterial getBuildingMaterial(Material material,
	// byte damage) {
	//
	//// BuildingMaterial m = BuildingMaterial.ACACIA_FENCE;
	//// BuildingMaterial[] materialList = m.getDeclaringClass()
	//// .getEnumConstants();
	//
	// for (BuildingMaterial buildingMaterial : getBuildingMaterials()) {
	//
	// Material type = buildingMaterial.getMaterial();
	// MaterialData materialData = buildingMaterial.getMaterialData();
	//
	// if (type == material && (byte) materialData.getData() == damage) {
	//// String materialName = buildingMaterial.getName();
	//
	//// return new BuildingMaterial(materialName, material, materialData);
	// return buildingMaterial;
	// }
	//
	// }
	// return null;
	// }

	// blocks that aren't obtainable as items
	AIR(Material.AIR, 0), FIRE(Material.FIRE, 0),
	// and creative items
	BEDROCK(Material.BEDROCK, 0), BARRIER(Material.BARRIER, 0), COMMAND_BLOCK(
			Material.COMMAND, 0), CHAIN_COMMAND_BLOCK(Material.COMMAND_CHAIN,
					0), REPEATING_COMMAND_BLOCK(Material.COMMAND_REPEATING,
							0), MONSTER_SPAWNER(Material.MOB_SPAWNER,
									0), STRUCTURE_BLOCK(
											Material.STRUCTURE_BLOCK,
											0), STRUCTURE_VOID(
													Material.STRUCTURE_VOID, 0),

	// all the types of stone including the polished varients
	STONE(Material.STONE, 0), GRANITE(Material.STONE, 1), POLISHED_GRANITE(
			Material.STONE, 2), DIORITE(Material.STONE, 3), POLISHED_DIORITE(
					Material.STONE, 4), ANDESITE(Material.STONE,
							5), POLISHED_ANDESITE(Material.STONE, 6),

	GRASS(Material.GRASS, 0), MYCELIUM(Material.MYCEL, 0), FARM(Material.SOIL,
			0), GRASS_PATH(Material.GRASS_PATH, 0),

	// coarse dirt is a damage value of dirt as is podzol
	DIRT(Material.DIRT, 0), COARSE_DIRT(Material.DIRT, 1), PODZOL(Material.DIRT,
			2),

	COBBLESTONE(Material.COBBLESTONE, 0), COBBLESTONE_SLAB(Material.STEP,
			3), DOUBLE_COBBLESTONE_SLAB(Material.DOUBLE_STEP,
					3), COBBLESTONE_STAIRS(Material.COBBLESTONE_STAIRS,
							0), COBBLESTONE_WALL(Material.COBBLE_WALL, 0),

	OAK_WOOD_PLANKS(Material.WOOD, 0), SPRUCE_WOOD_PLANKS(Material.WOOD,
			1), BIRCH_WOOD_PLANKS(Material.WOOD, 2), JUNGLE_WOOD_PLANKS(
					Material.WOOD, 3), ACACIA_WOOD_PLANKS(Material.WOOD,
							4), DARK_OAK_WOOD_PLANKS(Material.WOOD, 5),

	OAK_SAPLING(Material.SAPLING, 0), SPRUCE_SAPLING(Material.SAPLING,
			1), BIRCH_SAPLING(Material.SAPLING, 2), JUNGLE_SAPLING(
					Material.SAPLING, 3), ACACIA_SAPLING(Material.SAPLING,
							4), DARK_OAK_SAPLING(Material.SAPLING, 5),

	SAND(Material.SAND, 0), RED_SAND(Material.SAND, 1),

	GRAVEL(Material.GRAVEL, 0),

	GOLD_ORE(Material.GOLD_ORE, 0), IRON_ORE(Material.IRON_ORE, 0), COAL_ORE(
			Material.COAL_ORE, 0), LAPIS_LAZULI_ORE(Material.LAPIS_ORE,
					0), DIAMOND_ORE(Material.DIAMOND_ORE, 0), REDSTONE_ORE(
							Material.REDSTONE_ORE, 0), GLOWING_REDSTONE_ORE(
									Material.GLOWING_REDSTONE_ORE,
									0), EMERALD_ORE(Material.EMERALD_ORE,
											0), NETHER_QUARTZ_ORE(
													Material.QUARTZ_ORE, 0),

	OAK_WOOD(Material.LOG, 0), SPRUCE_WOOD(Material.LOG, 1), BIRCH_WOOD(
			Material.LOG, 2), JUNGLE_WOOD(Material.LOG, 3), ACACIA_WOOD(
					Material.LOG_2, 0), DARK_OAK_WOOD(Material.LOG_2, 1),

	OAK_LEAVES(Material.LEAVES, 0), SPRUCE_LEAVES(Material.LEAVES,
			1), BIRCH_LEAVES(Material.LEAVES, 2), JUNGLE_LEAVES(Material.LEAVES,
					3), ACACIA_LEAVES(Material.LEAVES_2,
							0), DARK_OAK_LEAVES(Material.LEAVES_2, 1),

	SPONGE(Material.SPONGE, 0), WET_SPONGE(Material.SPONGE, 1),

	GLASS(Material.GLASS, 0),
	// All Colours are damage values
	WHITE_STAINED_GLASS(Material.STAINED_GLASS, 0), ORANGE_STAINED_GLASS(
			Material.STAINED_GLASS,
			1), MAGENTA_STAINED_GLASS(Material.STAINED_GLASS,
					2), LIGHT_BLUE_STAINED_GLASS(Material.STAINED_GLASS,
							3), YELLOW_STAINED_GLASS(Material.STAINED_GLASS,
									4), LIME_STAINED_GLASS(
											Material.STAINED_GLASS,
											5), PINK_STAINED_GLASS(
													Material.STAINED_GLASS,
													6), GREY_STAINED_GLASS(
															Material.STAINED_GLASS,
															7), LIGHT_GREY_STAINED_GLASS(
																	Material.STAINED_GLASS,
																	8), CYAN_STAINED_GLASS(
																			Material.STAINED_GLASS,
																			9), PURPLE_STAINED_GLASS(
																					Material.STAINED_GLASS,
																					10), BLUE_STAINED_GLASS(
																							Material.STAINED_GLASS,
																							11), BROWN_STAINED_GLASS(
																									Material.STAINED_GLASS,
																									12), GREEN_STAINED_GLASS(
																											Material.STAINED_GLASS,
																											13), RED_STAINED_GLASS(
																													Material.STAINED_GLASS,
																													14), BLACK_STAINED_GLASS(
																															Material.STAINED_GLASS,
																															15),

	LAPIS_LAZULI(Material.LAPIS_BLOCK, 0), LAPIS_LAZULI_BLOCK(
			Material.LAPIS_BLOCK, 0), GOLD(Material.GOLD_BLOCK, 0), GOLD_BLOCK(
					Material.GOLD_BLOCK, 0), IRON(Material.IRON_BLOCK,
							0), IRON_BLOCK(Material.IRON_BLOCK, 0), DIAMOND(
									Material.DIAMOND_BLOCK,
									0), DIAMOND_BLOCK(Material.DIAMOND_BLOCK,
											0), EMERALD(Material.EMERALD_BLOCK,
													0), EMERALD_BLOCK(
															Material.EMERALD_BLOCK,
															0), REDSTONE(
																	Material.REDSTONE_BLOCK,
																	0), REDSTONE_BLOCK(
																			Material.REDSTONE_BLOCK,
																			0), COAL(
																					Material.COAL_BLOCK,
																					0), COAL_BLOCK(
																							Material.COAL_BLOCK,
																							0),

	DISPENSER(Material.DISPENSER, 0), DROPPER(Material.DROPPER, 0),

	SANDSTONE(Material.SANDSTONE, 0), CHISELLED_SANDSTONE(Material.SANDSTONE,
			1), SMOOTH_SANDSTONE(Material.SANDSTONE, 2), SANDSTONE_STAIRS(
					Material.SANDSTONE_STAIRS, 0), SANDSTONE_SLAB(Material.STEP,
							1), DOUBLE_SANDSTONE_SLAB(Material.DOUBLE_STEP, 1),

	NOTE_BLOCK(Material.NOTE_BLOCK, 0), JUKEBOX(Material.JUKEBOX, 0),

	POWERED_RAIL(Material.POWERED_RAIL, 0), DETECTOR_RAIL(
			Material.DETECTOR_RAIL, 0), RAIL(Material.RAILS,
					0), ACTIVATOR_RAIL(Material.ACTIVATOR_RAIL, 0),

	PISTON(Material.PISTON_BASE, 0), STICKY_PISTON(Material.PISTON_STICKY_BASE,
			0),

	COBWEB(Material.WEB, 0),

	GRASS_PLANT(Material.LONG_GRASS, 1), FERN(Material.LONG_GRASS,
			2), DEAD_BUSH(Material.DEAD_BUSH, 0),

	// All Colours are damage values
	WOOL(Material.WOOL, 0), WHITE_WOOL(Material.WOOL, 0), ORANGE_WOOL(
			Material.WOOL,
			1), MAGENTA_WOOL(Material.WOOL, 2), LIGHT_BLUE_WOOL(Material.WOOL,
					3), YELLOW_WOOL(Material.WOOL, 4), LIME_WOOL(Material.WOOL,
							5), PINK_WOOL(Material.WOOL, 6), GREY_WOOL(
									Material.WOOL,
									7), LIGHT_GREY_WOOL(Material.WOOL,
											8), CYAN_WOOL(Material.WOOL,
													9), PURPLE_WOOL(
															Material.WOOL,
															10), BLUE_WOOL(
																	Material.WOOL,
																	11), BROWN_WOOL(
																			Material.WOOL,
																			12), GREEN_WOOL(
																					Material.WOOL,
																					13), RED_WOOL(
																							Material.WOOL,
																							14), BLACK_WOOL(
																									Material.WOOL,
																									15),

	// All Colours are damage values
	CARPET(Material.CARPET, 0), WHITE_CARPET(Material.CARPET, 0), ORANGE_CARPET(
			Material.CARPET,
			1), MAGENTA_CARPET(Material.CARPET, 2), LIGHT_BLUE_CARPET(
					Material.CARPET,
					3), YELLOW_CARPET(Material.CARPET, 4), LIGHT_GREEN_CARPET(
							Material.CARPET,
							5), PINK_CARPET(Material.CARPET, 6), GREY_CARPET(
									Material.CARPET,
									7), LIGHT_GREY_CARPET(Material.CARPET,
											8), CYAN_CARPET(Material.CARPET,
													9), PURPLE_CARPET(
															Material.CARPET,
															10), BLUE_CARPET(
																	Material.CARPET,
																	11), BROWN_CARPET(
																			Material.CARPET,
																			12), GREEN_CARPET(
																					Material.CARPET,
																					13), RED_CARPET(
																							Material.CARPET,
																							14), BLACK_CARPET(
																									Material.CARPET,
																									15),

	DANDELION(Material.YELLOW_FLOWER, 0), POPPY(Material.RED_ROSE,
			0), BLUE_ORCHID(Material.RED_ROSE, 1), ALLIUM(Material.RED_ROSE,
					2), AZURE_BLUET(Material.RED_ROSE, 3), RED_TULIP(
							Material.RED_ROSE,
							4), ORANGE_TULIP(Material.RED_ROSE, 5), WHITE_TULIP(
									Material.RED_ROSE, 6), PINK_TULIP(
											Material.RED_ROSE, 7), OXEYE_DAISY(
													Material.RED_ROSE, 8),

	BROWN_MUSHROOM(Material.BROWN_MUSHROOM, 0), HUGE_BROWN_MUSHROOM_STALK(
			Material.HUGE_MUSHROOM_1,
			10), HUGE_BROWN_MUSHROOM(Material.HUGE_MUSHROOM_1, 0),

	RED_MUSHROOM(Material.RED_MUSHROOM, 0), HUGE_RED_MUSHROOM_STALK(
			Material.HUGE_MUSHROOM_2,
			10), HUGE_RED_MUSHROOM(Material.HUGE_MUSHROOM_2, 0),

	STONE_SLAB(Material.STEP, 0), DOUBLE_STONE_SLAB(Material.DOUBLE_STEP, 0),

	BRICK(Material.BRICK, 0), BRICK_SLAB(Material.STEP, 4), DOUBLE_BRICK_SLAB(
			Material.DOUBLE_STEP, 4), BRICK_STAIRS(Material.BRICK_STAIRS, 0),

	TNT(Material.TNT, 0),

	BOOKSHELF(Material.BOOKSHELF, 0),

	MOSS_STONE(Material.MOSSY_COBBLESTONE,
			0), MOSSY_COBBLESTONE_WALL(Material.COBBLE_WALL, 1),

	OBSIDIAN(Material.OBSIDIAN, 0), NETHER_PORTAL(Material.PORTAL, 0),

	TORCH(Material.TORCH, 5),

	OAK_WOOD_STAIRS(Material.WOOD_STAIRS, 0), OAK_WOOD_SLAB(Material.WOOD_STEP,
			0), DOUBLE_OAK_WOOD_SLAB(Material.WOOD_DOUBLE_STEP,
					0), OAK_FENCE_GATE(Material.FENCE_GATE,
							0), OAK_FENCE(Material.FENCE, 0),

	SPRUCE_WOOD_STAIRS(Material.SPRUCE_WOOD_STAIRS, 0), SPRUCE_WOOD_SLAB(
			Material.WOOD_STEP,
			1), DOUBLE_SPRUCE_WOOD_SLAB(Material.WOOD_DOUBLE_STEP,
					1), SPRUCE_FENCE_GATE(Material.SPRUCE_FENCE_GATE,
							0), SPRUCE_FENCE(Material.SPRUCE_FENCE, 0),

	BIRCH_WOOD_STAIRS(Material.BIRCH_WOOD_STAIRS, 0), BIRCH_WOOD_SLAB(
			Material.WOOD_STEP,
			2), DOUBLE_BIRCH_WOOD_SLAB(Material.WOOD_DOUBLE_STEP,
					2), BIRCH_FENCE_GATE(Material.BIRCH_FENCE_GATE,
							0), BIRCH_FENCE(Material.BIRCH_FENCE, 0),

	JUNGLE_WOOD_STAIRS(Material.JUNGLE_WOOD_STAIRS, 0), JUNGLE_WOOD_SLAB(
			Material.WOOD_STEP,
			3), DOUBLE_JUNGLE_WOOD_SLAB(Material.WOOD_DOUBLE_STEP,
					3), JUNGLE_FENCE_GATE(Material.JUNGLE_FENCE_GATE,
							0), JUNGLE_FENCE(Material.JUNGLE_FENCE, 0),

	ACACIA_WOOD_STAIRS(Material.ACACIA_STAIRS, 0), ACACIA_WOOD_SLAB(
			Material.WOOD_STEP,
			4), DOUBLE_ACACIA_WOOD_SLAB(Material.WOOD_DOUBLE_STEP,
					4), ACACIA_FENCE_GATE(Material.ACACIA_FENCE_GATE,
							0), ACACIA_FENCE(Material.ACACIA_FENCE, 0),

	DARK_OAK_WOOD_STAIRS(Material.DARK_OAK_STAIRS, 0), DARK_OAK_WOOD_SLAB(
			Material.WOOD_STEP,
			5), DOUBLE_DARK_OAK_WOOD_SLAB(Material.WOOD_DOUBLE_STEP,
					5), DARK_OAK_FENCE_GATE(Material.DARK_OAK_FENCE_GATE,
							0), DARK_OAK_FENCE(Material.DARK_OAK_FENCE, 0),

	CHEST(Material.CHEST, 0), TRAPPED_CHEST(Material.TRAPPED_CHEST,
			0), ENDER_CHEST(Material.ENDER_CHEST, 0),

	CRAFTING_TABLE(Material.WORKBENCH, 0), FURNACE(Material.FURNACE,
			0), BURNING_FURNACE(Material.BURNING_FURNACE, 0), ANVIL(
					Material.ANVIL, 0), SLIGHTLY_DAMAGED_ANVIL(Material.ANVIL,
							1), VERY_DAMAGED_ANVIL(Material.ANVIL, 2), BEACON(
									Material.BEACON,
									0), BREWING_STAND(Material.BREWING_STAND,
											0), CAULDRON(Material.CAULDRON,
													0), ENCHANTMENT_TABLE(
															Material.ENCHANTMENT_TABLE,
															0), HOPPER(
																	Material.HOPPER,
																	0),

	LADDER(Material.LADDER, 0), VINES(Material.VINE, 0),

	LEVER(Material.LEVER, 0), STONE_BUTTON(Material.STONE_BUTTON,
			0), WOODEN_BUTTON(Material.WOOD_BUTTON, 0), STONE_PRESSURE_PLATE(
					Material.STONE_PLATE,
					0), WOODEN_PRESSURE_PLATE(Material.WOOD_PLATE,
							0), WEIGHTED_PRESSURE_PLATE_HEAVY(
									Material.IRON_PLATE,
									0), WEIGHTED_PRESSURE_PLATE_LIGHT(
											Material.GOLD_PLATE,
											0), REDSTONE_TORCH_ON(
													Material.REDSTONE_TORCH_ON,
													0), REDSTONE_TORCH_OFF(
															Material.REDSTONE_TORCH_OFF,
															0), REDSTONE_WIRE(
																	Material.REDSTONE_WIRE,
																	0), TRIPWIRE_HOOK(
																			Material.TRIPWIRE_HOOK,
																			0), STRING(
																					Material.TRIPWIRE,
																					0), DAYLIGHT_DETECTOR(
																							Material.DAYLIGHT_DETECTOR,
																							0), DAYLIGHT_DETECTOR_INVERTED(
																									Material.DAYLIGHT_DETECTOR_INVERTED,
																									0), REDSTONE_LAMP(
																											Material.REDSTONE_LAMP_OFF,
																											0), REDSTONE_LAMP_ON(
																													Material.REDSTONE_LAMP_ON,
																													0), OBSERVER(
																															Material.OBSERVER,
																															0),

	// 0-7 is the partial heights of the stacked snow layer blocks
	SNOW(Material.SNOW_BLOCK, 0), SNOW_LAYER(Material.SNOW, 0), SNOW_LAYER_1(
			Material.SNOW,
			0), SNOW_LAYER_2(Material.SNOW, 1), SNOW_LAYER_3(Material.SNOW,
					2), SNOW_LAYER_4(Material.SNOW, 3), SNOW_LAYER_5(
							Material.SNOW, 4), SNOW_LAYER_6(Material.SNOW,
									5), SNOW_LAYER_7(Material.SNOW,
											6), SNOW_LAYER_8(Material.SNOW, 7),

	ICE(Material.ICE, 0), COMPRESSED_ICE(Material.PACKED_ICE,
			0), FROSTED_ICE(Material.FROSTED_ICE, 0),

	CACTUS(Material.CACTUS, 0),

	CLAY(Material.CLAY, 0),

	PUMPKIN(Material.PUMPKIN, 0), JACK_O_LANTERN(Material.JACK_O_LANTERN,
			0), MELON(Material.MELON_BLOCK, 0),

	NETHERRACK(Material.NETHERRACK, 0), SOUL_SAND(Material.SOUL_SAND,
			0), GLOWSTONE(Material.GLOWSTONE, 0), NETHER_BRICK(
					Material.NETHER_BRICK, 0), NETHER_BRICK_STAIRS(
							Material.NETHER_BRICK_STAIRS, 0), NETHER_BRICK_SLAB(
									Material.STEP, 6), DOUBLE_NETHER_BRICK_SLAB(
											Material.DOUBLE_STEP,
											6), NETHER_BRICK_FENCE(
													Material.NETHER_FENCE,
													0), MAGMA_BLOCK(
															Material.MAGMA,
															0), NETHER_WART_BLOCK(
																	Material.NETHER_WART_BLOCK,
																	0), RED_NETHER_BRICK(
																			Material.RED_NETHER_BRICK,
																			0),

	STONE_MONSTER_EGG(Material.MONSTER_EGGS, 0), COBBLESTONE_MONSTER_EGG(
			Material.MONSTER_EGGS,
			1), STONE_BRICK_MONSTER_EGG(Material.MONSTER_EGGS,
					2), MOSSY_STONE_BRICK_MONSTER_EGG(Material.MONSTER_EGGS,
							3), CRACKED_STONE_BRICK_MONSTER_EGG(
									Material.MONSTER_EGGS,
									4), CHISELLED_STONE_BRICK_MONSTER_EGG(
											Material.MONSTER_EGGS, 5),

	STONE_BRICKS(Material.SMOOTH_BRICK, 0), STONE_BRICK_STAIRS(
			Material.SMOOTH_STAIRS,
			0), STONE_BRICK_SLAB(Material.STEP, 5), DOUBLE_STONE_BRICK_SLAB(
					Material.DOUBLE_STEP,
					5), MOSSY_STONE_BRICKS(Material.SMOOTH_BRICK,
							1), CRACKED_STONE_BRICKS(Material.SMOOTH_BRICK,
									2), CHISELLED_STONE_BRICKS(
											Material.SMOOTH_BRICK, 3),

	IRON_BARS(Material.IRON_FENCE, 0), GLASS_PANE(Material.THIN_GLASS, 0),
	// All Colours are damage values
	WHITE_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE,
			0), ORANGE_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE,
					1), MAGENTA_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE,
							2), LIGHT_BLUE_STAINED_GLASS_PANE(
									Material.STAINED_GLASS_PANE,
									3), YELLOW_STAINED_GLASS_PANE(
											Material.STAINED_GLASS_PANE,
											4), LIME_STAINED_GLASS_PANE(
													Material.STAINED_GLASS_PANE,
													5), PINK_STAINED_GLASS_PANE(
															Material.STAINED_GLASS_PANE,
															6), GREY_STAINED_GLASS_PANE(
																	Material.STAINED_GLASS_PANE,
																	7), LIGHT_GREY_STAINED_GLASS_PANE(
																			Material.STAINED_GLASS_PANE,
																			8), CYAN_STAINED_GLASS_PANE(
																					Material.STAINED_GLASS_PANE,
																					9), PURPLE_STAINED_GLASS_PANE(
																							Material.STAINED_GLASS_PANE,
																							10), BLUE_STAINED_GLASS_PANE(
																									Material.STAINED_GLASS_PANE,
																									11), BROWN_STAINED_GLASS_PANE(
																											Material.STAINED_GLASS_PANE,
																											12), GREEN_STAINED_GLASS_PANE(
																													Material.STAINED_GLASS_PANE,
																													13), RED_STAINED_GLASS_PANE(
																															Material.STAINED_GLASS_PANE,
																															14), BLACK_STAINED_GLASS_PANE(
																																	Material.STAINED_GLASS_PANE,
																																	15),

	LILY_PAD(Material.WATER_LILY, 0),

	QUARTZ(Material.QUARTZ_BLOCK, 0), QUARTZ_BLOCK(Material.QUARTZ_BLOCK,
			0), CHISELLED_QUARTZ_BLOCK(Material.QUARTZ_BLOCK,
					1), PILLAR_QUARTZ_BLOCK(Material.QUARTZ_BLOCK,
							2), QUARTZ_STAIRS(Material.QUARTZ_STAIRS,
									0), QUARTZ_SLAB(Material.STEP,
											7), DOUBLE_QUARTZ_SLAB(
													Material.DOUBLE_STEP, 7),

	HARDENED_CLAY(Material.HARD_CLAY, 0),
	// All Colours are damage values
	WHITE_HARDENED_CLAY(Material.STAINED_CLAY, 0), ORANGE_HARDENED_CLAY(
			Material.STAINED_CLAY,
			1), MAGENTA_HARDENED_CLAY(Material.STAINED_CLAY,
					2), LIGHT_BLUE_HARDENED_CLAY(Material.STAINED_CLAY,
							3), YELLOW_HARDENED_CLAY(Material.STAINED_CLAY,
									4), LIME_HARDENED_CLAY(
											Material.STAINED_CLAY,
											5), PINK_HARDENED_CLAY(
													Material.STAINED_CLAY,
													6), GREY_HARDENED_CLAY(
															Material.STAINED_CLAY,
															7), LIGHT_GREY_HARDENED_CLAY(
																	Material.STAINED_CLAY,
																	8), CYAN_HARDENED_CLAY(
																			Material.STAINED_CLAY,
																			9), PURPLE_HARDENED_CLAY(
																					Material.STAINED_CLAY,
																					10), BLUE_HARDENED_CLAY(
																							Material.STAINED_CLAY,
																							11), BROWN_HARDENED_CLAY(
																									Material.STAINED_CLAY,
																									12), GREEN_HARDENED_CLAY(
																											Material.STAINED_CLAY,
																											13), RED_HARDENED_CLAY(
																													Material.STAINED_CLAY,
																													14), BLACK_HARDENED_CLAY(
																															Material.STAINED_CLAY,
																															15),

	SLIME_BLOCK(Material.SLIME_BLOCK, 0),

	IRON_TRAPDOOR(Material.IRON_TRAPDOOR,
			0), WOODEN_TRAPDOOR(Material.TRAP_DOOR, 0),

	PRISMARINE(Material.PRISMARINE, 0), PRISMARINE_BRICKS(Material.PRISMARINE,
			1), DARK_PRISMARINE(Material.PRISMARINE,
					2), SEA_LANTERN(Material.SEA_LANTERN, 0),

	HAY_BALE(Material.HAY_BLOCK, 0),

	END_STONE(Material.ENDER_STONE, 0), END_PORTAL_FRAME(
			Material.ENDER_PORTAL_FRAME,
			0), END_PORTAL(Material.ENDER_PORTAL, 0), DRAGON_EGG(
					Material.DRAGON_EGG,
					0), END_ROD(Material.END_ROD, 0), CHORUS_PLANT(
							Material.CHORUS_PLANT,
							0), CHORUS_FLOWER(Material.CHORUS_FLOWER,
									0), PURPUR_BLOCK(Material.PURPUR_BLOCK,
											0), PURPUR_PILLAR(
													Material.PURPUR_PILLAR,
													0), PURPUR_STAIRS(
															Material.PURPUR_STAIRS,
															0), PURPUR_SLAB(
																	Material.PURPUR_SLAB,
																	0), DOUBLE_PURPUR_SLAB(
																			Material.PURPUR_DOUBLE_SLAB,
																			0), END_STONE_BRICKS(
																					Material.END_BRICKS,
																					0),

	BLACK_SHULKER_BOX(Material.BLACK_SHULKER_BOX, 0), BLUE_SHULKER_BOX(
			Material.BLUE_SHULKER_BOX,
			0), BROWN_SHULKER_BOX(Material.BROWN_SHULKER_BOX,
					0), CYAN_SHULKER_BOX(Material.CYAN_SHULKER_BOX,
							0), GREY_SHULKER_BOX(Material.GRAY_SHULKER_BOX,
									0), GREEN_SHULKER_BOX(
											Material.GREEN_SHULKER_BOX,
											0), LIGHT_BLUE_SHULKER_BOX(
													Material.LIGHT_BLUE_SHULKER_BOX,
													0), LIME_SHULKER_BOX(
															Material.LIME_SHULKER_BOX,
															0), MAGENTA_SHULKER_BOX(
																	Material.MAGENTA_SHULKER_BOX,
																	0), ORANGE_SHULKER_BOX(
																			Material.ORANGE_SHULKER_BOX,
																			0), PINK_SHULKER_BOX(
																					Material.PINK_SHULKER_BOX,
																					0), PURPLE_SHULKER_BOX(
																							Material.PURPLE_SHULKER_BOX,
																							0), RED_SHULKER_BOX(
																									Material.RED_SHULKER_BOX,
																									0), LIGHT_GREY_SHULKER_BOX(
																											Material.SILVER_SHULKER_BOX,
																											0), WHITE_SHULKER_BOX(
																													Material.WHITE_SHULKER_BOX,
																													0), YELLOW_SHULKER_BOX(
																															Material.YELLOW_SHULKER_BOX,
																															0),

	SUNFLOWER(Material.DOUBLE_PLANT, 0), LILAC(Material.DOUBLE_PLANT,
			1), DOUBLE_TALLGRASS(Material.DOUBLE_PLANT, 2), LARGE_FERN(
					Material.DOUBLE_PLANT, 3), ROSE_BUSH(Material.DOUBLE_PLANT,
							4), PEONY(Material.DOUBLE_PLANT, 5),

	RED_SANDSTONE(Material.RED_SANDSTONE, 0), CHISELLED_RED_SANDSTONE(
			Material.RED_SANDSTONE,
			1), SMOOTH_RED_SANDSTONE(Material.RED_SANDSTONE,
					2), RED_SANDSTONE_STAIRS(Material.RED_SANDSTONE_STAIRS,
							0), RED_SANDSTONE_SLAB(Material.STONE_SLAB2,
									0), DOUBLE_RED_SANDSTONE_SLAB(
											Material.DOUBLE_STONE_SLAB2, 0),

	BONE_BLOCK(Material.BONE_BLOCK, 0),

	SKULL(Material.SKULL, 0), SKELETON_SKULL(Material.SKULL,
			0), WITHER_SKELETON_SKULL(Material.SKULL, 1), ZOMBIE_HEAD(
					Material.SKULL,
					2), PLAYER_HEAD(Material.SKULL, 3), CREEPER_HEAD(
							Material.SKULL, 4), DRAGON_HEAD(Material.SKULL, 5),

	REPEATER(Material.DIODE_BLOCK_OFF,
			0), COMPARATOR(Material.REDSTONE_COMPARATOR_OFF, 0),

	OAK_DOOR(Material.WOODEN_DOOR, 0), IRON_DOOR(Material.IRON_DOOR_BLOCK,
			0), SPRUCE_DOOR(Material.SPRUCE_DOOR, 0), BIRCH_DOOR(
					Material.BIRCH_DOOR,
					0), JUNGLE_DOOR(Material.JUNGLE_DOOR, 0), ACACIA_DOOR(
							Material.ACACIA_DOOR,
							0), DARK_OAK_DOOR(Material.DARK_OAK_DOOR, 0),

	CAKE(Material.CAKE_BLOCK, 0), SUGAR_CANE(Material.SUGAR_CANE_BLOCK, 0),

	CONCRETE_POWDER(Material.CONCRETE_POWDER, 0), WHITE_CONCRETE_POWDER(
			Material.CONCRETE_POWDER,
			0), ORANGE_CONCRETE_POWDER(Material.CONCRETE_POWDER,
					1), MAGENTA_CONCRETE_POWDER(Material.CONCRETE_POWDER,
							2), LIGHT_BLUE_CONCRETE_POWDER(
									Material.CONCRETE_POWDER,
									3), YELLOW_CONCRETE_POWDER(
											Material.CONCRETE_POWDER,
											4), LIME_CONCRETE_POWDER(
													Material.CONCRETE_POWDER,
													5), PINK_CONCRETE_POWDER(
															Material.CONCRETE_POWDER,
															6), GREY_CONCRETE_POWDER(
																	Material.CONCRETE_POWDER,
																	7), LIGHT_GREY_CONCRETE_POWDER(
																			Material.CONCRETE_POWDER,
																			8), CYAN_CONCRETE_POWDER(
																					Material.CONCRETE_POWDER,
																					9), PURPLE_CONCRETE_POWDER(
																							Material.CONCRETE_POWDER,
																							10), BLUE_CONCRETE_POWDER(
																									Material.CONCRETE_POWDER,
																									11), BROWN_CONCRETE_POWDER(
																											Material.CONCRETE_POWDER,
																											12), GREEN_CONCRETE_POWDER(
																													Material.CONCRETE_POWDER,
																													13), RED_CONCRETE_POWDER(
																															Material.CONCRETE_POWDER,
																															14), BLACK_CONCRETE_POWDER(
																																	Material.CONCRETE_POWDER,
																																	15),

	CONCRETE(Material.CONCRETE, 0), WHITE_CONCRETE(Material.CONCRETE,
			0), ORANGE_CONCRETE(Material.CONCRETE, 1), MAGENTA_CONCRETE(
					Material.CONCRETE,
					2), LIGHT_BLUE_CONCRETE(Material.CONCRETE,
							3), YELLOW_CONCRETE(Material.CONCRETE,
									4), LIME_CONCRETE(Material.CONCRETE,
											5), PINK_CONCRETE(Material.CONCRETE,
													6), GREY_CONCRETE(
															Material.CONCRETE,
															7), LIGHT_GREY_CONCRETE(
																	Material.CONCRETE,
																	8), CYAN_CONCRETE(
																			Material.CONCRETE,
																			9), PURPLE_CONCRETE(
																					Material.CONCRETE,
																					10), BLUE_CONCRETE(
																							Material.CONCRETE,
																							11), BROWN_CONCRETE(
																									Material.CONCRETE,
																									12), GREEN_CONCRETE(
																											Material.CONCRETE,
																											13), RED_CONCRETE(
																													Material.CONCRETE,
																													14), BLACK_CONCRETE(
																															Material.CONCRETE,
																															15),

	GLAZED_TERRACOTTA(Material.WHITE_GLAZED_TERRACOTTA,
			0), WHITE_GLAZED_TERRACOTTA(Material.WHITE_GLAZED_TERRACOTTA,
					0), ORANGE_GLAZED_TERRACOTTA(
							Material.ORANGE_GLAZED_TERRACOTTA,
							0), MAGENTA_GLAZED_TERRACOTTA(
									Material.MAGENTA_GLAZED_TERRACOTTA,
									0), LIGHT_BLUE_GLAZED_TERRACOTTA(
											Material.LIGHT_BLUE_GLAZED_TERRACOTTA,
											0), YELLOW_GLAZED_TERRACOTTA(
													Material.YELLOW_GLAZED_TERRACOTTA,
													0), LIME_GLAZED_TERRACOTTA(
															Material.LIME_GLAZED_TERRACOTTA,
															0), PINK_GLAZED_TERRACOTTA(
																	Material.PINK_GLAZED_TERRACOTTA,
																	0), GREY_GLAZED_TERRACOTTA(
																			Material.GRAY_GLAZED_TERRACOTTA,
																			0), LIGHT_GREY_GLAZED_TERRACOTTA(
																					Material.SILVER_GLAZED_TERRACOTTA,
																					0), CYAN_GLAZED_TERRACOTTA(
																							Material.CYAN_GLAZED_TERRACOTTA,
																							0), PURPLE_GLAZED_TERRACOTTA(
																									Material.PURPLE_GLAZED_TERRACOTTA,
																									0), BLUE_GLAZED_TERRACOTTA(
																											Material.BLUE_GLAZED_TERRACOTTA,
																											0), BROWN_GLAZED_TERRACOTTA(
																													Material.BROWN_GLAZED_TERRACOTTA,
																													0), GREEN_GLAZED_TERRACOTTA(
																															Material.GREEN_GLAZED_TERRACOTTA,
																															0), RED_GLAZED_TERRACOTTA(
																																	Material.RED_GLAZED_TERRACOTTA,
																																	0), BLACK_GLAZED_TERRACOTTA(
																																			Material.BLACK_GLAZED_TERRACOTTA,
																																			0),

	LAVA(Material.STATIONARY_LAVA, 0), WATER(Material.STATIONARY_WATER, 0);

	public static BuildingMaterial getBuildingMaterial(Material material,
			byte damage) {

		for (BuildingMaterial buildingMaterial : values()) {

			Material type = buildingMaterial.getMaterial();

			if (type == material && buildingMaterial.getDamage() == damage) {

				return buildingMaterial;
				// return new BuildingMaterial(materialName, material,
				// materialData);
			}

		}
		return null;
	}
	public static BuildingMaterial getBuildingMaterial(String materialName) {

		BuildingMaterial material = BuildingMaterial.ACACIA_FENCE;
		BuildingMaterial[] materialList = material.getDeclaringClass()
				.getEnumConstants();

		for (BuildingMaterial m : materialList) {

			if (m.toString().equalsIgnoreCase(materialName)) {
				return m;
			}

		}
		return null;
	}

	private Material material;

	private int damage;

	private BuildingMaterial(Material material, int damage) {
		this.material = material;
		this.damage = damage;
	}

	public byte getDamage() {

		return (byte) damage;

	}

	public Material getMaterial() {

		return Material.getMaterial(material.name());

	}

	public String getMaterialName() {

		return material.name();

	}
}
