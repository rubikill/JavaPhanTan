package co.hcmus.util;

import java.util.Collection;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

public class Tools {

	public static <T> T fromJsonTo(String json, Class<T> valueType) {
        return new JSONDeserializer<T>().use(null, valueType).deserialize(json);

    }
	public static <T> Collection<T> fromJsonToArray(String json, Class<T> valueType) {
        return new JSONDeserializer<Collection<T>>().use(null, valueType).deserialize(json);
       

    }

    public static <T> String toJsonArray(Collection<T> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }


    public static <T> String toJson(Object value) {
        return new JSONSerializer().serialize(value);
    }
}