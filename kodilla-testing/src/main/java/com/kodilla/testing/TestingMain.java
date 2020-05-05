package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        //Calculator methods tests

        Calculator calc = new Calculator();

        if (calc.addAtoB(4, 7) == 4+7){
            System.out.println("addAtoB method test - OK");
        }else{
            System.out.println("addAtoB method test - failed");
        }

        if (calc.substractBfromA(33, 8) == 33-8){
            System.out.println("substractBfromA method test - OK");
        }else{
            System.out.println("substractBfromA method test - failed");
        }
    }
}