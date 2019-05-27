package com.kodilla.arrayTesting;

import java.util.ArrayList;
import java.util.List;

public class BoardRows {
    public List<Integer> integerList = new ArrayList<>();

    public BoardRows() {
        for (int i = 0; i < 8; i++){
            integerList.add((Integer)i);
        }
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }
}
