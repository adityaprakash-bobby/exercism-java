package org.example;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
	private void incrementCountMap(String key, Map<String, Integer> countMap) {
		countMap.put(key, countMap.getOrDefault(key, 0) + 1);
	}

	public Map<String, Integer> phrase(String input) {
		Map<String, Integer> countMap = new HashMap<String, Integer>(0);

		StringBuilder word = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);

			if (!Character.isLetterOrDigit(ch) || Character.isWhitespace(ch)) {
				if (ch == '\'') {
					int nextIdx = i + 1;
					int nextNextIdx = nextIdx + 1;
					if (nextIdx > input.length() || nextNextIdx > input.length()) {
						// do nothing
					} else if (Character.isLetterOrDigit(input.charAt(nextIdx)) && !Character.isLetterOrDigit(input.charAt(nextNextIdx))) {
						word.append(ch);
					} else if (word.length() != 0){
						incrementCountMap(word.toString().toLowerCase(), countMap);
						word.delete(0, word.length());
					}
				} else if (word.length() != 0) {
					incrementCountMap(word.toString().toLowerCase(), countMap);
					word.delete(0, word.length());
				}
			} else if (Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch)){
				word.append(ch);
			}

		}
		
		if (word.length() != 0) incrementCountMap(word.toString().toLowerCase(), countMap);
		return countMap;
	}
}
