package org.example.knapsack;

import java.util.List;

class Knapsack {

    private int recursiveMaximumValue(int maxWeight, List<Item> items, int size) {
        if (size == 0 || maxWeight == 0) return 0;

        if (items.get(size - 1).weight > maxWeight) return recursiveMaximumValue(maxWeight, items, size - 1);

        return Math.max(items.get(size - 1).value + recursiveMaximumValue(maxWeight - items.get(size - 1).weight, items, size - 1), recursiveMaximumValue(maxWeight, items, size - 1));
    }

    int maximumValue(int maximumWeight, List<Item> items) {
        return recursiveMaximumValue(maximumWeight, items, items.size());
    }

}