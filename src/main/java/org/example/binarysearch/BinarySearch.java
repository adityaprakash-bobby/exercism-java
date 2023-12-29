package org.example.binarysearch;

import java.util.List;

class BinarySearch {
    private List<Integer> items;

    BinarySearch(List<Integer> items) {
        this.items = items;
    }

    int indexOf(int item) throws ValueNotFoundException {
        int start = 0;
        int end = items.size() - 1;
        int mid;

        while (start <= end) {
            mid = (end + start) / 2;

            if (items.get(mid) == item)
                return mid;
            else if (item > items.get(mid))
                start = mid + 1;
            else
                end = mid - 1;
        }

        throw new ValueNotFoundException("Value not in array");
    }
}

