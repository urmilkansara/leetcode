package com.leetcode;

import util.InputHelper;

import javax.swing.*;

/***
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
 * Could you solve it without converting the integer to a string?
 * https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber
{
	public static void main(String[] args){
		PalindromeNumber.isPalindrome();
	}
	public static boolean isPalindrome(){
		InputHelper inputHelper = new InputHelper();
		int x = inputHelper.getSingleInteger();

		if(x < 0 || x % 10 == 0){
			System.out.println("false");
			return false;
		}
		int rev = 0;
		while (x > rev){
			rev = rev * 10 + x % 10;
			x = x /10;
		}
		if (x == rev || x == rev /10){
			System.out.println("true");
			return true;
		}
		else { System.out.println("false"); return false;}

	}

}
