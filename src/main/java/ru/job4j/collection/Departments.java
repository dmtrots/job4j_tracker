package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();
        for (String value : departments) {
            String start = "";
            for (String element : value.split("/")) {
                if (start.isEmpty()) {
                    start = element;
                    temp.add(element);
                } else if (element.charAt(0) != start.charAt(0)) {
                    temp.add(start + "/" + element);
                    start = start + "/" + element;
                } else {
                    start = element;
                    temp.add(element);
                }
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> departments) {
        departments.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> departments) {
        departments.sort(new DepartmentsDescComparator());
    }
}