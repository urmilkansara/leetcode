package com.leetcode;

import util.InputHelper;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * https://leetcode.com/problems/reverse-integer/
 * */
public class ReverseInteger
{
	public static void main(String[] args){
		InputHelper inputHelper = new InputHelper();
		int inputInteger = inputHelper.getSingleInteger();
		int rev =0;
		int finalRev = 0;
		while(inputInteger != 0){

			rev = inputInteger % 10;
			inputInteger = inputInteger /10;
			if (finalRev > Integer.MAX_VALUE / 10 || (finalRev == Integer.MAX_VALUE / 10 && rev > 7)
				|| finalRev < Integer.MIN_VALUE / 10 || (finalRev == Integer.MIN_VALUE / 10 && rev < -8))
			{
				System.out.println(finalRev);
			}
			finalRev = finalRev * 10 + rev;

		}

		System.out.println(finalRev);
	}
}
