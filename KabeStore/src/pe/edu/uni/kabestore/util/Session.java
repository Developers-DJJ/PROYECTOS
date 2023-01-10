package pe.edu.uni.kabestore.util;

import java.util.HashMap;
import java.util.Map;

public class Session {
    private static Map<String, Object> datos;

	static {
		datos = new HashMap<>();
	}

	private Session() {
	}

	public static void put(String key, Object object) {
		datos.put(key, object);
	}

	public static Object get(String key) {
		return datos.get(key);
	}
}
