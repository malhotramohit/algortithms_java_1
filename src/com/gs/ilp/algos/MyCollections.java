package com.gs.ilp.algos;

import java.util.Arrays;

interface MyComparable<T> {
	public int myCompareTo(T o);
}

class Wallet implements MyComparable<Wallet> {
	int id;
	String name;

	public Wallet(int id, String name) {
		super();
		this.id = id;
		this.name = name;

	}

	@Override
	public String toString() {
		return "Wallet [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int myCompareTo(Wallet wallet) {
		if (this.id > wallet.id) {
			return 1;
		} else if (this.id == wallet.id) {
			return 0;
		} else {
			return -1;
		}
	}

}

public class MyCollections {

	public static void main(String[] args) {
		// int[] a = { 10, 20, 30, 40, 50 };
		// int[] b = { 11, 21, 31 };
		//
		// int[] c = merge(a, b);
		// System.out.println(Arrays.toString(c));
		//

//		Integer[] arr = { 25, 77, 91, 5, 21, 46, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//		System.out.println(Arrays.toString(arr));
//		arr = mergeSort(arr, 0, arr.length - 1);
//		System.out.println(Arrays.toString(arr));

		Wallet wallet1 = new Wallet(1, "name1");
		Wallet wallet2 = new Wallet(34, "asnm1");
		Wallet wallet3 = new Wallet(12, "nay1");
		Wallet wallet4 = new Wallet(89, "kkoo");

		Wallet[] wallets = { wallet1, wallet2, wallet3, wallet4 };
		System.out.println("Before sorting ");
		System.out.println(Arrays.toString(wallets));
		Object[] objets = mergeSort(wallets, 0, wallets.length - 1);
		System.out.println("After sorting ");
		System.out.println(Arrays.toString(objets));

	}

	// merge
	// {10,20,30,40,50}
	// {11,21,31}
	// {10,11,20,21,30,31,40,50}

	/**
	 * Outplace n= 2^5 , s = 5+1 n= 2^4 s = 4+1 n =7 , s = 3+1 n , number of slots =
	 * log(n)+1 T(n) = log(n)*n = n*logn S(n) = log(n)
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static <T> T[] mergeSort(T[] arr, int start, int end) {
		if (start < end) { // O(1)

			int mid = (start + end) / 2; // O(1)
			int n1 = mid - start + 1;
			int n2 = end - mid;
			T[] lArray = (T[]) new Object[n1];// {10,11,20,21,30,31,40,50}
			T[] rArray = (T[]) new Object[n2];

			// O(n/2)
			for (int i = 0; i < mid + 1; i++) {
				lArray[i] = arr[i];
			}
			int k = 0;
			// O(n/2)
			for (int i = mid + 1; i < arr.length; i++) {
				rArray[k] = arr[i];
				k++;
			}

			lArray = mergeSort(lArray, 0, lArray.length - 1); // ? T(n) = number of f calls * T(n) of each fuunc call
			rArray = mergeSort(rArray, 0, rArray.length - 1);
			arr = (T[]) merge(lArray, rArray); // O(n/2) -- O(n)
		}
		return arr;

	}

	/**
	 * T(n,m) = max(O(n),O(m))
	 * 
	 * @param lArray
	 * @param rArray
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static Object[] merge(Object[] lArray, Object[] rArray) {
		// {10,20,30,40,50} i = 3 , 100
		// {11,21,31} j = 3 , 50
		// 10 11 20 21 30 31 40 50 , k=8
		int i = 0;
		int j = 0;
		int k = 0;

		Object[] mArray =new Object[lArray.length + rArray.length];
		// 50
		while (i < lArray.length && j < rArray.length) {
			MyComparable comparable1 =  (MyComparable) lArray[i];
			MyComparable comparable2 =  (MyComparable) rArray[j];

			if ( comparable1.myCompareTo(comparable2)<0) {
				mArray[k] = lArray[i];
				i++;
			} else {
				mArray[k] = rArray[j];
				j++;
			}
			k++;
		}
		// 50
		while (i < lArray.length) {
			mArray[k] = lArray[i];
			i++;
			k++;
		}

		while (j < rArray.length) {
			mArray[k] = rArray[j];
			j++;
			k++;
		}
		return mArray;

	}

}
