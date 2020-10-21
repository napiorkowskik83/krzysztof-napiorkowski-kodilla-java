package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PizzaTestSuite {

    @Test
    public void testPizzaGetCost() {
        //Given
        Pizza pizza = new BasicPizza();
        //When
        BigDecimal price = pizza.getCost();
        //Then
        assertEquals(new BigDecimal(15), price);
    }

    @Test
    public void testPizzaGetDescription() {
        //Given
        Pizza pizza = new BasicPizza();
        //When
        String description = pizza.getDescription();
        //Then
        assertEquals("Pizza with tomato sauce and cheese", description);
    }

    @Test
    public void testPizzaWithDoubleCheeseAndHamGetCost() {
        //Given
        Pizza pizza = new BasicPizza();
        pizza = new CheesePizzaDecorator(pizza);
        pizza = new HamPizzaDecorator(pizza);
        //When
        BigDecimal price = pizza.getCost();
        //Then
        assertEquals(new BigDecimal(19), price);
    }

    @Test
    public void testPizzaWithDoubleCheeseAndHamGetDescription() {
        //Given
        Pizza pizza = new BasicPizza();
        pizza = new CheesePizzaDecorator(pizza);
        pizza = new HamPizzaDecorator(pizza);
        //When
        String description = pizza.getDescription();
        //Then
        assertEquals("Pizza with tomato sauce and cheese + cheese + ham", description);
    }

    @Test
    public void testPizzaWithPepperoniOnionAndPeppersGetCost() {
        //Given
        Pizza pizza = new BasicPizza();
        pizza = new PepperoniPizzaDecorator(pizza);
        pizza = new OnionPizzaDecorator(pizza);
        pizza = new PeppersPizzaDecorator(pizza);
        //When
        BigDecimal price = pizza.getCost();
        //Then
        assertEquals(new BigDecimal(21), price);
    }

    @Test
    public void testPizzaWithPepperoniOnionAndPeppersGetDescription() {
        //Given
        Pizza pizza = new BasicPizza();
        pizza = new PepperoniPizzaDecorator(pizza);
        pizza = new OnionPizzaDecorator(pizza);
        pizza = new PeppersPizzaDecorator(pizza);
        //When
        String description = pizza.getDescription();
        //Then
        assertEquals("Pizza with tomato sauce and cheese + pepperoni + onion + peppers", description);
    }
}