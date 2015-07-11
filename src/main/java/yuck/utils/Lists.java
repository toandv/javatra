package yuck.utils;

import java.util.ArrayList;
import java.util.List;

public class Lists {
	public static List<String> splitString(String string, String regex) {
		List<String> result = new ArrayList<>();
		String[] array = string.split(regex);
		for (String s : array) {
			if (!s.isEmpty()) {
				result.add(s);
			}
		}
		return result;
	}
}
