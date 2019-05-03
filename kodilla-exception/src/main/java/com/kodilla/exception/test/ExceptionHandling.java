package com.kodilla.exception.test;

import java.io.IOException;

public class ExceptionHandling {

    public static void main(String[] args) {

        /*try  {

            SecondChallenge secondChallenge = new SecondChallenge();
            secondChallenge.probablyIWillTrowException(10,2);

        } catch (Exception e) {

          System.out.println("Exception " + e );

        } finally {

          System.out.println("Last words");

        }*/

        Flight flight1 = new Flight(null,"Berlin");
        FlightCoordinates flightCoordinates = new FlightCoordinates();

        try {

            flightCoordinates.findFilght(flight1);

        } catch (RouteNotFoundException e) {

            System.out.println("No such destination");

        } finally {

            System.out.println("Program finished, flight");
        }
    }
}
