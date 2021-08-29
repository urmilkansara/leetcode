package com.leetcode;

import util.InputHelper;

import java.util.List;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 * <p>
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix
{

	public static void main(String[] args)
	{
		InputHelper inputHelper = new InputHelper();
		List<String> listOfStrings = inputHelper.getData();
		System.out.println(LongestCommonPrefix.getLCP(listOfStrings));
	}

	public static String getLCP(List<String> listOfStrings)
	{
		if (listOfStrings.size() == 0)
		{
			return "";
		}
		String test = listOfStrings.get(0);

		StringBuilder lcp = new StringBuilder("");
		for (int i = 0; i < test.length(); i++)
		{
			char c = test.charAt(i);
			int count = 0;
			for (String x : listOfStrings)
			{
				if (x.length() <= i)
				{
					break;
				}
				else if (x.charAt(i) != c)
				{
					break;
				}
				count++;
			}
			if (count == listOfStrings.size())
			{
				lcp.append(c);
			}
			else
			{
				break;
			}
		}
		return lcp.toString();

	}
}
