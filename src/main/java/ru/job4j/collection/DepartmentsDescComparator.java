package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        if (left.charAt(1) == right.charAt(1)) {
            for (int i = 2; i < Math.min(left.length(), right.length()); i++) {
                if (left.charAt(i) != right.charAt(i)) {
                    return Character.compare(left.charAt(i), right.charAt(i));
                }
            }
            return Integer.compare(left.length(), right.length());
        }
        return Character.compare(right.charAt(1), left.charAt(1));
    }
}