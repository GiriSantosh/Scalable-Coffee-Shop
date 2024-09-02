package net.santosh.event.source.util;

import java.util.Objects;

public final class StringUtil {

	public static boolean isValidJSONObject(String jsonObject) {
		if (jsonObject == null) {
			return false;
		}

		jsonObject = jsonObject.trim();
		if (jsonObject.isEmpty() || !jsonObject.startsWith("{") || !jsonObject.endsWith("}")) {
			return false;
		}

		return true;
	}

	private StringUtil() {}

	/**
	 * @param strObj
	 * @return
	 */
	public static boolean nullOrEmpty(String strObj) {

		return (Objects.isNull(strObj) || strObj.trim().isEmpty());
	}
}
