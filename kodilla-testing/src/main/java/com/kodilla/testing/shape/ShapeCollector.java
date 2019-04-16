package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    ArrayList<Shape> shapeList = new ArrayList<>();

    public void addFigure(Shape shape){
        shapeList.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        return shapeList.remove(shape);
    }

    public Shape getFigure(int n) {
        return shapeList.get(n);
    }

    public void showFigures() {
        for (Shape shape : shapeList) {
            System.out.println(shape.getShapeName());
        }
    }

    public int getShapeListSize() {
        return shapeList.size();
    }
}

