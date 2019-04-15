package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {

    ArrayList<Integer> reducedNumbers = new ArrayList<>();

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {
        for (Integer number : numbers  ) {
            if (number % 2 == 0) {
                reducedNumbers.add(number);
            }
        }
        return reducedNumbers;
    }
}
