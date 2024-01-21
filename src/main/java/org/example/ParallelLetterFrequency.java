package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class ParallelLetterFrequency {

    private final Map<Character, Integer> letterFrequency;

    ParallelLetterFrequency(String[] texts) {
        Map<Character, Integer> countMap = Arrays.stream(texts)
                .parallel()
                .map(text -> text.chars()
                        .filter(Character::isLetter)
                        .mapToObj(c -> (char) Character.toLowerCase(c))
                        .collect(Collectors.toMap(Function.identity(), c -> 1, Math::addExact))
                )
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toConcurrentMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        Integer::sum
                ));

        letterFrequency = Collections.unmodifiableMap(countMap);
    }

    Map<Character, Integer> countLetters() {
        return letterFrequency;
    }
}