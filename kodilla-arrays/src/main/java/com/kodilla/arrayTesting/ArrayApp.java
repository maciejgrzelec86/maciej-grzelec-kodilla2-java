package com.kodilla.arrayTesting;

import javax.crypto.BadPaddingException;
import java.util.ArrayList;
import java.util.List;

public class ArrayApp {
    public static void main(String[] args){
        List<BoardRows> rowList = new ArrayList<>();

        for (int i = 0; i < 2; i ++) {
            rowList.add(new BoardRows());
        }

        System.out.println("aa");

        rowList.stream()
                .flatMap(e -> e.integerList.stream())
                .forEach(System.out::print);

        System.out.println("");

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(rowList.get(i).getIntegerList().get(j));
            }
        }
    }
}

