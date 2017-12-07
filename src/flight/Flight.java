package flight;

public class Flight implements Comparable<Flight>{
	private int[] priceArray = new int[10];
	private int[] timeArray = new int[10];
	
	
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
	public int compareTo(Flight o) {
		return this.calculateFitness().compareTo(o.calculateFitness());
	}
	
	public Integer calculateFitness() {
		// TODO Calculate Fitness Logic
		return 0;
	}
	
	

}
