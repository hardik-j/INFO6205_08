package main;

import org.apache.log4j.Logger;

import constants.Constants;
import flight.Flight;
import population.Population;

public class Main {

	final static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		Population pop = new Population();
		pop.generatePopulation();
		logger.info("Population size : " + pop.getFlights().size());
		logger.info("***********************Generation : 0**************************");
		logger.info("Fittest : " + pop.getFittest().getFitness());
		int tries = 1;
		while (tries <= Constants.MIN_GENERATIONS || pop.getFittest().getFitness() < Constants.FITNESS_THRESHOLD) {
			logger.info("***********************Generation : " + tries + "**************************");
			pop.evolve();
			Flight fittest = pop.getFittest();
			logger.info("Fittest : " + fittest.getFitness());
			logger.info("Fare : $" + fittest.getPrice());
			logger.info("Duration : " + fittest.getTime() + " hours");
			tries++;
		}
		Flight fittest = pop.getFittest();
		logger.info("****************************************************");
		logger.info("Number of generations : " + (tries - 1));
		logger.info("Optimal flight fitness : " + fittest.getFitness());
		logger.info("Fare : $" + fittest.getPrice());
		logger.info("Duration : " + fittest.getTime() + " hours");

	}

}
