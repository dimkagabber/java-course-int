package com.tieto.training;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    Circle circle;
    Point center;
    Point point;

    //TODO: change instantiation to static factory

    @Test
    void isInsideXYRightUpInTest() {
        point = new Point(45,30);
        center = new Point(30,20);
        circle = new Circle(center, 60);
        assertEquals(true,circle.isInside(point));
    }

    @Test
    void isInsideInXYRightUpOutTest() {
        point = new Point(150,100);
        center = new Point(30,20);
        circle = new Circle(center, 60);
        assertFalse(circle.isInside(point));
    }

    @Test
    void isInsideSameAsCenterYesTest() {
        point = new Point(30,20);
        center = new Point(30,20);
        circle = new Circle(center, 60);
        assertTrue(circle.isInside(point));
    }

    @Test
    void isInsideXYLeftDownInTest() {
        point = new Point(-5,-10);
        center = new Point(20,10);
        circle = new Circle(center, 60);
        assertTrue(circle.isInside(point));
    }

    @Test
    void isInsideInXYLeftDownOutTest() {
        point = new Point(-25,-30);
        center = new Point(20,10);
        circle = new Circle(center, 60);
        assertFalse(circle.isInside(point));
    }

    @Test
    void isInsideXYLeftUpInTest() {
        point = new Point(-5,15);
        center = new Point(20,10);
        circle = new Circle(center, 60);
        assertTrue(circle.isInside(point));
    }

    @Test
    void isInsideInXYLeftUpOutTest() {
        point = new Point(-125, 145);
        center = new Point(20, 10);
        circle = new Circle(center, 60);
        assertFalse(circle.isInside(point));
    }

    @Test
    void isInsideOnTheEdgeRight() {
        point = new Point(50,40);
        center = new Point(20,10);
        circle = new Circle(center, 60);
        assertTrue(circle.isInside(point));
    }

    @Test
    void isInsideOnTheEdgeLeft()
    {    point = new Point(-10,-20);
        center = new Point(20,10);
        circle = new Circle(center, 60);
        assertTrue(circle.isInside(point));
    }


}