package co.hcmus.shopcamera.utility;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

/**
 * This class use for convert between JSon and Object
 * @author Thanh Toan
 *
 */
public class Tools {

	/**
	 * Convert from JSon to an Object
	 * @param json JSon to convert
	 * @param valueType type of class
	 * @return Converted object
	 */
	public static <T> T fromJsonTo(String json, Class<T> valueType) {
		return new JSONDeserializer<T>().use(null, valueType).deserialize(json);
	}

	/**
	 * Convert from JSon to an array
	 * @param json JSon to convert
	 * @param valueType type of class
	 * @return Converted array
	 */
	public static <T> Collection<T> fromJsonToArray(String json, Class<T> valueType) {
		return new JSONDeserializer<Collection<T>>().deserialize(json);
	}

	/**
	 * Convert collection to JSon
	 * @param collection collection to convert
	 * @return JSon
	 */
	public static <T> String toJsonArray(Collection<T> collection) {
		return new JSONSerializer().exclude("*.class").serialize(collection);
	}

	/**
	 * Convert Object to JSon
	 * @param value Object to convert
	 * @return JSon
	 */
	public static <T> String toJson(Object value) {
		return new JSONSerializer().serialize(value);
	}
	
	public static Date formatDate(String date, String format){
		try {
			return new SimpleDateFormat(format).parse(date);
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return null;
	}
}