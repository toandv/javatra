package yuck.utils;

public class Strings {
	private Strings() {

	}

	public static String requireNonNullAndEmpty(String s, String message) {
		if (isNullOrEmpty(s)) {
			throw new IllegalArgumentException(message);
		}
		return s;
	}

	public static boolean isNullOrEmpty(String s) {
		return s == null || s.isEmpty();
	}
}
