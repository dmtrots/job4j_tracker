package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] splitLeft = left.split("/");
        String[] splitRight = right.split("/");
        if (splitRight[0].compareTo(splitLeft[0]) == 0) {
            return left.compareTo(right);
        }
        return splitRight[0].compareTo(splitLeft[0]);
    }
}
