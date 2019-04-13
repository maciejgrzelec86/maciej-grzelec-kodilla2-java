package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){

        String result;

        SimpleUser simpleUser = new SimpleUser("Adam");

        result = simpleUser.getUserName();

        if (result.equals("Adam")) {
            System.out.println("Test OK");
        } else {
            System.out.println("Bad result");
        }
    }
}

