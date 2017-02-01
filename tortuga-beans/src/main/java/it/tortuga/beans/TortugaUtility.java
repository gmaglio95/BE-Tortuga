package it.tortuga.beans;

import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

	public static String getMD5Value(String password) {
		String passwordCripted = "";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			passwordCripted = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return passwordCripted;
	}

}
