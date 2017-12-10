package main;

import constants.Constants;
import flight.Flight;
import population.Population;

public class Main {
	
	public static void main(String[] args) {
		Population genPop = new Population();
		System.out.println("Generation : 0");
		generatePopulation(genPop);
		System.out.print("Fittest : " + genPop.getFittest().getFitness());
		int tries = 1;
		while(tries < Constants.MIN_GENERATIONS && genPop.getFittest().getFitness() < Constants.FITNESS_THRESHOLD) {
			System.out.println("Generation : " + tries);
			genPop.evolve();
			System.out.print(", Fittest : " + genPop.getFittest().getFitness());
			tries++;
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
