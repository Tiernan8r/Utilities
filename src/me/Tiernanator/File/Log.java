package me.Tiernanator.File;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

public class Log {
	
	private PrintWriter printWriter;
	private File logFile;
	private JavaPlugin plugin;
	private String fileName;

	public Log(JavaPlugin plugin, String fileName) {

		this.plugin = plugin;
		this.fileName = fileName;
		
		createPrintWriter();
	}
	
	public Log(JavaPlugin plugin) {
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
		String time = dateFormat.format(date);
		String fileName = "log-" + time;
		
		this.fileName = fileName;
		this.plugin = plugin;
		
		createPrintWriter();
		
	}
	
	private void createPrintWriter() {
		
		JavaPlugin plugin = getPlugin();
		String fileName = getFileName();
		
		File dataFolder = new File(plugin.getDataFolder().getAbsolutePath() + File.separator + "log");
		if (!dataFolder.exists()) {
			dataFolder.mkdir();
		}

		File logFile = new File(dataFolder, fileName + ".log");
		if (!logFile.exists()) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.logFile = logFile;
		
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		try {
			fileWriter = new FileWriter(logFile);
			printWriter = new PrintWriter(fileWriter);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.printWriter = printWriter;
		
	}
	
	private PrintWriter getPrintWriter() {
		return this.printWriter;
	}

	public File getLogFile() {
		return this.logFile;
	}
	
	private JavaPlugin getPlugin() {
		return this.plugin;
	}
	
	private String getFileName() {
		return this.fileName;
	}
	
	public void log(String message) {
		log(Level.INFO, message);
	}
	
	public void log(Level level, String message) {
		
		String loggingLevel = level.getName();
		
		PrintWriter printWriter = getPrintWriter();
		if(printWriter == null) {
			createPrintWriter();
		}
		
		JavaPlugin plugin = getPlugin();
		String pluginName = plugin.getName();
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = dateFormat.format(date);
		
		String log = "[" + time + " " + loggingLevel + "]: [" +  pluginName + "] " + message;
		
		printWriter.println(log);
		printWriter.flush();
//		printWriter.close();
		
	}
	
	public void close() {
		
		PrintWriter printWriter = getPrintWriter();
		printWriter.close();
		
		File logFile = getLogFile();
		FileReader fileReader;
		try {
			fileReader = new FileReader(logFile);
			if(fileReader.ready()) {
				int numberLines = fileReader.read();
				if(numberLines == 0) {
					logFile.delete();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
