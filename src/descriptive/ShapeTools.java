package descriptive;

/*
 * This class contains methods that generate information about the shape of a given Distribution d.
 * Some of these formulas come from more advanced statistics and require significant information
 * about a list of numbers, thus why we pass Distrubtions as parameters, rather than just arrays
 * 
 * As of 3/6/15 the methods within this class can calculate the following:
 * Variance
 * Skewness
 * 
 * 
 * */


public class ShapeTools {	
	
	//Return the variance (square of standard deviation)
	public static double variance(Distribution d){
		return Math.pow(d.getStDev(), 2);
	}
	
	// Pearson skewness is defined as the third central moment divided by variance^(3/2)
	// Shorthand : (cm_3)/(s^3)
	public static double skewness(Distribution d){
		
		//Calculate the 3rd central moment
		double cm;
		double [] l = d.getDataArray();
		double mu = d.getMean();
		double sum = 0;
		
		for(int i = 0;i < l.length;i++){
			sum += Math.pow(l[i] - mu, 3);
		}		
		cm = (1/l.length)*sum;
		
		//divide the moment by variance^1.5
		double skew = cm/Math.pow(variance(d), 1.5);

		return skew;
		
	}
	
	
}
