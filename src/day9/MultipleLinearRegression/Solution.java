/*
 * Andrea has a simple equation: Y = a+b1*f1+b2*f2+..+bm*fm
 * for (m+1) real constants (a, f1, f2, ..., fm).
 * We can say that the value of  depends on features.
 * Andrea studies this equation for n different feature sets (f1, f2, ..., fm) and records each respective value of Y.
 * If she has q new feature sets, can you help Andrea find the value of Y for each of the sets?
 * 
 * Note : You are not expected to account for bias and variance trade-offs.
 * 
 * Input format(sample)
	2 7
	0.18 0.89 109.85
	1.0 0.26 155.72
	0.92 0.11 137.66
	0.07 0.37 76.17
	0.85 0.16 139.75
	0.99 0.41 162.6
	0.87 0.47 151.77
	4
	0.49 0.18
	0.57 0.83
	0.56 0.64
	0.76 0.18
 * The first line contains 2 space-separated integers, m(the number of observed features) and n(the number of feature sets Andrea studied), respectively. 
 * Each of the  subsequent lines contain m+1 space-separated decimals; 
 * the first m elements are features (f1, f2, ..., fm), and the last element is the value of Y for the line's feature set.
 * The next line contains a single integer, q, denoting the number of feature sets Andrea wants to query for. 
 * Each of the q subsequent lines contains m space-separated decimals describing the feature sets.
 */

package day9.MultipleLinearRegression;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();

		double[][] X = new double[n][m + 1];
		double[] Y = new double[n];

		for(int i = 0; i < n; i ++) {
			X[i][0] = 1;

			for(int j = 1; j <= m; j++) {
				X[i][j] = sc.nextDouble();
			}
			Y[i] = sc.nextDouble();
		}

		double [] b=solve(mult(transpose(X),X),mult(transpose(X),Y),1e-8);

		int q = sc.nextInt();

		double[] obs = new double[m + 1];
		double result = 0;

		for(int i = 0; i < q; i++){
			obs[0] = 1;
			for(int j = 0; j < m; j++){
				obs[j + 1]=sc.nextDouble();
			}
			result = 0;
			for(int j = 0; j < m + 1; j++){
				result = result + b[j] * obs[j];
			}
			System.out.format("%.9f\n", result);
		}
	} //end main
	
	public static double[][] transpose(double [][] X){
        int n= X.length;
        int m = X[0].length;
        
        double [][] XT =new double[m][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                XT[j][i] = X[i][j];
            }
        }
        return XT;
    }
	
    public static double[][] mult(double [][] X, double [][]Y){
        int n = X.length;
        int m = X[0].length;
        int mCheck = Y.length;
        int p = Y[0].length;
        
        double [][] A = new double[n][p];
        
        for(int i = 0; i < n; i++){
            for(int j=  0;j < p; j++){
                double temp = 0;
                
                for(int k=0;k<m;k++){
                    temp = temp + X[i][k] * Y[k][j];
                }
                A[i][j] = temp;
            }
        }
        return A;
    }
    public static double[] mult(double [][] X, double[] Y){
        int n = X.length;
        int m = X[0].length;
        int p = Y.length;
        
        double [] z=new double[n];
        
        for(int i = 0; i < n; i++){
            double temp = 0;
            
            for(int k = 0; k < p; k++){
                temp = temp + X[i][k] * Y[k];
                }
             z[i] = temp;
        }
        return(z);
    }
    
    public static double [] solve(double [][] A, double y[],double tol){
        int n = y.length;
        
        double[] z =new double[n];
        
        for(int i = 0; i < n; i++){
            z[i] = Math.random()-0.5;
        }
        
        double epsilon=0;
        double curr=0;
        
        for(int k = 0; k < 10000; k++){
            epsilon=0;
            
            for(int i = 0; i < n; i++){
            	curr = z[i];
            	z[i] = 0;
            	for(int j = 0; j < n; j++){
            		if(j != i){
            			z[i] = z[i] + A[i][j] * z[j];
            		}
            	}
                z[i] = (y[i] - z[i]) / A[i][i];
                epsilon = epsilon + Math.abs(curr - z[i]);
            }
            if(epsilon < tol){
            	break;
            }
        }
        return z;
    }
} //end class