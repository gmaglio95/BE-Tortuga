package it.tortuga.beans;

import java.lang.reflect.Field;

public class TortugaUtility {

	private TortugaUtility() {
	}

	/**
	 * @author gmaglio
	 * 
	 * @param fieldParent
	 *            Passare come parametro il bean dove è dichiarato il nome del
	 *            campo da recuperare
	 * @param fieldValue
	 *            Passare il valore del campo di cui si vuole recuperare il
	 *            nome(dichiarazione attributo)
	 * @return il nome del campo del valore fieldValue
	 * 
	 */
	public static String getFieldName(Object fieldParent, Object fieldValue) {
		String nameField = null;
		for (Field field : fieldParent.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			try {
				if (field.get(fieldParent) != null && field.get(fieldParent).equals(fieldValue)) {
					nameField = field.getName();
					break;
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// }
		}
		if (nameField == null) {
			for (Field field : fieldParent.getClass().getSuperclass().getDeclaredFields()) {
				field.setAccessible(true);
				try {
					if (field.get(fieldParent) != null && field.get(fieldParent).equals(fieldValue)) {
						nameField = field.getName();
						break;
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// }
			}
		}
		return nameField;

	}
}
