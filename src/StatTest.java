import java.util.Random;

import descriptive.*;

public class StatTest {

	public static void main(String[] args) {

		Random r = new Random();
		int max = 99;
		int min = 0;
		int trialLength = 4000;		

			double[] nums = new double[trialLength];
			for (int i = 0; i < nums.length; i++) {
				nums[i] = (r.nextDouble() * (max-min)) + min;
			}
			
			
		long start = System.nanoTime();
	
		
		Distribution d = new Distribution(nums);
		
		print("Min:" + d.getMin() + " Max: " + d.getMax());
		print("Mean: " + d.getMean());
		print("Mode: " + d.getMode());
		print("Standard Deviation: " + d.getStDev());
		print("Median: " + d.getMedian());
		print("IQR: " + d.getIQR());
		print("1st Quartile: " + d.getQ1() + " 3rd Quartile: " + d.getQ3());
		
		
		long end = System.nanoTime();
		
		print("Running Time: " + ((double)(end - start) / 1000000000.0));
		
		//print("Median: " + LocationTools.median(l));
		
	}
	
	static String AString(double[] l){
		
		String s = "[";
		for(int i = 0; i < l.length - 1; i++){
			s += l[i] + ", ";
		}
		s += l[l.length - 1] + "]";
		
		return s;
		
	}
	static String AString(double[] l, int n1, int n2){
		
		String s = "[";
		for(int i = n1; i < n2-1; i++){
			s += l[i] + ", ";
		}
		s += l[n2] + "]";
		
		return s;
		
	}
	
	static int isSorted(double[] l){
		for(int i = 1; i < l.length - 1; i++){
			if(l[i] < l[i-1] || l[i] > l[i+1]){
				return  i;
			}
		}
		return -1;
	}
	
	static void print(String s){
		System.out.println(s);
	}
	
}
