package com.kodilla.stream.world;


import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;


public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        Continent europe = new Continent();
        Country poland = new Country("38567321");
        Country germany = new Country("78569326");
        europe.addCountry(poland);
        europe.addCountry(germany);

        Continent northAmerica = new Continent();
        Country uSA = new Country("336293625");
        Country canada = new Country("29825998");
        northAmerica.addCountry(uSA);
        northAmerica.addCountry(canada);

        Continent asia = new Continent();
        Country china = new Country("3296751421");
        Country india = new Country("1847395489");
        asia.addCountry(china);
        asia.addCountry(india);

        World world = new World();
        world.addContinent(europe);
        world.addContinent(northAmerica);
        world.addContinent(asia);


        //When
        BigDecimal totalPeopleQuantity = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPeopleQuantity = new BigDecimal("38567321");
        expectedPeopleQuantity = expectedPeopleQuantity.add(new BigDecimal("78569326"));
        expectedPeopleQuantity = expectedPeopleQuantity.add(new BigDecimal("336293625"));
        expectedPeopleQuantity = expectedPeopleQuantity.add(new BigDecimal("29825998"));
        expectedPeopleQuantity = expectedPeopleQuantity.add(new BigDecimal("3296751421"));
        expectedPeopleQuantity = expectedPeopleQuantity.add(new BigDecimal("1847395489"));
        Assert.assertEquals(expectedPeopleQuantity, totalPeopleQuantity);
    }
}
