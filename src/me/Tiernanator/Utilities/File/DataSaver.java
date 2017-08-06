package me.Tiernanator.Utilities.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.bukkit.plugin.java.JavaPlugin;

public class DataSaver {

	private File parentFile;

	public DataSaver(JavaPlugin plugin, String folderName) {

		this.parentFile = new File(plugin.getDataFolder(), folderName);
		this.parentFile.mkdirs();

	}

	private File getParentFile() {
		return this.parentFile;
	}

	public void write(Object obj, String fileName, boolean overwrite) {

		File file = new File(getParentFile(), fileName);

		try {

			if(overwrite) {
				file.delete();
			}
			
			file.createNewFile();
			
			
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(obj);
			oos.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
	
	public void write(Object obj, String fileName) {
		write(obj, fileName, true);
	}

	public Object read(String fileName) {

		File file = new File(getParentFile(), fileName);
		Object obj = null;

		if (!file.exists()) {
			return null;
		}

		try {

			FileInputStream fos = new FileInputStream(file);
			ObjectInputStream oos = new ObjectInputStream(fos);

			obj = oos.readObject();
			oos.close();

		} catch (IOException | ClassNotFoundException e) {

			e.printStackTrace();

		}

		return obj;

	}

	public void delete(String fileName) {
		
		File file = new File(getParentFile(), fileName);
		file.delete();
		
	}
	
}
