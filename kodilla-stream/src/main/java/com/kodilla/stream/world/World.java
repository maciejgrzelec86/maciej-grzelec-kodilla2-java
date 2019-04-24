package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class World {

    List<Continent> worldList = new ArrayList<>();

    public List<Continent> getWorldList() {
        return worldList;
    }

    public BigDecimal getPeopleQuantity() {
        return  worldList.stream()
                .flatMap(s -> s.getCountryList().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }
}
