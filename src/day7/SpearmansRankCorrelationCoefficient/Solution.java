/*
 * Given two n-element data sets, X and Y, 
 * calculate the value of Spearman's rank correlation coefficient.
 * 
 * Input format (sample)
	10
	10 9.8 8 7.8 7.7 1.7 6 5 1.4 2 
	200 44 32 24 22 17 15 12 8 4
 * The first line contains an integer, n, denoting the size of data sets X and Y. 
 * The second line contains  space-separated real numbers (scaled to at most one decimal place), defining data set X. 
 * The third line contains  space-separated real numbers (scaled to at most one decimal place), defining data set Y.
 */
package day7.SpearmansRankCorrelationCoefficient;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();
		double[] X = new double[size];
		double[] Y = new double[size];

		for(int index = 0; index < size; index++) {
			X[index] = sc.nextDouble();
		}

		for(int index = 0; index < size; index++) {
			Y[index] = sc.nextDouble();
		}
		
		System.out.printf("%.3f", spearman(X, Y));
	} //end main

	static double spearman(double [] X, double [] Y) {

		if( X == null || Y == null) {
			return 0;
		}

		double result;

		int[] rankX = getRank(X);
		int[] rankY = getRank(Y);

		int n = X.length;
		double numerator = 0;
		double denominator = n * ((n * n) -1);

		for(int index = 0; index < n; index++) {
			numerator = numerator + Math.pow((rankX[index] - rankY[index]), 2);
		}

		numerator = numerator * 6;

		result = 1 - (numerator / denominator);

		return result;
	}

	private static int[] getRank(double[] x) {

		if(x == null) {
			return null;
		}

		Map<Integer, Double> data = new HashMap<Integer, Double>();

		int[] rank = new int[x.length];


		for(int index = 0; index < x.length; index++) {
			data.put(index, x[index]);
		}

		Iterator it = sortByValue(data).iterator();

		int count = 1;

		while(it.hasNext()){

			int temp = (int) it.next();
			rank[temp] = count;
			count++;
		}
		
		return rank;
	}

	static List sortByValue(final Map data) {
		List<Integer> list = new ArrayList();
		list.addAll(data.keySet());

		Collections.sort(list,new Comparator<Object>() {

			@SuppressWarnings("unchecked")
			@Override
			public int compare(Object o1, Object o2) {
				Object v1 = data.get(o1);
				Object v2 = data.get(o2);


				return ((Comparable<Object>) v1).compareTo(v2);
			}

		});

		return list;
	}	


} //end class

