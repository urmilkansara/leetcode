package com.leetcode;

import util.InputHelper;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: s = "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: s = "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: s = "{[]}"
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 * <p>
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses
{

	public static void main(String[] args)
	{
		InputHelper inputHelper = new InputHelper();
		while (true)
		{
			System.out.println(ValidParentheses.isValid(inputHelper.getSingleString()));
		}

	}

	public static boolean isValid(String s)
	{

		Stack<Character> characterStack = new Stack<>();
		for (char c : s.toCharArray())
		{
			if (c == '[' || c == '(' || c == '{')
			{
				characterStack.push(c);
			}
			else if (c == ']' || c == ')' || c == '}')
			{
				if (characterStack.isEmpty())
				{
					return false;
				}
				else if (c == ']' && characterStack.peek() == '[')
				{
					characterStack.pop();
				}
				else if (c == '}' && characterStack.peek() == '{')
				{
					characterStack.pop();
				}
				else if (c == ')' && characterStack.peek() == '(')
				{
					characterStack.pop();
				}
				else
				{
					return false;
				}
			}
		}

		return characterStack.isEmpty();

	}
}
