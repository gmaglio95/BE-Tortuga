package it.tortuga.beans;

import java.lang.reflect.Field;

public class TortugaUtility {

	private TortugaUtility() {
	}

	/**
	 * 
	 * @author gmaglio
	 * @param obj
	 * @param clazz
	 * @return
	 */

	public static String getFieldName(Object obj, Class<?> clazz) {
		String nameField = null;
		for (Field field : obj.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			if (field.getType().equals(clazz)) {
				nameField = field.getName();
			}
		}
		return nameField;

	}
}
