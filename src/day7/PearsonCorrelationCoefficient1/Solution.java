/*
 * Given two -element data sets, X and Y, 
 * calculate the value of the Pearson correlation coefficient.
 * 
 * Input format (sample)
	10
	10 9.8 8 7.8 7.7 7 6 5 4 2 
	200 44 32 24 22 17 15 12 8 4 
 * The first line contains an integer, n, denoting the size of data sets X and Y. 
 * The second line contains  space-separated real numbers (scaled to at most one decimal place), defining data set X. 
 * The third line contains  space-separated real numbers (scaled to at most one decimal place), defining data set Y.
 */

package day7.PearsonCorrelationCoefficient1;

import java.io.*;
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
    	
    	System.out.printf("%.3f", pearson(X, Y));
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
