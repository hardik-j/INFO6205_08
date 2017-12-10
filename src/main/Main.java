package main;

import constants.Constants;
import flight.Flight;
import population.Population;

public class Main {

	public static void main(String[] args) {
		Population pop = new Population();
		generatePopulation(pop);
		int tries = 1;
		while (tries <= Constants.MIN_GENERATIONS || pop.getFittest().getFitness() < Constants.FITNESS_THRESHOLD) {
			System.out.println("***********************Generation : " + tries + "**************************");
			pop.evolve();
			Flight fittest = pop.getFittest();
			System.out.println("Fittest : " + fittest.getFitness());
			tries++;
		}
		printArray(pop.getFittest().getPriceArray());
		printArray(pop.getFittest().getTimeArray());
	}

	public static void generatePopulation(Population genPop) {
		for (int i = 0; i < Constants.POPULATION_SIZE; i++) {
			Flight newFlight = genPop.generateFlight();
			newFlight.genearatePriceArray();
			newFlight.genearateTimeArray();
			newFlight.calculateFitness();
		}
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(", ");
			System.out.print(array[i]);
		}
	}

}
