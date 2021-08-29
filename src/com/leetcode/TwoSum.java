package com.leetcode;

import util.InputHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TwoSum
{
	public static void main(String[] args)
	{
		InputHelper inputHelper = new InputHelper();
		int[] nums = inputHelper.getListofIntegers();
		Integer target = inputHelper.getSingleInteger();

		System.out.println(Arrays.toString(TwoSum.calculate(nums, target)));

	}

	private static int[] calculate(final int[] nums, final Integer target)
	{
		int[] answer = new int[2];

		HashMap<Integer, Integer> inputNumbers = new HashMap();
		for(int i=0; i< nums.length; i ++){
			if(inputNumbers.containsKey(target-nums[i])){
				answer[1] = i;
				answer[0] = inputNumbers.get(target - nums[i]);
				return answer;
			}
			inputNumbers.put(nums[i], i);
		}

		return answer;
	}
}
