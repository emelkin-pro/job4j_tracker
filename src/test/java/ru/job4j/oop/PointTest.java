package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {


    @Test
    public void when00to20then2() {
        double expected = 2;
        int x1 = 0;
        int y1 = 0;
        int x2 = 2;
        int y2 = 0;
        Point testPoint1 = new Point(x1, y1);
        Point testPoint2 = new Point(x2, y2);
        double out = testPoint1.distance(testPoint2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when22to1212then2() {
        double expected = 14.14;
        int x1 = 2;
        int y1 = 2;
        int x2 = 12;
        int y2 = 12;
        Point testPoint1 = new Point(x1, y1);
        Point testPoint2 = new Point(x2, y2);
        double out = testPoint1.distance(testPoint2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when1015to11then2() {
        double expected = 16.64;
        int x1 = 10;
        int y1 = 15;
        int x2 = 1;
        int y2 = 1;
        Point testPoint1 = new Point(x1, y1);
        Point testPoint2 = new Point(x2, y2);
        double out = testPoint1.distance(testPoint2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when10010500to543123then2() {
        double expected = 10386.45;
        int x1 = 100;
        int y1 = 10500;
        int x2 = 543;
        int y2 = 123;
        Point testPoint1 = new Point(x1, y1);
        Point testPoint2 = new Point(x2, y2);
        double out = testPoint1.distance(testPoint2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when1to2then3() {
        double expected = 6.7;
        int x1 = 1;
        int y1 = 2;
        int x2 = 5;
        int y2 = 7;
        int z1 = 3;
        int z2 = 5;
        Point testPoint3 = new Point(x1, y1, z1);
        Point testPoint4 = new Point(x2, y2, z2);
        double out = testPoint3.distance3d(testPoint4);
        Assert.assertEquals(expected, out, 0.01);
    }
}