package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(x -> x.subjects().stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.map(x -> new Tuple(x.name(),
                        x.subjects().stream()
                                .mapToInt(Subject::score)
                                .average()
                                .orElse(0)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {

        return stream.flatMap(s -> s.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::score)))
                .entrySet().stream()
                .map(p -> new Tuple(p.getKey(), p.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        CompareTupleMax compareTupleMax = new CompareTupleMax();
        return stream.map(x -> new Tuple(x.name(), x.subjects()
                        .stream()
                        .mapToInt(Subject::score)
                        .sum()))
                .max(compareTupleMax)
                .orElse(new Tuple("No name", 0));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        CompareTupleMax compareTupleMax = new CompareTupleMax();
        return stream.flatMap(s -> s.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name,
                        LinkedHashMap::new,
                        Collectors.summingDouble(Subject::score)))
                .entrySet().stream()
                .map(p -> new Tuple(p.getKey(), p.getValue()))
                .max(compareTupleMax)
                .orElse(new Tuple("No name", 0));
    }
}