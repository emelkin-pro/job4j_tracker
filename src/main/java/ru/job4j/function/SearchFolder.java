package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SearchFolder {

    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        Supplier<List<Folder>> sup = () -> new ArrayList<>();
        List<Folder> rsl = sup.get();
        for (Folder f : list) {
            if (pred.test(f)) {
                rsl.add(f);
            }
        }
        return rsl;
    }
}