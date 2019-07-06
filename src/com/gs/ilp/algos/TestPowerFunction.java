package com.gs.ilp.algos;

public class TestPowerFunction {
	public static void main(String[] args) {
		int res = power(2, 8); // 2*8-1 : 2*n-1
		System.out.println(res);
	}

	
	// 
	// power(2,8) =  16 *16 // sub problems
	// power(2,4) = 4*4
	// power(2,2) = 2*2
	// power(2,1) = 2 // smallest problem :

	// power(3,8)= 81*81
	// power(3,4) = 9*9
	// power(3,2) = 3*3
	// power(3,1) =3
	
	// T(n) = num of func* size of one function call
	// T(n) = O(n)
	// S(n) = num stack slots * size of each slot
	// = log(n) * 4B= O(log(n))
	static int power(int x, int n) {
		if (n == 1) {
			return x;
		}
		if (n % 2 == 0) {
			return power(x, n / 2) * power(x, n / 2); // Divide
		} else {
			return x * power(x, n / 2) * power(x, n / 2); // Divide

		}
	}

}
