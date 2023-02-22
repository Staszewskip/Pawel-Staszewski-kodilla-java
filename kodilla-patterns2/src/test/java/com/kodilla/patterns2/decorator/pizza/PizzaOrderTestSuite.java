package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PizzaOrderTestSuite {
    @Test
    public void testBasicPizza() {
//        Given
        PizzaOrder pizza = new BasicPizzaOrder();
//        When
        BigDecimal basicPizzaCost = pizza.getCost();
        String basicPizzaDescription = pizza.getDescription();
//        Then
        assertAll(
                () -> assertEquals(new BigDecimal(15), basicPizzaCost),
                () -> assertEquals("Basic pizza ", basicPizzaDescription)
        );
    }

    @Test
    public void testVegetablesPizza() {
//        Given
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new VegatablesPizzaDecorator(pizza);
//        When
        BigDecimal cost = pizza.getCost();
        String description = pizza.getDescription();
//        Then
        assertAll(
                () -> assertEquals(new BigDecimal(18), cost),
                () -> assertEquals("Basic pizza + pepper & onion ", description)
        );
    }

    @Test
    public void testVegetablesAndMeatPizza() {
//        Given
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new VegatablesPizzaDecorator(pizza);
        pizza = new MeatPizzaDecorator(pizza);
        //        When
        BigDecimal cost = pizza.getCost();
        String description = pizza.getDescription();
//        Then
        assertAll(
                () -> assertEquals(new BigDecimal(23), cost),
                () -> assertEquals("Basic pizza + pepper & onion + chorizo sausage ", description)
        );
    }

    @Test
    public void testFullOptionPizza() {
//        Given
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new VegatablesPizzaDecorator(pizza);
        pizza = new MeatPizzaDecorator(pizza);
        pizza = new ExtraCheesePizzaDecorator(pizza);
        //        When
        BigDecimal cost = pizza.getCost();
        String description = pizza.getDescription();
//        Then
        assertAll(
                () -> assertEquals(new BigDecimal(25), cost),
                () -> assertEquals("Basic pizza + pepper & onion + chorizo sausage + extra cheese ", description)
        );
    }
}