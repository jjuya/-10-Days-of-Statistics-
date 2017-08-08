/*
 * The number of tickets purchased by each student for the University X vs.
 * University Y football game follows a distribution that has a mean of mu=2.4
 * and a standard deviation of sigma=2.0.
 * A few hours before the game starts, 100 eager students line up to purchase last-minute tickets.
 * If there are only 250 tickets left, what is the probability that all 100 students will be able to purchase tickets?
 * 
 * Input Format
	250
	100
	2.4
	2.0
 * The first line contains the number of last-minute tickets available at the box office. 
 * The second line contains the number of students waiting to buy tickets.
 * The third line contains the mean number of purchased tickets,
 * and the fourth line contains the standard deviation.
 */

package day6.TheCentralLimitTheorem2;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int ticket = sc.nextInt();
    	int student = sc.nextInt();
    	double mean = sc.nextDouble();
    	double sd = sc.nextDouble();
    	
    	double sampleMean = student * mean;
    	double sampleSd = Math.sqrt(student) * sd;
    	
    	double result = cumulative(sampleMean, sampleSd, ticket);
    	
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