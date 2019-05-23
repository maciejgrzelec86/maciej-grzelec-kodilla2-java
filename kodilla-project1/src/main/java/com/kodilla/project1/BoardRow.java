package com.kodilla.project1;

import java.util.ArrayList;
import java.util.List;

public class BoardRow {
    private final List<Figure> cols = new ArrayList<>();

    public BoardRow() {
        for (int x =0; x < 8; x++){
            cols.add(new None());
        }
    }

    public List<Figure> getCols() {
        return cols;
    }
}
