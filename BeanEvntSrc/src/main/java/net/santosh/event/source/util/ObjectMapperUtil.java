package net.santosh.event.source.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletInputStream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtil {

	private static final ObjectMapper mapper = new ObjectMapper();

	/**
	 * @author santosh
	 * @param jsonObject
	 * @param clazz
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> T toObject(String jsonObject, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(jsonObject, clazz);
	}

	/**
	 * @author santosh
	 * @param inputStream
	 * @param clazz
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> T toObject(ServletInputStream inputStream, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(convertToString(inputStream), clazz);
	}

	/**
	 * @author santosh
	 * @param is
	 * @return
	 */
	public static String convertToString(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			//supressing exception
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {}
			}
		}
		return sb.toString();
	}

	/**
	 * @author santosh
	 * @param requestParams
	 * @param clazz
	 * @return
	 */
	public static <T> T toObject(Map<String, Object> requestParams, Class<T> clazz) {
		return mapper.convertValue(requestParams, clazz);
	}

	/**
	 * convert into Json String
	 */
	public static String toString(Object classObject) throws JsonProcessingException {
		return mapper.writeValueAsString(classObject);
	}

	public static Map<String, Object> toMap(String jsonInStringType) throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(jsonInStringType, new TypeReference<HashMap<String, Object>>() {});
	}

	public static <T> T toGenericMap(String jsonInStringType, T type) throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(jsonInStringType, new TypeReference<T>() {});
	}
}
