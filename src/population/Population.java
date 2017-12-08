package population;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

	}

	public void doMutation() {

	}

	public Flight getFittest() {
		Collections.sort(flights);
		return flights.get(0);
	}
}
