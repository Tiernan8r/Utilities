package me.Tiernanator.Materials;

public class IsMaterial {

	public static boolean isMaterial(String materialName) {

		BuildingMaterial material = BuildingMaterial
				.getBuildingMaterial(materialName);

		if (material == null) {
			return false;
		}
		return true;
	}

}
