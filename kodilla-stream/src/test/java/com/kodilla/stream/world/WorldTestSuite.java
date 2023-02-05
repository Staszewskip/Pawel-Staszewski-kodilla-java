package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    void testGetPeopleQuantity() {
        //given
        World world = new World();
        Continent continent1 = new Continent();
        Continent continent2 = new Continent();
        Continent continent3 = new Continent();
        Continent continent4 = new Continent();
        Continent continent5 = new Continent();
        //when
        continent1.addCountry(new Country("Poland", new BigDecimal(38000000)));
        continent1.addCountry(new Country("Germany", new BigDecimal(82000000)));
        continent1.addCountry(new Country("Spain", new BigDecimal(47000000)));
        continent2.addCountry(new Country("USA", new BigDecimal(300000000)));
        continent3.addCountry(new Country("China", new BigDecimal(1300000000)));
        continent4.addCountry(new Country("Egypt", new BigDecimal(106000000)));
        continent5.addCountry(new Country("Brazil", new BigDecimal(212000000)));

        world.addContinent(continent1);
        world.addContinent(continent2);
        world.addContinent(continent3);
        world.addContinent(continent4);
        world.addContinent(continent5);

        BigDecimal peopleQuantity = world.getPeopleQuantity();
        BigDecimal expectedResult = new BigDecimal("2085000000");
        //then
        Assertions.assertEquals(expectedResult, peopleQuantity);
    }
}
