package com.leetcode;

import util.InputHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/most-common-word/
 * */

public class MostCommonWord
{
	public static void main(String[] args)
	{
		InputHelper inputHelper = new InputHelper();
		while (true)
		{
			System.out.println("Enter paragraph");
			String paragraph = inputHelper.getSingleString();
			System.out.println("Enter banned words");
			String[] bannedWords = inputHelper.getSingleString().toLowerCase().replaceAll("[^a-zA-Z0-9 ]", " ").split("\\s+");

			// fast solution ->5 ms
			System.out.println(MostCommonWord.anotherSolution(paragraph, bannedWords));

			//first solution ->19 ms
			String[] words = paragraph.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", " ").split("\\s+");
			HashMap<String, Integer> map = new HashMap<>();
			for (String word : words)
			{
				map.put(word, map.getOrDefault(word, 0) + 1);
			}
			System.out.println(map);
			System.out.println(MostCommonWord.extractMostCommonWord(map, bannedWords));

		}
	}

	public static String extractMostCommonWord(Map<String, Integer> map, String[] bannedWords)
	{
		for (String bannedWord : bannedWords)
		{
			map.remove(bannedWord);
		}
		String mostFrequentWord = null;
		int prevValue = 0;
		for (Map.Entry<String, Integer> entry : map.entrySet())
		{
			if (entry.getValue() > prevValue)
			{
				mostFrequentWord = entry.getKey();
				prevValue = entry.getValue();
			}
		}
		return mostFrequentWord;
	}

	public static String anotherSolution(String paragraph, String[] banned)
	{
		Map<String, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		int max = Integer.MIN_VALUE;
		String maxString = "";

		Set<String> set = new HashSet<>(Arrays.asList(banned));

		for (char c : paragraph.toCharArray())
		{
			if (Character.isLetter(c))
			{
				sb.append(c);
			}
			else
			{
				String str = sb.toString().toLowerCase();
				if (str.length() > 0 && !set.contains(str))
				{
					map.put(str, map.getOrDefault(str, 0) + 1);
					if (map.get(str) > max)
					{
						max = map.get(str);
						maxString = str;
					}

				}
				sb.delete(0, sb.length());
			}
		}
		if (sb.length() > 0 && max == Integer.MIN_VALUE)
			maxString = sb.toString().toLowerCase();
		return maxString;
	}
}
