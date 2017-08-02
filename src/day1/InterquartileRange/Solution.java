package day1.InterquartileRange;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {

		int[] totalArr;
		int[] lArr;
		int[] uArr;
		int totalSize = 0;
		int index = 0;
		
		double lMedian = 0;
		double uMedian = 0;

		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();

		int[] numArr = new int[size];
		int[] cntArr = new int[size];

		for(int i = 0; i < size; i++) {
			numArr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < size; i++) {
			cntArr[i] = sc.nextInt();
			totalSize = totalSize + cntArr[i];
		}
		
		totalArr = new int[totalSize];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < cntArr[i]; j++) {
				totalArr[index] = numArr[i];
				index++;
			}
		}

		Arrays.sort(totalArr);
		
		if((totalSize%2) == 1) {
			lArr = new int[(totalSize-1)/2];
			uArr = new int[(totalSize-1)/2];
			
			for(int i = 0; i < (totalSize-1)/2; i++) {
				lArr[i] = totalArr[i];
			}

			for(int i = 0; i < (totalSize-1)/2; i++) {
				uArr[i] = totalArr[(totalSize-1)/2 + i + 1];
			} 
		} else {
			lArr = new int[totalSize/2];
			uArr = new int[totalSize/2];
			
			for(int i = 0; i < totalSize/2; i++) {
				lArr[i] = totalArr[i];
			}

			for(int i = 0; i < totalSize/2; i++) {
				uArr[i] = totalArr[totalSize/2 + i];
			} 
		}

		lMedian = getMedian(lArr);
		uMedian = getMedian(uArr);

		System.out.println(uMedian - lMedian);

	} //end main

	private static double getMedian(int[] arr) {

		double result = 0;
		int num = arr.length;
		int mid = (num-1)/2;

		if((num%2) == 1) {
			result = arr[mid];
		} else {
			result = (arr[mid] + arr[mid + 1]) / 2 ;

		}

		return result;
	}
} //end class