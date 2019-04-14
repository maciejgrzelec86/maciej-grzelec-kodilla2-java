package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){

        String result;
        int result2, result3;

        SimpleUser simpleUser = new SimpleUser("Adam");

        result = simpleUser.getUserName();

        if (result.equals("Adam")) {
            System.out.println("Test OK");
        } else {
            System.out.println("Bad result");
        }

        Calculator calculator = new Calculator();

        result2 = calculator.add(2, 4);
        result3 = calculator.subtract(10, 5);

        if (result2 == 6 & result3 == 5) {
            System.out.println("Calculator test OK");
        } else {
            System.out.println("Bad result");
        }
    }
}

