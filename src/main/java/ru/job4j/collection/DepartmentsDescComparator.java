package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] splitLeft = left.split("/");
        String[] splitRight = right.split("/");
        if (splitRight[0].compareTo(splitLeft[0]) == 0) {
            for (int i = 1; i < Math.min(left.length(), right.length()); i++) {
                if (left.charAt(i) != right.charAt(i)) {
                    return Character.compare(left.charAt(i), right.charAt(i));
                }
            }
            return Integer.compare(left.length(), right.length());
        }
        return splitRight[0].compareTo(splitLeft[0]);
    }
}