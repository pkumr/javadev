package com.bits;

/**
 *
 * Bit Operations in Java
 * @author parveenkumar
 *
 * */

public class BitwiseOperations {
	public static void main(String[] args) {
		BitwiseOperations b = new BitwiseOperations();
		b.printBits(40);
		System.out.println("b.modifyKthBit_0to1(11, 2)");
		b.modifyKthBit_0to1(11, 2);
		System.out.println("b.modifyKthBit_1to0(11, 1)");
		b.modifyKthBit_1to0(11, 1);
		System.out.println();
		b.invertKthBit(11, 2);
		
		System.out.println();
		System.out.println( b.countOnes(11));
		
		System.out.println();
		b.setAllBitsTo_0_except_last(12);
		
		System.out.println();
		b.invertAllBitsAfterlastOne(40);
		
		System.out.println();
		System.out.println( b.isPowerOf2(8));
		System.out.println( b.isPowerOf2(9));
	}
	private void printBits(int x) {
		for(int i = 31; i >= 0; i--) {
			//System.out.println(1 << i);
			if((x & (1 << i)) != 0){
				System.out.print(1);
			}else {
				System.out.print(0);
			}
		}
		System.out.println();
	}
	private void modifyKthBit_0to1(int x, int k) {
		System.out.print(x);
		System.out.print(" - ");
		printBits(x);
		int out = x | (1 << k);
		System.out.print("1 << k - " + (1 << k) +" - ");
		printBits(1 << k);
		System.out.print(out + " - ");
		printBits(out);
	}
	private void modifyKthBit_1to0(int x, int k) {
		System.out.print(x + " - ");
		printBits(x);
		printBits(1 << k);
		printBits(~ (1 << k));
		int out = x & ~(1 << k);
		printBits(out);
	}
	private void invertKthBit(int x, int k) {
		printBits(x);
		int out = x ^ (1 << k);
		printBits(out);
	}
	private int countOnes(int x) {
		int count = 0;
		while(x != 0) {
			System.out.print("x - " + x + " - ");
			printBits(x);
			System.out.print("(x- 1) - " + (x - 1) + " - ");
			printBits(x-1);
			//One another observation here is last 1(bit)
			//in number is set to 0 by x & x-1 operation!
			x = x & (x - 1);
			count++;
		}
		return count;
	}
	private void setAllBitsTo_0_except_last(int x) {
		printBits(x);
		//x & -x sets all bits in x to 0 except last 1 bit 
		//(irrespective of position
		
		int out = x & -x;
		printBits(out);
	}
	private void invertAllBitsAfterlastOne(int x) {
		printBits(x);
		int  out = x | (x - 1);
		printBits(out);
	}
	private boolean isPowerOf2(int x) {
		return (x & (x - 1)) == 0 ? true : false;
	}
}
