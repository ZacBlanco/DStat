package descriptive;
import java.util.Arrays;

import descriptive.LocationTools;


public class DispersionTools {
	
	public static double range(double[] l){
		return max(l) - min(l);
	}
	
	public static double min(double[] l){
		double min = l[0];
		for(int i = 0; i < l.length;i++){
			if(l[i] < min){
				min = l[i];
			}
		}
		return min;
	}
	
	public static double max(double[] l){
		double max = l[0];
		for(int i = 0; i < l.length;i++){
			if(l[i] > max){
				max = l[i];
			}
		}
		return max;
	}
	
	public static double[] quartiles(double[] l){
		double[] qs = new double[3];
		Arrays.sort(l);
		qs[1] = LocationTools.median(l);
		return qs;
		
	}
	
	// Returns the first index of a specified value
	private static int indexOf(double[] l, double val){
		return indexOf(l, val, 0);
	}
	
	//returns the first index of the occurence of a value starting at/after the specified starting value.
	private static int indexOf(double[] l, double val, int start){
		
		for(int i = start; i < l.length; i++){
			if(val == l[i]){
				return i;
			}
		}
		return -1;
	}
	
	
	public static double percentile(double[] l, int p){
		
		if(p > 0 && p < 100){
			int i = (int)Math.ceil((((double)p)/100)*(l.length - 1));
			if (i < l.length){
				return l[i];
			} else {
				return Double.NaN;
			}
		}else{
			return Double.NaN;
		}
		
		
	}
	
	
	public static double stdev(double[] list) {
		double mean = LocationTools.mean(list);
		return stdev(list, mean);

	}
	
	public static double stdev(double[] list, double mean){
		double diffSum = 0;
		for (double d : list) {
			diffSum += Math.abs(d - mean);
		}

		return (diffSum / list.length);
	}

	public static  double[] zscores(double[] list, double dev, double mean) {
		double[] scores = new double[list.length];
		if (dev > 0) {
			for (int i = 0; i < list.length; i++) {
				scores[i] = (list[i] - mean) / dev;
			}
			return scores;
		} else {
			return new double[list.length];
		}
	}

	public static double[] zscores(double[] list) {
		return zscores(list, stdev(list), LocationTools.mean(list));
	}
	
	public static double zscore(double n, double std, double mean){
		if(std > 0){
			return (n-mean)/std;
		}else{
			return Double.NaN;
		}
	}
	
	public double zscore(double n, double[] list){
		return zscore(n, stdev(list), LocationTools.mean(list));
	}
	
	
}
