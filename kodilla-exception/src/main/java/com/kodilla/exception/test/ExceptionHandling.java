package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge challenge2 = new SecondChallenge();

        try {
            System.out.println(challenge2.probablyIWillThrowException(0.5, 2));

        } catch (Exception e) {

            System.out.println("There was an exception while running " +
                    "'probablyIWillThrowException()' method: " + e);

        } finally {

            System.out.println("'probablyIWillThrowException()' method " +
                    "has finished its operation");
        }
    }
}
