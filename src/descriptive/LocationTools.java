package descriptive;

import java.lang.reflect.Array;
import java.util.*;

/*
 * This class contains methods for the following statistical functions:
 * 
 * Mean
 * Median
 * Mode
 * 
 * As of 2/21/15 The only primitive types of inputs supported are doubles.
 * Plan to add more in the future, but currently doubles will provide the
 * widest range of support for mathematical and statistical functions.
 * 
 */

public class LocationTools {

	// Find the arithmetic mean of a continuous list of numbers
	// ie. sum the distribution and divide by the numbers of entries.
	public static double mean(double[] list) {

		if (list.length > 0) {
			long sum = 0;
			for (double x : list) {
				sum += x;
			}
			return (sum / list.length);

		} else {
			return Double.NaN;
		}
	}

	// Find the median of a set of numbers
	// Must implement a sorting algorithm
	public static double median(double[] list) {

		if (!isSorted(list)) {
			Arrays.sort(list);
		}
		if (list.length % 2 == 0) {
			int m1 = (list.length - 1) / 2;
			int m2 = (list.length + 1) / 2;

			return (list[m1] + list[m2]) / 2;

		} else {
			int mid = list.length / 2;
			return list[mid];
		}

	}

	public static double median(double[] list, int n1, int n2) {

		if (!isSorted(list)) {
			Arrays.sort(list);
		}
			int size = n2 - n1;
			if (size % 2 == 0) {
				int m1 = (size - 1) / 2;
				int m2 = (size + 1) / 2;

				return (list[m1] + list[m2]) / 2;

			} else {
				int mid = (n2 - n1) / 2;
				return list[mid];
			}
		
	}

	private static boolean isSorted(double[] a) {
		for (int i = 1; i < a.length - 1; i++) {
			if (a[i - 1] > a[i] || a[i + 1] < a[i]) {
				return false;
			}
		}
		return true;
	}

	// a quicksort (sort of) implementation for outside use and for median
	// function
	private static double[] zsort(double[] l, int lo, int hi) {

		// A new try at a quicksort implementation
		double[] temp = l;
		if (hi - lo > 1 && hi > lo) {

			// pick a pivot between hi and lo
			int piv = new Random().nextInt(hi - lo) + lo;
			double pVal = temp[piv];
			print("Hi: " + hi + " lo: " + lo + " Pivot: " + piv);
			// hide pivot
			// print(temp);
			temp = swap(temp, piv, lo);
			// print(temp);

			int store = lo + 1;
			for (int j = store; j <= hi; j++) {

				if (temp[j] < pVal) {
					// print("Flipping " + j + " and " + store);
					// print(temp);
					temp = swap(temp, j, store);
					store++;
					// print(temp);
				}
			}
			// print("Swapped All in pass");
			// print(temp);
			temp = swap(temp, lo, store - 1);
			print(temp);
			temp = zsort(temp, lo, store - 2);
			temp = zsort(temp, store, hi);

		}

		return temp;

	}

	private static void print(double[] l) {

		String s = "[";
		for (int i = 0; i < l.length - 1; i++) {
			s += l[i] + ", ";
		}
		s += l[l.length - 1] + "]";

		System.out.println(s);

	}

	private static void print(String s) {
		System.out.println(s);
	}

	public static double[] zsort(double[] l) {
		return zsort(l, 0, l.length - 1);
	}

	private static double[] swap(double[] l, int i1, int i2) {
		double temp = l[i1];
		l[i1] = l[i2];
		l[i2] = temp;
		return l;
	}

	public static int ctv(double value, double[] list) {

		int cInd = list.length + 1;
		double cDist = Double.MAX_VALUE;

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < list.length; j++) {
				if (Math.abs(list[j] - value) < cDist) {
					cDist = Math.abs(list[j] - value);
					cInd = j;
				}
			}
		}

		return cInd;

	}

	public static Map<Double, Integer> mode(double[] list) {

		if (list.length > 0) {
			Map<Double, Integer> nums = new HashMap<Double, Integer>();

			// Create HashMap for k, v pairs with k as double and v as
			// occurrences
			for (double d : list) {
				if (nums.containsKey(d)) {
					nums.put(d, nums.get(d) + 1);
				} else {
					nums.put(d, 1);
				}
			}

			double maxVal = 0; // highest of occurrences

			// Analyze hashmap to find mode(s)
			Set<Map.Entry<Double, Integer>> set = nums.entrySet();
			for (Map.Entry<Double, Integer> e : set) {
				if (e.getValue() > maxVal) {
					maxVal = e.getValue();
				}
			}

			Map<Double, Integer> modes = new HashMap<Double, Integer>();

			if (maxVal > 1) {
				for (Map.Entry<Double, Integer> e : set) {
					if (e.getValue() >= maxVal) {
						modes.put(e.getKey(), e.getValue());
					}
				}
			}

			return modes;

		} else {
			Map<Double, Integer> modes = new HashMap<Double, Integer>();
			return modes;
		}
	}
}
