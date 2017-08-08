/*
 * You have a sample of 100 values from a population with mean mu=500 and with standard deviation sigma=80.
 * Compute the interval that covers the middle  of the distribution of the sample mean;
 * in other words, compute A and B such that P(A < x < B) = 0.95.
 * Use the value of z=1.96. Note that  is the z-score.
 * 
 * Input Format
	100
	500
	80
	.95
	1.96
 * The first line contains the sample size. 
 * The second and third lines contain the respective mean and standard deviation. 
 * The fourth line contains the distribution percentage we want to cover (as a decimal), 
 * and the fifth line contains the value of z.
 */

package day6.TheCentralLimitTheorem3;

import java.awt.image.SampleModel;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int sample = sc.nextInt();
    	double mean = sc.nextDouble();
    	double sd = sc.nextDouble();
    	double confidenceInterval = sc.nextDouble();
    	double zScore = sc.nextDouble();
    	
    	
    	double result = interval(zScore, sd, sample);
    	
    	System.out.printf("%.2f \n", mean - result);
    	System.out.printf("%.2f", mean + result);
        
    } //end main
    
    static double interval(double zScore, double sd, double sample) {
		return zScore * sd / Math.sqrt(sample);
	}

} //end class