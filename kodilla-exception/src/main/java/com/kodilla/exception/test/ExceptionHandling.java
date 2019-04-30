package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {

        try  {

            SecondChallenge secondChallenge = new SecondChallenge();
            secondChallenge.probablyIWillTrowException(10,2);

        } catch (Exception e) {

          System.out.println("Exception " + e );

        } finally {

          System.out.println("Last words");

        }
    }
}
