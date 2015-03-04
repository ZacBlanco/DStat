package descriptive;

import descriptive.DispersionTools;
import descriptive.LocationTools;
import java.util.Arrays;
public class Distribution {

	public Distribution(double[] arr){
		array = arr;
		sortedArray = arr;
		Arrays.sort(sortedArray);
	}
	
	//Original data;
	private double[] array;
	private double[] sortedArray;
	
	//Encapsulated variables - properties of the distribution.
	private double stDev;
	private double mean;
	private double median;
	private double q1;
	private double q3;
	
	public double getMean(){
		return mean;
	}
	public double getStDev(){
		return stDev;
	}
	public double getMedian(){
		return median;
	}
	public double getQ1(){
		return q1;
	}
	public double getQ3(){
		return q3;
	}
	
	
	
	
}
