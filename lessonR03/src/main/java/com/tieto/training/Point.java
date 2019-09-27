package com.tieto.training;

public class Point {
    private double x;
    private double y;

    public Point(final double x, final int y) {
        setX(x);
        setY(y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(final double x) {
        this.x = x;
    }

    public void setY(final double y) {
        this.y = y;
    }
}
