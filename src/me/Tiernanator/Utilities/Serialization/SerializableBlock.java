package me.Tiernanator.Utilities.Serialization;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import me.Tiernanator.Utilities.Materials.BuildingMaterial;

public class SerializableBlock extends SerializableLocation {

	private static final long serialVersionUID = -9109128300223718823L;
	
	private BuildingMaterial buildingMaterial;
	
	public SerializableBlock(BuildingMaterial buildingMaterial, Location location) {
		
		super(location);
		
		this.buildingMaterial = buildingMaterial;
		
	}
	
	public BuildingMaterial getBuildingMaterial() {
		return this.buildingMaterial;
	}
	
	public Block getBlock() {
		return asLocation().getBlock();
	}
	
	@SuppressWarnings("deprecation")
	public static SerializableBlock fromBlock(Block block) {
		
		Material material = block.getType();
		int damage = block.getData();
		BuildingMaterial buildingMaterial  = new BuildingMaterial(material, damage);
		Location location = block.getLocation();
		
		SerializableBlock serializableBlock = new SerializableBlock(buildingMaterial, location);
		return serializableBlock;
		
	}
	
	public static List<SerializableBlock> convertToSerializablBlock(List<Block> originalList) {
		
		List<SerializableBlock> serializedArray = new ArrayList<SerializableBlock>();
		for(Block block : originalList) {
			SerializableBlock sBlock = fromBlock(block);
			serializedArray.add(sBlock);
		}
		
		return serializedArray;
		
	}
	
	public static List<Block> convertFromSerializableBlock(List<SerializableBlock> originalList) {
		
		List<Block> serializedArray = new ArrayList<Block>();
		for(SerializableBlock sBlock : originalList) {
			Block block = sBlock.getBlock();
			serializedArray.add(block);
		}
		
		return serializedArray;
		
	}
	
	@Override
	public String toString() {
		
		String location = super.toString();
		String buildingMaterial = getBuildingMaterial().toString();
		
		return location + ":" + buildingMaterial;
		
	}
	
}
