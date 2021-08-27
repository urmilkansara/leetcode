package com.leetcode;

import util.InputHelper;

import java.util.HashMap;
/***
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger
{
	static HashMap<Character, Integer> romanMap = new HashMap<>();
	public static void main(String[] args){
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);
		InputHelper inputHelper = new InputHelper();

		System.out.println(RomanToInteger.convert(inputHelper.getSingleString()));
	}

	public static int convert(String roman){
		int integerVal = romanMap.get(roman.charAt(0));
		int prevValue = romanMap.get(roman.charAt(0));

		if (roman.length() == 1) { return prevValue; }
		for (int i = 1; i < roman.length(); i++){
			int currentVal = romanMap.get(roman.charAt(i));
				if(prevValue >= currentVal){
					integerVal += currentVal;
				} else {
					integerVal += currentVal - prevValue * 2;
				}
				prevValue = currentVal;
		}
		return integerVal;
	}
}
