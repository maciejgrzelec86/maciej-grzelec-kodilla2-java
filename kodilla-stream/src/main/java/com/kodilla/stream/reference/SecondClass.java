//package com.kodilla.stream.reference;
import com.kodilla.stream.reference.FirstClass;
import com.kodilla.stream.reference.ThirdClass;

import java.util.ArrayList;
import java.util.List;

public class SecondClass {
    FirstClass firstClass = new FirstClass();
    //firstClass.get

    List<String> arrayLista = new ArrayList<>();

    ThirdClass thirdClass = new ThirdClass();
    thirdClass.getUserName();
    thirdClass.getClass();
}
