package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.pizza.Pizza;
import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .ingredient(Ingredient.LETTUCE)
                .burgers(1)
                .ingredient(Ingredient.ONION)
                .bun(Bun.SESAME)
                .sauce(Sauce.THOUSAND_ISLAND)
                .ingredient(Ingredient.CHEESE)
                .ingredient(Ingredient.MUSHROOMS)
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        Assert.assertEquals(4, howManyIngredients);
    }
}
