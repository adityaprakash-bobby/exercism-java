package org.example;

import java.util.ArrayList;
import java.util.List;

class Series {
    private final String number;

    Series(String string) {
        this.number = string;
    }

    List<String> slices(int num) {
        if (num <= 0) throw new IllegalArgumentException("Slice size is too small.");
        if (num > number.length()) throw new IllegalArgumentException("Slice size is too big.");

        List<String> result = new ArrayList<>(number.length() - num + 1);
        StringBuilder slice = new StringBuilder(num);

        // add the first slice
        for (int i = 0; i < num; i++) {
            slice.append(number.charAt(i));
        }
        result.add(slice.toString());

        // for the rest of slice, remove the first letter and append the next
        // letter in the window
        for (int i = 1; i < number.length() - num + 1; i++) {
            slice.deleteCharAt(0);
            slice.append(number.charAt(i + num - 1));
            result.add(slice.toString());
        }

        return result;
    }
}