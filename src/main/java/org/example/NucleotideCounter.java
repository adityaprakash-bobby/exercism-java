package org.example;

import java.util.HashMap;
import java.util.Map;

public class NucleotideCounter {
	private Map<Character, Integer> nucleotideCount = new HashMap<>(Map.of('A', 0, 'C', 0, 'G', 0, 'T', 0));

	NucleotideCounter(String sequence) {

		for (int i = 0; i < sequence.length(); i++) {
			char ch = sequence.charAt(i);
			if (!nucleotideCount.containsKey(ch))
				throw new IllegalArgumentException();

			nucleotideCount.merge(ch, 1, Integer::sum);
		}
	}

	int count(char base) {
		if (!nucleotideCount.containsKey(base))
			throw new IllegalArgumentException();

		return nucleotideCount.get(base);
	}

	Map<Character, Integer> nucleotideCounts() {
		return Map.copyOf(nucleotideCount);
	}
}
