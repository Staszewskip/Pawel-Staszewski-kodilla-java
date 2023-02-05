package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements Shape {
    private String name = "Triangle";
    private double triangleWidth;
    private double triangleHeight;

    public Triangle(double triangleWidth, double triangleHeight) {
        this.triangleWidth = triangleWidth;
        this.triangleHeight = triangleHeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.triangleWidth, triangleWidth) == 0 && Double.compare(triangle.triangleHeight, triangleHeight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(triangleWidth, triangleHeight);
    }

    public String getShapeName() {
return name;
    }
    public double getField() {
return (triangleWidth * triangleHeight)/2;
    }
}
