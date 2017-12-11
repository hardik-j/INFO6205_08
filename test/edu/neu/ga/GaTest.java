package edu.neu.ga;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import flight.Flight;
import population.Population;

import static org.junit.Assert.*;

import java.util.List;

public class GaTest {

    @Test
    public void testFitness() {
    	int[] priceArray = {0000000000};
    	int[] timeArray = {0000000000};
        Flight flight = new Flight();
        assertEquals(flight.getFitness(), 0);
    }

    @Test
    public void testFitness1() {
        
    	int[] priceArray = {0,0,0,0,0,1,1,0,0,1};
    	int[] timeArray = {0,0,1,0,0,0,0,0,0,1};
        Flight flight = new Flight();
        flight.setPriceArray(priceArray);
        flight.setTimeArray(timeArray);
        assertEquals(flight.getFitness(), 5);
    }

    @Test
    public void testFitness2() {
      
    	
    	int[] priceArray = {1100011001};
    	int[] timeArray = {1010000001};
        Flight flight = new Flight();
        assertEquals(flight.getFitness(), 8);
       
        
    }

    @Test
    public void testFlight() {
    	Integer fit1 = 7;
		Integer fit2 = 8;
		Flight flight = new Flight();
	    assertEquals(flight.compareTo(flight),1);
        
    }

	
}