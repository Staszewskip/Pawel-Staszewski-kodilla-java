package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements Shape {
    private String name = "Square";
    private double edgeLength;

    public Square(double edgeLength) {

        this.edgeLength = edgeLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.edgeLength, edgeLength) == 0 && Objects.equals(name, square.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, edgeLength);
    }

    public String getShapeName() {
return name;
    }
    public double getField() {
return Math.pow(edgeLength, 2);
    }
    }
