/*
* Copyright (C) 2012
*
* Permission is hereby granted, free of charge, to any person obtaining a copy 
* of this software and associated documentation files (the "Software"), to deal 
* in the Software without restriction, including without limitation the rights 
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
* copies of the Software, and to permit persons to whom the Software is 
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
* OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.IN NO EVENT SHALL THE 
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE 
* SOFTWARE.
*/
package me.Tiernanator.File;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
/*
 * This class handles multiple configs by mimicking the in built methods for the 
 * generic config file, bt allowing it to work with any file name
 */
public class ConfigAccessor {

	// the name of the config file
	private final String fileName;
	// the plugin
	private final JavaPlugin plugin;

	// the actual config file
	private File configFile;

	// the data contained within the file
	private FileConfiguration fileConfiguration;

	// constructor for the class, take the plugin & the file name of the file to
	// get
	public ConfigAccessor(JavaPlugin plugin, String fileName) {
		// if the plugin doesn't exist
		if (plugin == null)
			// can't work
			throw new IllegalArgumentException("plugin cannot be null");

		// otherwise the plugin contains a value, and set the internal variable
		// to equal it
		this.plugin = plugin;
		// the same for the file name
		this.fileName = fileName;
		// get the folder containing the file
		File dataFolder = plugin.getDataFolder();
		// throw an error if there is no folder
		if (dataFolder == null)
			throw new IllegalStateException();

		// the file by name from the folder & save it to the variable for later
		// access
		this.configFile = new File(dataFolder, fileName);
	}

	// constructor for the class, take the plugin & the file name of the file to
	// get
	/**
	 * 
	 * @param plugin
	 *            The JavaPlugin instance whose folder will be used for the file
	 * @param fileName
	 *            The name of the config file you want to access
	 * @param folderName
	 *            The name of the sub folder the fiile will be in, including the
	 *            initial \
	 */
	public ConfigAccessor(JavaPlugin plugin, String fileName,
			String folderName) {
		// if the plugin doesn't exist
		if (plugin == null)
			// can't work
			throw new IllegalArgumentException("plugin cannot be null");

		// otherwise the plugin contains a value, and set the internal variable
		// to equal it
		this.plugin = plugin;
		// the same for the file name
		this.fileName = fileName;
		// get the folder containing the file
		File dataFolder = new File(plugin.getDataFolder().toString()
				+ File.separator + folderName);
		// throw an error if there is no folder
		// if (dataFolder == null)
		// throw new IllegalStateException();

		// the file by name from the folder & save it to the variable for later
		// access
		this.configFile = new File(dataFolder, fileName);
	}

	// return the config file
	public FileConfiguration getConfig() {
		// if it's empty, it gets reset with a default valu
		if (fileConfiguration == null) {
			this.reloadConfig();
		}
		// otherwise it's not empty & return the data contained inside
		return fileConfiguration;
	}
	// handles reloads
	public void reloadConfig() {
		// load the data from the file
		fileConfiguration = YamlConfiguration.loadConfiguration(configFile);

		// Look for defaults in the jar
		// InputStream defConfigStream =
		// plugin.getResource(plugin.getDataFolder() + fileName);
		InputStream defConfigStream = plugin.getResource(fileName);

		// if there are defaults
		if (defConfigStream != null) {
			// load the default
			YamlConfiguration defConfig = YamlConfiguration
					.loadConfiguration(new InputStreamReader(defConfigStream));
			// set the data in the file to the default data, i.e reload it from
			// memory
			fileConfiguration.setDefaults(defConfig);
		}
	}
	// handles saving the config
	public void saveConfig() {
		// If they contain values
		if (fileConfiguration != null && configFile != null) {
			// try to save the values to file
			try {
				getConfig().save(configFile);
				// catch any errors
			} catch (IOException ex) {
				plugin.getLogger().log(Level.SEVERE,
						"Could not save config to " + configFile, ex);
			}
		}
	}
	// as the name suggests, saves the defaults
	public void saveDefaultConfig() {
		// if the file doesn't exist
		if (!configFile.exists()) {
			// save a blank file
			this.plugin.saveResource(fileName, false);
		}
	}

}