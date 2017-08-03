package me.Tiernanator.Utilities.Materials;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.Material;

import me.Tiernanator.Utilities.UtilitiesMain;
import me.Tiernanator.Utilities.Colours.Colour;
import me.Tiernanator.Utilities.File.ConfigAccessor;
import me.Tiernanator.Utilities.Locations.Zones.ZoneName;

public class BuildingMaterial {

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

		allBuildingMaterials = new ArrayList<BuildingMaterial>();

		ConfigAccessor configAccessor = new ConfigAccessor(plugin,
				"buildingMaterials.yml");
		
		List<String> materialsToIgnore = configAccessor.getConfig()
				.getStringList("IGNORE");
		
		if(materialsToIgnore == null) {
			materialsToIgnore = new ArrayList<String>();
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
				subMaterialName = ZoneName.parseNameToZoneCode(subMaterialName);
				
				BuildingMaterial buildingMaterial = new BuildingMaterial(
						material, damage, subMaterialName);
				allBuildingMaterials.add(buildingMaterial);
			}

		}

		return allBuildingMaterials;

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

		if (material == null) {
			return false;
		}
		return true;
	}

}
