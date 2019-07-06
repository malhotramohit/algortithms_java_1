package com.gs.ilp.algos;

// fact(4) = 4*3*2*1
// fact(4) = 4*fact(3)
// fact(3) = 3 * fact(2)
// fact(2) = 2*fact(1)
// fact(1) = 1 ///1*fact(0)
// fact(0) = 0*fact(-1)
public class TestFactorial {

	public static void main(String[] args) {
		int res = imperativeFact(5);
		System.out.println(res);
	}

	// T(n) = (num of fn =num stack slots) * time taken in one function call
	// = 10*1=10
	// O(n)
	// fact(5) : 5*fact(4)
	// S(n) = Extra space:stack: size of each stack slot * num stack slots
	// 4B*n= 4n= O(n)
	static int fact(int num) {
		if (num == 1) {
			return 1;
		}
		return num * fact(num - 1);
	}

	// T(n) = n-1= O(n)
	// S(n) = 8B
	static int imperativeFact(int num) {
		// 5: 5 * 4*3*2*1
		int res = num;
		for (int i = num - 1; i > 0; i--) {
			res = res * i;// 5*4: 20*3
		}
		return res;
	}

}
