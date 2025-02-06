package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int length = Integer.compare(left.length(), right.length()) > 0 ? right.length() : left.length();
        for (int i = 0; i < length; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            } else {
                result = Integer.compare(left.length(), right.length());
            }
        }
        return result;
    }
}