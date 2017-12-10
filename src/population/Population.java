package population;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import constants.Constants;
import flight.Flight;

public class Population {

	private List<Flight> flights;

	public Population() {
		flights = new ArrayList<Flight>();
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public Flight generateFlight() {
		Flight flight = new Flight();
		flights.add(flight);
		return flight;
	}

	public void doSelectionAndCrossover() {
		int cullCount = (int)(Constants.CULL_RATIO * flights.size());
		for(int i = 1; i <= cullCount; i++) {
			Flight flight1  = getFittest();
			Flight flight2  = flights.get(1);
			Flight newFlight = doCrossover(flight1, flight2);
			doMutation(newFlight);
			doCull();	
		}
		
	}

	private void doCull() {
		Collections.sort(flights);
		Flight remove = flights.remove(flights.size() - 1);
		System.out.println("Culling fitness : " + remove.getFitness());
	}

	private Flight doCrossover(Flight flight1, Flight flight2) {
		Flight newFlight = generateFlight();
		int cutoff = (int)Math.floor(Math.random() * 10);
		int size = flight1.getTimeArray().length;
		int[] priceArray = newFlight.getPriceArray();
		int[] priceArray1 = flight1.getPriceArray();
		int[] priceArray2 = flight2.getPriceArray();
		int[] timeArray = newFlight.getTimeArray();
		int[] timeArray1 = flight1.getTimeArray();
		int[] timeArray2 = flight2.getTimeArray();
		for(int i = 0; i < size; i++) {
			if(i <= cutoff) {
				priceArray[i] = priceArray1[i];
				timeArray[i] = timeArray1[i];
			}
			else {
				priceArray[i] = priceArray2[i];
				timeArray[i] = timeArray2[i];
			}
		}
		newFlight.calculateFitness();
//		System.out.print("New fitness : " + newFlight.getFitness());
		return newFlight;
	}

	public void doMutation(Flight flight) {
		if(Math.random() < 0.08) {
			System.out.println("Mutating!!");
			int bit = (int) Math.floor(Math.random() * 10);
			flight.getPriceArray()[bit] = flight.getPriceArray()[bit] == 0 ? 1 : 1;
			flight.getTimeArray()[bit] = flight.getTimeArray()[bit] == 0 ? 1 : 1;
		}

	}

	public Flight getFittest() {
		Collections.sort(flights);
		return flights.get(0);
	}

	public void evolve() {
		doSelectionAndCrossover();
	}
}
