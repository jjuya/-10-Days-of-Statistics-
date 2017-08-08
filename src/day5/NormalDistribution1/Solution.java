/*
 * In a certain plant, the time taken to assemble a car is a random variable, X,
 * having a normal distribution with a mean of 20 hours and a standard deviation of 2 hours.
 * What is the probability that a car can be assembled at this plant in:
 * 1. Less than 19.5 hours?
 * 2. Between 20 and 22 hours?
 * 
 * Input format
	20 2
	19.5
	20 22
 * The first line contains 2 space-separated values denoting the respective mean and standard deviation for X. 
 * The second line contains the number associated with question 1. 
 * The third line contains 2 space-separated values describing the respective lower and upper range boundaries for question 2.
 */

package day5.NormalDistribution1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int mean = sc.nextInt();
		int sd = sc.nextInt();

		double x1 = sc.nextDouble();
		double y1 = sc.nextDouble();
		double y2 = sc.nextDouble();

		System.out.format("%.3f%n", cumulative(mean, sd, x1));
		System.out.format("%.3f%n", cumulative(mean, sd, y2) - cumulative(mean, sd, y1));
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
