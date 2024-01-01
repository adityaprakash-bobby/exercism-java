package org.example;

import java.util.ArrayList;
import java.util.List;

class Flattener {

	@SuppressWarnings("unchecked")
	<T> List<T> flatten(List<T> list) {
		List<T> flattenedList = new ArrayList<T>();
		
		for (T element: list) {
			if (element instanceof List) {
				flattenedList.addAll(flatten((List<T>) element));
			} else if (element != null) {
				flattenedList.add(element);
			}
		}
		
		return flattenedList;
	}
}
