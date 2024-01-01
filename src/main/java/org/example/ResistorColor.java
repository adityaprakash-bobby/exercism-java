package org.example;

import java.util.HashMap;
import java.util.Map;

class ResistorColor {
	private static String[] colors = { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey",
			"white" };

	private static Map<String, Integer> colorMap = new HashMap<>(colors.length);

	static {
		for (int i = 0; i < colors.length; i++) {
			colorMap.put(colors[i], i);
		}
	}

	int colorCode(String color) {
		return colorMap.get(color);
	}

	String[] colors() {
		return colors.clone();
	}
}