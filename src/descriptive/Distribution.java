package descriptive;

import descriptive.DispersionTools;
import descriptive.LocationTools;
import java.util.Arrays;
import java.util.Map;
public class Distribution {

	public Distribution(double[] arr){
		array = arr;
		sortedArray = arr;
		Arrays.sort(sortedArray);
		analyze();
	}
	
	//Original data;
	private double[] array;
	private double[] sortedArray;
	
	//Encapsulated variables - properties of the distribution.
	private double stDev = Double.NaN;
	private double mean = Double.NaN;
	private double median = Double.NaN;
	private Map<Double, Integer> mode;
	private double q1 = Double.NaN;
	private double q3 = Double.NaN;
	private double min = Double.NaN;
	private double max = Double.NaN;
	private double range = Double.NaN;
	private double IQR = Double.NaN;
	private double skewness = Double.NaN;
	
	
	private void analyze(){
		stDev = DispersionTools.stdev(array);
		mean = LocationTools.mean(array);
		max = DispersionTools.max(array);
		min = DispersionTools.min(array);
		range = DispersionTools.range(array);
		median = LocationTools.median(sortedArray);
		mode = LocationTools.mode(sortedArray);
		q1 = LocationTools.median(sortedArray, 0, sortedArray.length/2);
		q3 = LocationTools.median(sortedArray, sortedArray.length/2, sortedArray.length-1);
		IQR = q3 - q1;
		skewness = ShapeTools.skewness(this);
	}
	
	public double getMean(){
		return mean;
	}
	public double getStDev(){
		return stDev;
	}
	public Map<Double, Integer> getMode(){
		return mode;
	}
	public double getMin(){
		return min;
	}
	public double getMax(){
		return max;
	}
	public double getRange(){
		return range;
	}
	public double getIQR(){
		return IQR;
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
	public double zscore(double l){
		return DispersionTools.zscore(l, getStDev(), getMean());
	}
	public double getSkewness(){
		return skewness;
	}
	public double[] getDataArray(){
		return array;
	}
	
	
	
	
	
}
