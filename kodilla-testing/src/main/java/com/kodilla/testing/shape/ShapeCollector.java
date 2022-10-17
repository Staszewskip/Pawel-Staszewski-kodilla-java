package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    List<Shape> shapeList = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapeList.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        return shapeList.remove(shape);
    }

    public Shape getFigure(int n) {
        if (n < shapeList.size() && n >= 0) {
            return shapeList.get(n);
        } else {
            return null;
        }
    }

    public List<Shape> showFigures() {
        return shapeList;
    }
}
