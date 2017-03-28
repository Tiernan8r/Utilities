package me.Tiernanator.Materials;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import org.bukkit.Material;
//import org.bukkit.block.Block;
//import org.bukkit.block.BlockState;
//import org.bukkit.material.MaterialData;
//
public class CustomMaterial {
//
//	private static List<CustomMaterial> allCustomMaterials = new ArrayList<CustomMaterial>();
//	private static HashMap<String, CustomMaterial> customMaterialMap = new HashMap<String, CustomMaterial>();
//
//	public static List<CustomMaterial> getCustomMaterials() {
//		return allCustomMaterials;
//	}
//
//	private String name;
//	private MaterialData materialData;
//	private Material material;
//
//	public CustomMaterial(String name, Material material,
//			MaterialData materialData) {
//		this.name = name;
//		this.material = material;
//		this.materialData = materialData;
//	}
//
//	public String getName() {
//		return this.name;
//	}
//
//	public Material getMaterial() {
//		return this.material;
//	}
//
//	public MaterialData getMaterialData() {
//		return this.materialData;
//	}
//
//	public static HashMap<String, CustomMaterial> getCustomMaterialMap() {
//		return customMaterialMap;
//	}
//
//	public static Block setBlock(Block block, CustomMaterial customMaterial) {
//
//		block.setType(customMaterial.getMaterial());
//
//		BlockState blockState = block.getState();
//		blockState.setData(customMaterial.getMaterialData());
//		blockState.update(true);
//
//		return block;
//
//	}
//
//	@SuppressWarnings({"deprecation"})
//	public static void generateMaterialList() {
//
//		//Store all the material names and object values;
//		List<String> allCustomMaterialNames = new ArrayList<String>();
//		List<CustomMaterial> allCustomMaterials = new ArrayList<CustomMaterial>();
//
//		//Iterate over all in game materials
//		for (Material material : Material.values()) {
//
//			//get the available materialdata for the material
//			MaterialData materialData = material.getNewData((byte) 0);
//
//			//Store the names of any sub items in the material e.g. red wool, blue wool, etc...
//			List<String> thisMaterialsNames = new ArrayList<String>();
//			//A hashmap of the customMaterial to the item name
//			HashMap<String, CustomMaterial> thisCustomMaterialMap = new HashMap<String, CustomMaterial>();
//
//			//Iterate over the 16 available data values to represent colour and etc in blocks
//			for (int i = 0; i < 16; i++) {
//				//Get the data
//				materialData.setData((byte) i);
//				//Get the itemname based off the data
//				String customMaterialName = generateCustomMaterialName(
//						materialData);
//				//If the name doesn't exist we can't use it
//				if (customMaterialName == null) {
//					continue;
//				}
//				//Add it to the list of current names
//				thisMaterialsNames.add(customMaterialName);
//				//Generat a customMaterial based off the data and add it to the hashmap with the name as key
//				CustomMaterial customMaterial = new CustomMaterial(
//						customMaterialName, material, materialData);
//				thisCustomMaterialMap.put(customMaterialName, customMaterial);
//
//			}
//			//Iterate over the names saved previously from subtypes
//			for (String i : thisMaterialsNames) {
//				//An item called nul is useless to me.
//				if (i.contains("null")) {
//					continue;
//				}
//				//If there isn't already an item in the core list called this one, add it:
//				if (!(allCustomMaterialNames.contains(i))) {
//					allCustomMaterialNames.add(i);
//					//Add put the customMaterial into the core hashMap aswell
//					CustomMaterial customMaterial = thisCustomMaterialMap
//							.get(i);
//					allCustomMaterials.add(customMaterial);
//				}
//
//			}
//		}
//		//Assign the variable
//		CustomMaterial.allCustomMaterials = allCustomMaterials;
//		//Now iterate over all of the generated items
//		for (int i = 0; i < allCustomMaterials.size(); i++) {
//			//Get it's name
//			String materialName = allCustomMaterialNames.get(i);
//			//Get it's custom data
//			CustomMaterial customMaterial = allCustomMaterials.get(i);
//			//If any value is unassigned, it's useless
//			if (materialName == null || customMaterial == null) {
//				continue;
//			}
//			//Put it in the core map
//			customMaterialMap.put(materialName, customMaterial);
//		}
//	}
//
//	private static String generateCustomMaterialName(
//			MaterialData materialData) {
//
//		String name = null;
//		try {
//			name = materialData.toString();
//		} catch (Exception e) {
//			Material material = materialData.getItemType();
//			name = material.name();
//		}
//		// Bukkit.getLogger().log(Level.INFO, name);
//		if (name.contains("(")) {
//			name = name.substring(0, name.indexOf("("));
//		}
//		name = name.replace(" ", "_");
//		// Chesck if the name is one that conceivably has a block associated
//		// with it:
//		if (name.contains("decayable") && name.contains("leaves")) {
//			return null;
//		}
//		if (name.contains("null")) {
//			return null;
//		}
//		if (name.contains("_INSTANT_GROWABLE_")) {
//			return null;
//		}
//		if (name.contains("UP") || name.contains("Down")
//				|| name.contains("North") || name.contains("South")
//				|| name.contains("West") || name.contains("East")) {
//			return null;
//		}
//
//		// Oak items are called Generic when it comes to wood
//		name = name.replace("GENERIC", "OAK");
//		// Similar for spruce and redwood...
//		name = name.replace("REDWOOD", "SPRUCE");
//		//All leaves are decayable as far as I'm concerned...
//		name = name.replace("_DECAYABLE_", "");
//		name = name.replace("_DECAYING_", "");
//		//Empty braces are a result of name editting and aren't needed
//		name = name.replace("_[]", "");
//
//		name = name.toUpperCase();
//		return name;
//
//	}
//
//	public static CustomMaterial getCustomMaterial(String name) {
//
//		if (customMaterialMap.containsKey(name)) {
//			return customMaterialMap.get(name);
//		}
//		return null;
//
//	}
//
}
