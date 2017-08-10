/*
 * A group of five students enrolls in Statistics immediately after taking a Math aptitude test. 
 * Each student's Math aptitude test score, x, 
 * and Statistics course grade, y, 
 * can be expressed as the following list of (x, y) points:
 * 1. (95, 85)
 * 2. (85, 95)
 * 3. (80, 70)
 * 4. (70, 65)
 * 5. (60, 70)
 * If a student scored an  on the Math aptitude test,
 * what grade would we expect them to achieve in Statistics?
 * Determine the equation of the best-fit line using the least squares method,
 * then compute and print the value of y when x=80.
 */

package day8.LeastSquareRegressionLine;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		
		double [] X = {95, 85, 80, 70, 60};
        double [] Y = {85, 95, 70, 65, 70};
		int score = 80;

		double b = pearson(X, Y) * (standardDeviation(Y) / standardDeviation(X));
		double a = mean(Y) - b * mean(X);
		
		double result = a + b * score;
		
		System.out.printf("%.3f", result);

	} //end main

	static double mean(double[] data) {

		if( data == null) {
			return 0;
		}

		double result;
		double sum = 0.0;

		for(int index = 0; index < data.length; index++) {
			sum = sum + data[index];
		}

		result = sum / data.length;

		return result;
	}

	static double standardDeviation(double[] data) {

		if( data == null) {
			return 0;
		}

		double result;
		double sum = 0.0;
		double mean = mean(data);

		for(int index = 0; index < data.length; index++) {
			sum = sum + Math.pow((data[index] - mean), 2);
		}

		result = Math.sqrt(sum / data.length);

		return result;
	}

	static double pearson(double[] X, double[] Y) {

		if( X == null || Y == null) {
			return 0;
		}

		double result;

		double meanX = mean(X);
		double meanY = mean(Y);
		double sdX = standardDeviation(X);
		double sdY = standardDeviation(Y);

		double n = X.length;
		double numerator = 0;
		double denominator = n * sdX * sdY;    	

		for(int index = 0; index < n; index++) {
			numerator = numerator + (X[index] - meanX) * (Y[index] - meanY);
		}

		result = numerator / denominator;

		return result;
	}
} //end class
