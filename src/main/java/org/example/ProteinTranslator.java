package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProteinTranslator {

	private static final Map<String, String> codonProteinMap = new HashMap<>();
	private static final String[] codons = { "AUG", "UUU,UUC", "UUA,UUG", "UCU,UCC,UCA,UCG", "UAU,UAC", "UGU,UGC",
			"UGG", "UAA,UAG,UGA" };
	private static final String[] proteins = { "Methionine", "Phenylalanine", "Leucine", "Serine", "Tyrosine",
			"Cysteine", "Tryptophan", "STOP" };
	static {
		for (int i = 0; i < codons.length; i++) {
			for (String codon : codons[i].split(",")) {
				codonProteinMap.put(codon, proteins[i]);
			}
		}
	}

	List<String> translate(String rnaSequence) {
		List<String> result = new ArrayList<>();
		int subSequenceLength = 3;
		for (int i = 0; i <= rnaSequence.length() - subSequenceLength; i += 3) {
			String codon = rnaSequence.substring(i, i + subSequenceLength);
			String protein = codonProteinMap.get(codon);

			if (protein.equals("STOP"))
				break;

			result.add(protein);
		}

		return result;
	}
}
