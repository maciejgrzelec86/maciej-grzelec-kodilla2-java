package com.kodilla.testing.shape;

public class Rectangle implements Shape {

    int sideA;
    int sideB;

    public String getShapeName() {
        return "Circle";
    }
    public double getField(){
        return sideA * sideB;
    }
}

