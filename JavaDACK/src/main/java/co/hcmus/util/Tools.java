package co.hcmus.util;

import flexjson.JSON;
import flexjson.JSONDeserializer;

public class Tools {
	public static <T> T fromJsonTo(String json, Class<T> valueType) {
		return new JSONDeserializer<T>().use(null, valueType).deserialize(json);

	}
}