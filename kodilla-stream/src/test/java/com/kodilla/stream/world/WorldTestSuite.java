package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    public void testPeopleInWorldSum() {
        //Given
        Country country11 = new Country("country11", new BigDecimal(1)) ;
        Country country12 = new Country("country12", new BigDecimal(1)) ;
        Country country13 = new Country("country13", new BigDecimal(1)) ;
        Country country21 = new Country("country21", new BigDecimal(2)) ;
        Country country22 = new Country("country22", new BigDecimal(2)) ;
        Country country23 = new Country("country23", new BigDecimal(2)) ;
        Country country31 = new Country("country31", new BigDecimal(3)) ;
        Country country32 = new Country("country32", new BigDecimal(3)) ;
        Country country33 = new Country("country33", new BigDecimal(3)) ;

        Continent continent1 = new Continent();
        Continent continent2 = new Continent();
        Continent continent3 = new Continent();

        continent1.getCountryList().add(country11);
        continent1.getCountryList().add(country12);
        continent1.getCountryList().add(country13);
        continent2.getCountryList().add(country21);
        continent2.getCountryList().add(country22);
        continent2.getCountryList().add(country23);
        continent3.getCountryList().add(country31);
        continent3.getCountryList().add(country32);
        continent3.getCountryList().add(country33);

        World world = new World();
        world.getWorldList().add(continent1);
        world.getWorldList().add(continent2);
        world.getWorldList().add(continent3);

        //When
        BigDecimal peopleInWorld = world.getPeopleQuantity();

        //Then
        Assert.assertEquals(peopleInWorld, new BigDecimal("18"));
    }
}
