package com.kodilla.exception.test;

public class ExceptionHandling  {
    public String probablyIWillThrowException() {
        SecondChallenge challenge = new SecondChallenge();
        try {
            challenge.probablyIWillThrowException(2, 1.5);
        } catch (Exception e) {
            System.out.println("Problem, invalid method arguments");
        } finally {
            System.out.println();
        }
        return "Done";
    }
}
