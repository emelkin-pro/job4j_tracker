package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("lolkek@yandex.ru", "Lolkekovich Oleg Iurevich");
        map.put("iii@yandex.ru", "Ivanov Ivan Ivanovich");
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
