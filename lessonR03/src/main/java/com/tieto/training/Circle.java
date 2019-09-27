package com.tieto.training;

public class Circle {
    private Point center;
    private double radius;

    public Circle(final Point center, final double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(final Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(final double radius) {
        this.radius = radius;
    }


    boolean isInside(Point point){

        double dx = this.center.getX() - point.getX();
        double dy = this.center.getY() - point.getY();
        double dLength = dx * dx + dy * dy;

        return dLength <= (radius * radius);
    }
}
