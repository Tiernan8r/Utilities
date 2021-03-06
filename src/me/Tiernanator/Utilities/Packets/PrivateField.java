package me.Tiernanator.Utilities.Packets;

import org.bukkit.Bukkit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class PrivateField {

	@SuppressWarnings("rawtypes")
	public static Object getPrivateField(String fieldName, Class clazz,
			Object object) {

		Field field;
		Object obj = null;
		try {
			field = clazz.getDeclaredField(fieldName);
			field.setAccessible(true);
			obj = field.get(object);
			for (Annotation a : field.getAnnotations()) {
				Bukkit.getServer().broadcastMessage(a.toString());
			}
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;

	}
}
