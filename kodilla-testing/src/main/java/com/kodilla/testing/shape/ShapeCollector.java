package com.kodilla.testing.shape;

import java.util.LinkedList;

public class ShapeCollector {
    LinkedList<Shape> shapeList = new LinkedList<>();
    public void addFigure(Shape shape){
        shapeList.add(shape);
    }
    public boolean removeFigure(Shape shape){
return shapeList.remove(shape);
    }
    public Shape getFigure(int n){
if (n<shapeList.size() && n>=0) {
    return shapeList.get(n);
}else {
    return null;
}
    }
    public String showFigures() {
        String emptyString = "";
        for(Shape shapeName : shapeList){
         String result = emptyString + shapeName.getShapeName();
        }
        return result;

return shapeList.toString();
    }
}
