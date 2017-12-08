package flight;

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
		for(int i = 0 ; i < size; i++) {
			double random = Math.random();
			timeArray[i] = random <= 0.5 ? 0 : 1;
		}
	}

	public void genearatePriceArray() {
		int size = priceArray.length;
		for(int i = 0 ; i < size; i++) {
			double random = Math.random();
			priceArray[i] = random <= 0.5 ? 1 : 0;
		}
	}

	public int compareTo(Flight o) {
		return this.calculateFitness().compareTo(o.calculateFitness());
	}

	public Integer calculateFitness() {
		int fitness = 0;
		//Fitness calculation logic begins
		
		
		//Fitness calculation logic ends
		this.fitness = fitness;
		return fitness;
	}

}
