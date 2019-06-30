package com.gs.ilp.algos;

import java.util.Arrays;

public class ArrayManipulation {

	static int counter = -9999999;

	public static void main(String[] args) {
		// int[] array = { 4, 6, 45, 4, 67, 23, 45, 90, 6 ,45, 45};

		int[] array = { 4, 6, 45, 4, 67, 23, 45, 90, 6, 45, 45 };
		// 4 6 45 67 23 90
		// int[] nondupArr = removeDuplicates(array);
		// int[] newarr = removeAndShift(array, 2);
		// System.out.println("after shift op " + Arrays.toString(newarr));
		int[] nondupArr = removeDuplicatesV2(array);
		System.out.println("after removal " + Arrays.toString(nondupArr));
	}

	/**
	 * This function is removing the given element , shifting by one and returning a
	 * new array T(n) = O(n) S(n) = O(n)
	 * 
	 * @param arr
	 * @param index
	 * @return
	 */
	private static int[] removeAndShift(int[] arr, int index) {
		// int[] array = { 4, 6, 45, 4, 67, 23, 45, 90, 6 };
		// 4 6 4 67 23 45 90 6 null
		// remove(2)
		for (int i = index; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}

		int[] newarr = new int[arr.length - 1];

		for (int i = 0; i < arr.length - 1; i++) {
			newarr[i] = arr[i];
		}
		return newarr;

	}

	/**
	 * This function is removing the given element , shifting by one and returning a
	 * new array T(n) = O(n) S(n) = O(n)
	 * 
	 * @param arr
	 * @param index
	 * @return
	 */
	private static void removeAndShiftV2(int[] arr, int index) {
		// int[] array = { 4, 6, 45, 4, 67, 23, 45, 90, 6 };
		// 4 6 4 67 23 45 90 6 null
		// remove(2)
		for (int i = index; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[arr.length - 1] = -999999;
	}

	/**
	 * This will remove dupliactes T(n) = sort + extra = O(n2) + O(n2) = O(n2) =
	 * O(nlogn) + O(n2) = O(n2)
	 * 
	 * S(n) = O(n2)
	 * 
	 * @param array
	 * @return
	 */
	private static int[] removeDuplicates(int[] array) {
		// int[] array = { 4, 6, 45, 4, 67, 23, 45, 90, 6 ,45, 45};
		// one more array ?
		// bubble sort
		// sort
		// i =0
		// 4 4 6 6 23 45 45 45 45 67 90
		// 4 6 6 23 45 45 45 45 67 90 ,i =0;
		// i=1
		// 4 6 6 23 45 45 45 45 67 90
		// 4 6 23 45 45 45 45 67 90 ,i =1;
		// i =2;
		// 4 6 23 45 45 45 45 67 90
		// 4 6 23 45 45 45 45 67 90
		// i =3
		// 4 6 23 45 45 45 45 67 90
		// 4 6 23 45 45 45 67 90
		// i =4
		// 4 6 23 45 45 45 67 90
		// 4 6 23 45 45 67 90
		// i =4
		// 4 6 23 45 45 67 90
		// 4 6 23 45 67 90
		// i =5

		// count = 1

		Sortings.bubbleSort(array);// O(n2)

		System.out.println("after bubble" + Arrays.toString(array));

		// T(n) = O(n2)
		// S(n) = O(n2)
		for (int i = 0; i < array.length - 1; i++) {
			if (i - 1 > 0 && array[i] == array[i - 1]) {
				// deleted array[i+1]
				array = removeAndShift(array, i); //
				i--;
			} else if (array[i] == array[i + 1]) {
				// deleted array[i+1]
				array = removeAndShift(array, i);

			}
		}
		return array;
	}

	/**
	 * This will remove dupliactes T(n) = sort + extra = O(n2) + O(n2) = O(n2) =
	 * O(nlogn) + O(n2) = O(n2)
	 * 
	 * S(n) = O(n2)
	 * 
	 * @param array
	 * @return
	 */
	private static int[] removeDuplicatesV2(int[] array) {
		// int[] array = { 4, 6, 45, 4, 67, 23, 45, 90, 6 ,45, 45};
		// one more array ?
		// bubble sort
		// sort
		// i =0
		// 4 4 6 6 23 45 45 45 45 67 90
		// 4 6 6 23 45 45 45 45 67 90 ,i =0;
		// i=1
		// 4 6 6 23 45 45 45 45 67 90
		// 4 6 23 45 45 45 45 67 90 ,i =1;
		// i =2;
		// 4 6 23 45 45 45 45 67 90
		// 4 6 23 45 45 45 45 67 90
		// i =3
		// 4 6 23 45 45 45 45 67 90
		// 4 6 23 45 45 45 67 90
		// i =4
		// 4 6 23 45 45 45 67 90
		// 4 6 23 45 45 67 90
		// i =4
		// 4 6 23 45 45 67 90
		// 4 6 23 45 67 90
		// i =5

		// count = 1

		Sortings.bubbleSort(array);// O(n2)

		System.out.println("after bubble" + Arrays.toString(array));

		// T(n) = O(n2)
		// S(n) = O(n)
		int count = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] != -999999) {
				if (i - 1 > 0 && array[i] == array[i - 1]) {
					// deleted array[i+1]
					removeAndShiftV2(array, i); //
					i--;
				} else if (array[i] == array[i + 1]) {
					// deleted array[i+1]
					removeAndShiftV2(array, i);

				}
			} else {
				count++;
			}
		}

		int sizeOfNewArray = array.length - count-1;
		int[] newarr = new int[sizeOfNewArray];
		for (int i = 0; i < sizeOfNewArray; i++) {
			newarr[i] = array[i];
		}
		return newarr;
	}
}
