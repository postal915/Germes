package com.github.postal915.germes.app.model.entity.geography;

/**
 * Geographical coordinate of an object
 */

public class Coordinate {

    private double x;

    private double y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
