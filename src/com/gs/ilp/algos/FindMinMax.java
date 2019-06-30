package com.gs.ilp.algos;

import java.util.Arrays;
import java.util.Random;

public class FindMinMax {
	public static void main(String[] args) {
		int[] arr = { 12, -12, 34, 89, 100, -34, 1000 };
		int min = findMin(arr);
		System.out.println("Min is " + min);

		int[] arr1 = prepareTestCase();
		int min1 = findMin(arr1);
		System.out.println("Min is " + min1);

		int[] maxArray = { 5, 1, 4, 2, -1 };
		int max = modifiedFindMax(maxArray);
		System.out.println("Max is " + max);
		System.out.println(Arrays.toString(maxArray));

	}

	private static int modifiedFindMax(int[] arr) {
		// 5 1 4 2 -1
		// 1 5 4 2 -1 // i =1
		// 1 4 5 2 -1 // i =2
		// 1 4 2 5 -1 // i =3
		// 1 4 2 -1 5 // i = 4

		// n-1
		// T(n) = O(n)
		// S(n) = 0
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				// swap : way 2
				// a = 4
				// b= 5
				// a = a+b // a =9
				// b= a-b // 4
				// a = a-b // 5
				arr[i] = arr[i] + arr[i + 1];
				arr[i + 1] = arr[i] - arr[i + 1];
				arr[i] = arr[i] - arr[i + 1];

			}
		}
		return arr[arr.length - 1];

	}

	public static int[] prepareTestCase() {
		Random random = new Random();
		int[] arr = new int[10000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt();
		}

		return arr;
	}

	public static int[] prepareSortedArrayTestCase() {
		int[] arr = new int[10000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

		return arr;
	}

	// T(n) = number of comp : n-1 = O(n)
	// n-1 <= c*n
	// S(n) = 4B

	static int findMin(int[] array) {
		// { 12, -12, 34, 89, 100, -34, -4 };
		// step 1: min = array[0] , 12
		// if(min>array[2])
		// min = array[1] // -12
		int min = array[0]; // -34 // constant
		for (int i = 1; i < array.length; i++) {
			if (min > array[i]) {
				min = array[i];
			}
		}
		return min;
	}

}
