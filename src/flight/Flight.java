package flight;

import constants.Constants;

public class Flight implements Comparable<Flight> {
	private int[] priceArray = new int[10];
	private int[] timeArray = new int[10];
	private int fitness;

	public int[] getPriceArray() {
		return priceArray;
	}

	public void setPriceArray(int[] priceArray) {
		this.priceArray = priceArray;
	}

	public int[] getTimeArray() {
		return timeArray;
	}

	public void setTimeArray(int[] timeArray) {
		this.timeArray = timeArray;
	}

	public int getFitness() {
		return fitness;
	}

	public void setFitness(int fitness) {
		this.fitness = fitness;
	}

	public void genearateTimeArray() {
		int size = timeArray.length;
		for (int i = 0; i < size; i++) {
			double random = Math.random();
			timeArray[i] = random <= 0.03 ? 0 : 1;
		}
	}

	public void genearatePriceArray() {
		int size = priceArray.length;
		for (int i = 0; i < size; i++) {
			double random = Math.random();
			priceArray[i] = random <= 0.03 ? 1 : 0;
		}
	}
	
	public int getPrice() {
		int price = Constants.BASE_PRICE;
		for (int i = 0; i < priceArray.length; i++)
			price = priceArray[i] ==0 ? price + Constants.PRICE_STEP: price;
		return price;		
	}
	
	public float getTime() {
		float time = Constants.BASE_TIME;
		for (int i = 0; i < timeArray.length; i++)
			time = timeArray[i] == 0 ? time + Constants.TIME_STEP: time;
		return time;		
	}

	public int compareTo(Flight o) {
		Integer fit1 = calculateFitness();
		Integer fit2 = o.calculateFitness();
		if(fit1 - fit2 > 0)
			return -1;
		else if(fit1 - fit2 < 0)
			return 1;
		else
			return 0;
	}

	public Integer calculateFitness() {
		int fitness = 0;

		for (int i = 0; i < timeArray.length; i++) {
			if (timeArray[i] == 1)
				++fitness;
			if (priceArray[i] == 1)
				++fitness;
		}

		this.fitness = fitness;
		return fitness;
	}

}
