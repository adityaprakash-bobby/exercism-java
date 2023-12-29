package org.example;

import java.util.Collection;
import java.util.HashMap;

class CustomSet<T> {

    private static final Object PRESENT = new Object();
    private final HashMap<T, Object> map;

    CustomSet() {
        map = new HashMap<>();
    }

    CustomSet(Collection<T> data) {
        map = new HashMap<>(data.size());
        data.stream().forEach(this::add);
    }

    boolean isEmpty() {
        return map.isEmpty();
    }

    boolean contains(T element) {
        return map.containsKey(element);
    }

    boolean isDisjoint(CustomSet<T> other) {
        return getIntersection(other).isEmpty();
    }

    boolean add(T element) {
        return map.put(element, PRESENT) == null;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CustomSet<?>)) return false;

        return map.equals(((CustomSet<?>) obj).map);
    }

    CustomSet<T> getIntersection(CustomSet<T> other) {
        CustomSet<T> intersection = new CustomSet<>();
        other.map.keySet().stream().filter(this::contains).forEach(intersection::add);

        return intersection;
    }

    CustomSet<T> getUnion(CustomSet<T> other) {
        CustomSet<T> union = new CustomSet<>();

        other.map.keySet().stream().forEach(union::add);
        this.map.keySet().stream().forEach(union::add);

        return union;
    }

    CustomSet<T> getDifference(CustomSet<T> other) {
        CustomSet<T> intersection = this.getIntersection(other);
        CustomSet<T> difference = new CustomSet<>();
        map.keySet()
                .stream()
                .filter(element -> !intersection.contains(element))
                .forEach(difference::add);

        return difference;
    }

    boolean isSubset(CustomSet<T> other) {
        return other.map.keySet().stream().allMatch(this::contains);
    }
}
