package com.kodilla.testing.shape;
import java.math.*;

public class Circle implements Shape {

    int radius;

    public String getShapeName() {
        return "Circle";
    }
    public double getField(){
        return Math.sqrt(radius) * Math.PI;
    }
}

