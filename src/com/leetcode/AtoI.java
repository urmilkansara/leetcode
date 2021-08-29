package com.leetcode;

import util.InputHelper;

public class AtoI
{
	public static void main(String[] args)
	{
		InputHelper inputHelper = new InputHelper();

		while(true){
			String s = inputHelper.getSingleString();
			System.out.println(AtoI.convert(s));
		}

	}

	private static int convert(String s)
	{

		int aToI = 0;
		int sign = 1;
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		for(Character c: s.trim().toCharArray()){
			if(c == '-' && flag ==0 && sb.length() == 0){
				flag = 1;
				sign = -1;
			} else if (c == '+' && flag == 0) {
				flag = 1;
			} else if (Character.isDigit(c)){
				sb.append(c);
			} else {
				break;
			}
		}
		if(sb.length() > 0) {
			try
			{
				aToI = Integer.parseInt(sb.toString());
			} catch (NumberFormatException e){
				return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
		}

		return aToI * sign;
	}
}
