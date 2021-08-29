package com.leetcode;

import util.InputHelper;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters
{
	public static void main(String[] args)
	{
		InputHelper inputHelper = new InputHelper();
		System.out.println(LongestSubstringWithoutRepeatingCharacters.findLongestSubString(inputHelper.getSingleString()));
	}

	private static int findLongestSubString(final String s)
	{
//		Set<Character> characterSet = new HashSet<>();
//		int maxLength = 0;
//		for(Character c : singleString.toCharArray()){
//			if(characterSet.contains(c)){
//				if(maxLength < characterSet.size()){
//					maxLength = characterSet.size();
//				}
//				characterSet.clear();
//
//			}
//			characterSet.add(c);
//		}
//		if(maxLength < characterSet.size()) {
//			maxLength = characterSet.size();
//		}
//
//		return maxLength;

		int left = 0, right = 0, max = 0;
		Set<Character> set = new HashSet<>();

		while (right < s.length()) {
			if (!set.contains(s.charAt(right))) {
				set.add(s.charAt(right++));
				max = Math.max(max, set.size());
			} else {
				set.remove(s.charAt(left++));
			}
		}

		return max;
	}
}
