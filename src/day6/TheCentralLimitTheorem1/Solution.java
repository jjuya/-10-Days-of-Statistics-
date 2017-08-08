/*
 * A large elevator can transport a maximum of 9800 pounds.
 * Suppose a load of cargo containing 49 boxes must be transported via the elevator.
 * The box weight of this type of cargo follows a distribution with a mean of mu=205 pounds
 * and a standard deviation of sigma=15 pounds. 
 * Based on this information, what is the probability that all 49 boxes can be safely loaded into the freight elevator and transported?
 * 
 * Input Format
	9800
	49
	205
	15
 * The first line contains the maximum weight the elevator can transport.
 * The second line contains the number of boxes in the cargo. 
 * The third line contains the mean weight of a cargo box, and the fourth line contains its standard deviation.
 */

package day6.TheCentralLimitTheorem1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int maxWeight = sc.nextInt();
    	int boxNum = sc.nextInt();
    	double mean = sc.nextDouble();
    	double sd = sc.nextDouble();
    	
    	double sampleMean = boxNum * mean;
    	double sampleSd = Math.sqrt(boxNum) * sd;
    	
    	double result = cumulative(sampleMean, sampleSd, maxWeight);
    	
    	System.out.printf("%.4f", result);
        
    } //end main
    
    static double cumulative(double mean, double sd, double x) {
		double parameter = (x - mean) / (sd * Math.sqrt(2));
		return (0.5) * (1 + erf(parameter));
	}

	static double erf(double z) {
		double t = 1.0 / (1.0 + 0.5 * Math.abs(z));
		
		double ans = 1 - t * Math.exp( -z*z   -   1.26551223 +
											t * ( 1.00002368 +
											t * ( 0.37409196 + 
											t * ( 0.09678418 + 
											t * (-0.18628806 + 
											t * ( 0.27886807 + 
											t * (-1.13520398 + 
											t * ( 1.48851587 + 
											t * (-0.82215223 + 
											t * ( 0.17087277))))))))));
		if (z >= 0) return  ans;
		else        return -ans;
	}

} //end class