package me.Tiernanator.Utilities.Materials;

import me.Tiernanator.Utilities.Colours.Colour;
import me.Tiernanator.Utilities.File.ConfigAccessor;
import me.Tiernanator.Utilities.UtilitiesMain;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

public class BuildingMaterial implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3723434881243663240L;
	
	private static UtilitiesMain plugin;
	private static List<BuildingMaterial> allBuildingMaterials;

	public static void setPlugin(UtilitiesMain main) {
		plugin = main;
	}

	private Material material;
	private byte damage;
	private String name;

	public BuildingMaterial(Material material, byte damage) {

		this(material, damage, material.name());

	}

	public BuildingMaterial(Material material, int damage) {

		this(material, damage, material.name());

	}

	public BuildingMaterial(Material material, int damage, String name) {

		this.material = material;
		this.damage = (byte) damage;
		this.name = name;

	}

	@SuppressWarnings("deprecation")
	public BuildingMaterial(Block block) {
		this(block.getType(), block.getData());
	}
	
	public Material getMaterial() {
		return this.material;
	}

	public byte getDamage() {
		return this.damage;
	}

	public String getName() {
		return this.name;
	}

	public static List<BuildingMaterial> allBuildingMaterials() {

		if (allBuildingMaterials != null) {
			return allBuildingMaterials;
		}

		allBuildingMaterials = new LinkedList<BuildingMaterial>();

		ConfigAccessor configAccessor = new ConfigAccessor(plugin,
				"buildingMaterials.yml");

		List<String> materialsToIgnore = configAccessor.getConfig()
				.getStringList("IGNORE");

		if(materialsToIgnore == null) {
			materialsToIgnore = new LinkedList<>();
		}

		for (Material material : Material.ACACIA_DOOR.getClass()
				.getEnumConstants()) {

			String materialName = material.name();

			if (!material.isBlock() || materialsToIgnore.contains(materialName)) {
				continue;
			}

			List<String> subMaterialNames = configAccessor.getConfig()
					.getStringList("INCLUDE." + materialName);
			if (subMaterialNames == null || subMaterialNames.isEmpty()) {
				allBuildingMaterials.add(new BuildingMaterial(material, 0));
			}

			for (int i = 0; i < subMaterialNames.size(); i++) {

				int damage = i;

				String subMaterialName = subMaterialNames.get(i);
				String[] parts = subMaterialName.split(":");
				if (parts.length > 1) {
					subMaterialName = parts[0];
					try {
						damage = Integer.parseInt(parts[1]);
					} catch (Exception e) {
						plugin.getLogger().log(Level.WARNING,
								Colour.WARNING.getColourCode()
										+ "Could not read damage data '"
										+ parts[1] + "' from file for Material "
										+ subMaterialName);
					}

				}

				subMaterialName = subMaterialName.toUpperCase();
				subMaterialName = subMaterialName.replace("_", " ");

				BuildingMaterial buildingMaterial = new BuildingMaterial(
						material, damage, subMaterialName);
				allBuildingMaterials.add(buildingMaterial);
			}

		}

		return allBuildingMaterials;

	}

	@SuppressWarnings("deprecation")
	public static BuildingMaterial getBuildingMaterial(Block block) {

		return getBuildingMaterial(block.getType(), block.getData());

	}

	public static BuildingMaterial getBuildingMaterial(String materialName) {

		List<BuildingMaterial> allBuildingMaterials = allBuildingMaterials();
		for (BuildingMaterial buildingMaterial : allBuildingMaterials) {
			String name = buildingMaterial.getName();
			if (name.equalsIgnoreCase(materialName)) {
				return buildingMaterial;
			}
		}
		return null;

	}

	public static BuildingMaterial getBuildingMaterial(Material material,
			int damage) {

		List<BuildingMaterial> allBuildingMaterials = allBuildingMaterials();
		for (BuildingMaterial buildingMaterial : allBuildingMaterials) {

			Material bMaterial = buildingMaterial.getMaterial();
			byte bDamage = buildingMaterial.getDamage();

			if (bMaterial == material && bDamage == (byte) damage) {
				return buildingMaterial;
			}

		}

		return null;

	}

	public static boolean isMaterial(String materialName) {

		BuildingMaterial material = BuildingMaterial
				.getBuildingMaterial(materialName);

		return material != null;
	}

	public void setIgnoreDamage() {
		this.damage = -1;
	}

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof BuildingMaterial)) {
			return false;
		}
		BuildingMaterial toCompare = (BuildingMaterial) object;

		Material thisMaterial = getMaterial();
		Material compareMaterial = toCompare.getMaterial();

		if (thisMaterial != compareMaterial) {
			return false;
		}

		int thisDamage = getDamage();
		int compareDamage = toCompare.getDamage();

		return thisDamage < 0 || compareDamage < 0 || thisDamage == compareDamage;

	}
	
	@Override
	public String toString() {
		
		String materialName = getMaterial().name();
		materialName += ":" + getDamage();
		return materialName;
		
	}
	
}
