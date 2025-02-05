package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("dmitrytrotss@gmail.com", "Trotsenko Dmitriy Anatolevich");
        map.put("ivanivanov@yandex.ru", "Ivanov Ivan");
        map.put("vvputin@mail.ru", "Vladimir Putin");
        map.put("nevskiya@yandex.ru", "Nevskiy Alexander");
        map.put("nevskiya@yandex.ru", "Nevskiy Alexey");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " — " + value);
        }
    }
}
