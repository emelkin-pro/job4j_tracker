package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenAscComparatorByName() {
        Comparator<Job> cmpAscName = new JobAscByName();
        int rsl = cmpAscName.compare(
                new Job("A", 3),
                new Job("B", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenDescComparatorByName() {
        Comparator<Job> cmpDescName = new JobDescByName();
        int rsl = cmpDescName.compare(
                new Job("A", 3),
                new Job("B", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenDescComparatorByNameEquals() {
        Comparator<Job> cmpDescName = new JobDescByName();
        int rsl = cmpDescName.compare(
                new Job("F", 3),
                new Job("F", 1)
        );
        assertThat(rsl).isEqualTo(0);
    }

    public void whenAscComparatorByPriority() {
        Comparator<Job> cmp = new JobAscByPriority();
        int rsl = cmp.compare(
                new Job("A", 3),
                new Job("B", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenDescComparatorByPriority() {
        Comparator<Job> cmp = new JobDescByPriority();
        int rsl = cmp.compare(
                new Job("A", 3),
                new Job("B", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenDescComparatorByPriorityEquals() {
        Comparator<Job> cmp = new JobDescByPriority();
        int rsl = cmp.compare(
                new Job("F", 4),
                new Job("A", 4)
        );
        assertThat(rsl).isEqualTo(0);
    }

    @Test
    public void whenDescComparatorByNameAndPriority() {
        Comparator<Job> cmp = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmp.compare(
                new Job("A", 0),
                new Job("A", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenAscComparatorByNameAndPriority() {
        Comparator<Job> cmp = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmp.compare(
                new Job("A", 0),
                new Job("A", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByAscNameAndDescPriority() {
        Comparator<Job> cmp = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmp.compare(
                new Job("A", 0),
                new Job("A", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByDescNameAndAscPriority() {
        Comparator<Job> cmp = new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = cmp.compare(
                new Job("A", 0),
                new Job("A", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByDescNameAndAscPriorityEquals() {
        Comparator<Job> cmp = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmp.compare(
                new Job("A", 0),
                new Job("A", 0)
        );
        assertThat(rsl).isEqualTo(0);
    }
}