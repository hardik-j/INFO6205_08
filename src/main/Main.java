package main;

import constants.Constants;
import flight.Flight;
import population.Population;

public class Main {
	
	public static void main(String[] args) {
		Population genPop = new Population();
		generatePopulation(genPop);
		int tries = 1;
		while(tries < Constants.MIN_GENERATIONS && genPop.getFittest().getFitness() < Constants.FITNESS_THRESHOLD) {
			// TODO More to be added other than below steps
			genPop.doSelectionAndCrossover();
			genPop.doMutation();
		}
	}

	public static void generatePopulation(Population genPop) {
		for(int i = 0 ; i < Constants.POPULATION_SIZE; i++) {
			Flight newFlight = genPop.generateFlight();
			newFlight.genearatePriceArray();
			newFlight.genearateTimeArray();
		}
	}

}
