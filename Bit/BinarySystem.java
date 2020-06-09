package com.cs;



public class BinarySystem {
	public static void main(String[] args) {
		BinarySystem o = new BinarySystem();
		//Increment by one
		o.incrementMax();
		
		//AND Operation of 22 and 26 is 18
		o.andOperation(22, 26);
		
		//OR Operation of 22 and 26 is 18
		o.orOperation(22, 26);
	
		//XOR Operation of 22 and 26 is 18
		o.xorOperation(22, 26);
		
		//NOT Operation produces -x-1
		//NOT of 29, 100, 89
		o.notOperation(29);
		o.notOperation(100);
		o.notOperation(89);
		
		//Check for 4 is even and 5 is odd!
		o.isEvenOrOdd(4);
		o.isEvenOrOdd(5);
		
		//Bit Shifts
		o.bitLShift(14, 2);
		o.bitRShift(49, 3);
	}
	private void incrementMax() {
		int value = Integer.MAX_VALUE;
		System.out.println("Maximum Value is " + value);
		value++;
		System.out.println("Max Value Increment by one " + value);
	}
	private void andOperation(int x, int y) {
		int out = x & y;
		/*
		 * 0 & 0 => 0
		 * 0 & 1 => 0
		 * 1 & 1 => 1
		 * 
		 * 22 - 10110
		 * 26 - 11010
		 * & -> 10010 => 18
		 * 
		 * */
		System.out.println(x + " & " + y + " is " + out);
	}
	private void orOperation(int x, int y) {
		int out = x | y;
		/*
		 * 0 | 0 => 0
		 * 0 | 1 => 1
		 * 1 | 1 => 1
		 * 
		 * 22	10110
		 * 26	11010
		 * |  	11110 --> 30
		 * */
		System.out.println(x + " | " + y + " is " + out);
	}
	
	private void xorOperation (int x, int y) {
		int out = x ^ y;
		/*
		 * 0 ^ 0 => 0
		 * 0 ^ 1 => 1
		 * 1 ^ 1 => 0
		 * 
		 * 22	10110
		 * 26	11010
		 * ^ 	01110 --> 12
		 * */
		System.out.println(x + " ^ " + y + " is " + out);
	}
	private void notOperation(int x) {
		System.out.println(" ~  of " + x + " is " +  ~x );
	}
	
	private void isEvenOrOdd(int x) {
		if((x & 1) == 0) {
			System.out.println(x +  " is Even !");
			System.out.println("Number is Even when Number (&) 1 == 0");
		}else if ((x & 1) == 1) {
			System.out.println(x + " is Odd !");
			System.out.println("Number is Odd when Number (&) 1 == 1 ");
		}
	}
	
	private void bitLShift(int x, int shiftVal) {
		/*
		 * 
		 * The left bit shift appends k zero bits to the number
		 * << means number multiples 2 POW (K)
		 * 14 * (2 POWER 2) = 14 * 4
		 * 
		 * Output - 56
		 * 14 - 1110
		 * 56 - 111000
		 * All bits shifted left
		 * 
		 */
		int left = x << shiftVal;
		System.out.println(x + " << " + shiftVal + " is " + left );
		
	}
	private void bitRShift(int x, int shiftVal) {
		/*
		 * 
		 * The right bit shift removes k last bits from number
		 * >> means number divided by  2 POW (K) [rounded down to INT]
		 * 49 divided by 2 POW (3) - 49 divided by 8
		 * 
		 * Output - 6
		 * 49 - 110001
		 * 6  - 110
		 * */
		int right = x >> shiftVal;
		System.out.println(x + " >> " + shiftVal + " is " + right );
	}
}
