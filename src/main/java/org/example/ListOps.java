package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

class ListOps {

    private ListOps() {
        // No instances.
    }

    static <T> List<T> append(List<T> list1, List<T> list2) {
        return Stream.concat(list1.stream(), list2.stream()).toList();
    }

    static <T> List<T> concat(List<List<T>> listOfLists) {
        return listOfLists.stream().reduce(new ArrayList<>(), (acc, l) -> {
            acc.addAll(l);
            return acc;
        });
    }

    static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate).toList();
    }

    static <T> int size(List<T> list) {
        return list.size();
    }

    static <T, U> List<U> map(List<T> list, Function<T, U> transform) {
        return list.stream().map(transform).toList();
    }

    static <T> List<T> reverse(List<T> list) {
        List<T> reversedList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--)
            reversedList.add(list.get(i));

        return reversedList;
    }

    static <T, U> U foldLeft(List<T> list, U initial, BiFunction<U, T, U> f) {
        U result = initial;
        for (int i = 0; i < list.size(); i++) {
            result = f.apply(result, list.get(i));
        }

        return result;
    }

    static <T, U> U foldRight(List<T> list, U initial, BiFunction<T, U, U> f) {
        U result = initial;
        for (int i = list.size() - 1; i >= 0; i--) {
            result = f.apply(list.get(i), result);
        }

        return result;
    }
}
