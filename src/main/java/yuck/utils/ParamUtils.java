package yuck.utils;

public class ParamUtils {
	private ParamUtils() {

	}

	public static boolean isPathParam(String part) {
		return part.startsWith(":");
	}
}
