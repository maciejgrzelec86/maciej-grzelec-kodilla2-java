package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Country {

    String countryName;
    BigDecimal peopleQuantity;

    public BigDecimal getPeopleQuantity(){
        return peopleQuantity;
    }

    public String getCountryName() {
        return countryName;
    }

    public Country(String countryName, BigDecimal peopleQuantity) {
        this.countryName = countryName;
        this.peopleQuantity = peopleQuantity;
    }
}
