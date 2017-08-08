/*
 * The final grades for a Physics exam taken by a large group of students have a mean of mu=70 
 * and a standard deviation of sigma=10. 
 * If we can approximate the distribution of these grades by a normal distribution, 
 * what percentage of the students:
 * 
 * 1. Scored higher than  (i.e., have a grade>80)?
 * 2. Passed the test (i.e., have a grade>=60)?
 * 3. Failed the test (i.e., have a grade<60)?
 * 
 * Find and print the answer to each question on a new line, 
 * rounded to a scale of 2 decimal places.
 * 
 * Input Format
	70 10
	80
	60
 * The first line contains 2 space-separated values denoting the respective mean and standard deviation for the exam. 
 * The second line contains the number associated with question 1. 
 * The third line contains the pass/fail threshold number associated with questions 2 and 3.
 */

package day5.NormalDistribution2;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double mean = sc.nextDouble();
        double sd = sc.nextDouble();
        double x = sc.nextDouble();
        double y = sc.nextDouble();
                
        System.out.format("%.2f%n", 100 * (1 - cumulative(mean, sd, 80)));
        System.out.format("%.2f%n", 100 * (1 - cumulative(mean, sd, 60)));
        System.out.format("%.2f%n", 100 * cumulative(mean, sd, 60));
        
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