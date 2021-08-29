package com.leetcode;

import util.InputHelper;

public class ZigZagConversion
{
	public static void main(String[] args)
	{
		InputHelper inputHelper = new InputHelper();
		String s = inputHelper.getSingleString();
		Integer numRows = inputHelper.getSingleInteger();

		System.out.println(ZigZagConversion.convert(s, numRows));
	}

	private static String convert(final String s, final Integer numRows)
	{
		if (s.length() == 0) return null;
		if(numRows <= 1) return s;
		if(s.length() <= numRows) return  s;
		StringBuilder[] sb = new StringBuilder[numRows];
		for (int i =0; i< numRows; i++){
			sb[i] = new StringBuilder();
		}
		int x = 0; int direction = 1;
		for (int i = 0; i < s.length(); i ++){
			if(x == 0) direction = 1;
			if(x == numRows - 1) direction = -1;
			sb[x].append(s.charAt(i));
			x += direction;
		}
		StringBuilder s1 = new StringBuilder();
		for(int i =0; i< numRows; i++){
			s1.append(sb[i]);
		}
		return s1.toString();
	}
}
