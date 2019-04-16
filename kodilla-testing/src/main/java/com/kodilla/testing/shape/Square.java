package com.kodilla.testing.shape;

public class Square implements Shape {

    int side;

    public String getShapeName() {
        return "Square";
    }
    public double getField(){
        return Math.sqrt(side);
    }
}

