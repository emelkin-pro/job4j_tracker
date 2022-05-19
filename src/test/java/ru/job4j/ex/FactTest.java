package ru.job4j.ex;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class FactTest {
    @Test(expected = IllegalArgumentException.class)
    public void whenFactLessThen0() {
        Fact fact = new Fact();
        int rsl = fact.calc(-1);
        assertThat(rsl, is(1));
    }
}