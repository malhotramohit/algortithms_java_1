package com.gs.ilp.algos;

import java.util.Arrays;

public class Sortings {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = { 44, 56, 90, 23, 12, 5 };
		System.out.println("Array before ");
		int[] arr1 = FindMinMax.prepareSortedArrayTestCase();
		// System.out.println(Arrays.toString(arr1));
		// modifiedFindMax(arr);
		// System.out.println("Array after ");
		// System.out.println(Arrays.toString(arr));
		// modifiedFindMax(arr);
		// System.out.println("Array after ");
		// System.out.println(Arrays.toString(arr));
		// modifiedFindMax(arr);
		// System.out.println("Array after ");
		// System.out.println(Arrays.toString(arr));
		// modifiedFindMax(arr);
		// System.out.println("Array after ");
		// System.out.println(Arrays.toString(arr));
		// modifiedFindMax(arr);
		// System.out.println("Array after ");
		long start = System.currentTimeMillis();
		bubbleSort(arr1);
		long end = System.currentTimeMillis();
		long dff = end - start;
		System.out.println("Time taken is " + dff);
		// System.out.println(Arrays.toString(arr1));

		// System.out.println(findSecondMax(arr));
		// System.out.println(Arrays.toString(arr));

		System.out.println(modifiedFindSecondMax(arr));
		System.out.println(Arrays.toString(arr));

	}

	// Find max product in an array
	// int[] arr = { 44, 56, 90, 23, 12, 5 };
	// int[] arr = { -44, 56, 90, 23, 12, 5, -100 };

	private static void modifiedFindMax(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				arr[i] = arr[i] + arr[i + 1];
				arr[i + 1] = arr[i] - arr[i + 1];
				arr[i] = arr[i] - arr[i + 1];
			}
		}

	}

	public static void bubbleSort(int[] arr) {

		// 5 1 4 2 -1
		// 1 5 4 2 -1 // i =1
		// 1 4 5 2 -1 // i =2
		// 1 4 2 5 -1 // i =3
		// 1 4 2 -1 5 // i = 4

		// j=1
		// 1 4 2 -1 5
		// 1 4 2 -1 5
		// 1 2 4 -1 5
		// 1 2 -1 4 5

		// j =2
		// 1 2 -1 4 5
		// 1 2 -1 4 5
		// 1 -1 2 4 5

		// n =10 ,
		// j =0 , 9
		// j = 1 , 8
		// j= 2 , 7
		// j =3 , 6

		// 9+8+7+6+5....1
		// n(n+1)/2 = O(n2)

		// Worst case : 100 99 98 97 ....... 1
		// Major op1 = : compar ;: O(n2)
		// Major op1 = : swaping :: O(n2)
		// Best case : 1 2 3 4 5 .......100
		// Major op1 = : compar ;: O(n2) -- > O(n)
		// Major op1 = : swaping :: 0
		for (int j = 0; j < arr.length; j++) { // T(n) = O(n2)

			for (int i = 0; i < arr.length - j - 1; i++) { // O(n)
				if (arr[i] > arr[i + 1]) {
					arr[i] = arr[i] + arr[i + 1];
					arr[i + 1] = arr[i] - arr[i + 1];
					arr[i] = arr[i] - arr[i + 1];
				}
			}

		}

	}

	/**
	 * j=0, n-1 j= 1, n-2 j= 2 , n-3 T(n) = 3n-6= O(n) S(n) = 8B
	 * 
	 * @param arr
	 * @return
	 */
	private static int findSecondMax(int[] arr) {
		for (int j = 0; j < 2; j++) { // T(n) = O(n2)

			for (int i = 0; i < arr.length - j - 1; i++) { // O(n)
				if (arr[i] > arr[i + 1]) {
					arr[i] = arr[i] + arr[i + 1];
					arr[i + 1] = arr[i] - arr[i + 1];
					arr[i] = arr[i] - arr[i + 1];
				}
			}

		}
		return arr[arr.length - 2];
	}

	/**
	 * T(n) = n-1 S(n) = 8B
	 * 
	 * @param arr
	 * @return
	 */
	private static int modifiedFindSecondMax(int[] arr) {
		// int[] arr = { 44, 56, 90, 23, 12, 5 };
		// max1 = 90
		// max2 = 56
		//
		int max1 = arr[0];
		int max2 = max1;
		for (int i = 1; i < arr.length; i++) {
			if (max1 < arr[i]) {
				max2 = max1;
				max1 = arr[i];
			}
		}
		return max2;

	}

}
