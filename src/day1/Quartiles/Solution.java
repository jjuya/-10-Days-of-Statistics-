package day1.Quartiles;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {

		int median = 0;
		int lMedian = 0;
		int uMedian = 0;

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int[] arr = new int[num];
		
		int[] lArr;
		int[] uArr;

		for(int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		
		if((num%2) == 1) {
			lArr = new int[(num-1)/2];
			uArr = new int[(num-1)/2];
			
			for(int i = 0; i < (num-1)/2; i++) {
				lArr[i] = arr[i];
			}

			for(int i = 0; i < (num-1)/2; i++) {
				uArr[i] = arr[(num-1)/2 + i + 1];
			} 
		} else {
			lArr = new int[num/2];
			uArr = new int[num/2];
			
			for(int i = 0; i < num/2; i++) {
				lArr[i] = arr[i];
			}

			for(int i = 0; i < num/2; i++) {
				uArr[i] = arr[num/2 + i];
			} 
		}

		median = getMedian(arr);
		lMedian = getMedian(lArr);
		uMedian = getMedian(uArr);

		System.out.println(lMedian);
		System.out.println(median);  	
		System.out.println(uMedian);

	} //end main

	private static int getMedian(int[] arr) {

		int result = 0;
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