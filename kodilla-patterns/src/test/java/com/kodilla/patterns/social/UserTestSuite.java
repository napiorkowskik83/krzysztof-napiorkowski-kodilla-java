package com.kodilla.patterns.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies(){
        //Given
        User millenialsTom = new Millenials("Tom");
        User yGenerationChristine = new YGeneration("Christine");
        User zGenerationDoug = new ZGeneration("Doug");

        //When
        String tomActivity = millenialsTom.sharePost();
        System.out.println("Tom is " + tomActivity);
        String christineActivity = yGenerationChristine.sharePost();
        System.out.println("Christine is " + christineActivity);
        String dougActivity = zGenerationDoug.sharePost();
        System.out.println("Doug is " + dougActivity);

        //Then
        Assert.assertEquals("sharing post on Facebook", tomActivity);
        Assert.assertEquals("sharing post on Twitter", christineActivity);
        Assert.assertEquals("sharing post on Snapchat", dougActivity);

    }

    @Test
    public void testIndividualSharingStrategy(){

        //Given
        User yGenerationJulie = new YGeneration("Julie");


        //When
        String julieActivity = yGenerationJulie.sharePost();
        System.out.println("Julie is " + julieActivity);

        yGenerationJulie.setSocialPublisher(new SnapchatPublisher());
        julieActivity = yGenerationJulie.sharePost();
        System.out.println("Julie now is " + julieActivity);

        //Then
        Assert.assertEquals("sharing post on Snapchat", julieActivity);

    }
}
