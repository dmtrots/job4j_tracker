package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        if (key == null) {
            throw new ElementNotFoundException("No suitable elements");
        }
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            String[] array = {"one", "two", "three"};
            indexOf(array, null);
        } catch (ElementNotFoundException e) {
           e.printStackTrace();
        }
    }
}
