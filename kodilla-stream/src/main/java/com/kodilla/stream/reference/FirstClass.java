package com.kodilla.stream.reference;

import java.util.ArrayList;
import java.util.List;

public class FirstClass {
    private String userName;

    private int calculate(){
        return 1;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public class SecondClass {
        FirstClass firstClass = new FirstClass();
        //firstClass.get

        List<String> arrayLista = new ArrayList<>();

        ThirdClass thirdClass = new ThirdClass();


    }
}
