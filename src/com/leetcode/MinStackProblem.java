package com.leetcode;


import java.util.Stack;
/**
 * https://leetcode.com/problems/min-stack/
 * */
public class MinStackProblem
{
	public static void main(String[] args)
	{
		// good solution.
		MinStack minStack = new MinStack();
		minStack.push(-1);
		minStack.push(0);
		minStack.push(-3);
		minStack.pop();
		minStack.pop();
		System.out.println(minStack.getMin());

		// very nice solution.
		MinStack1 minStack1 = new MinStack1();
		minStack1.push(-1);
		minStack1.push(0);
		minStack1.push(-3);
		minStack1.pop();
		minStack1.pop();
		System.out.println(minStack.getMin());

	}

	static class MinStack {
		int min = Integer.MAX_VALUE;
		Stack<Integer> stack = new Stack<Integer>();
		MinStack(){};
		public void push(int x) {
			// only push the old minimum value when the current
			// minimum value changes after pushing the new value x
			if(x <= min){
				stack.push(min);
				min=x;
			}
			stack.push(x);
		}

		public void pop() {
			// if pop operation could result in the changing of the current minimum value,
			// pop twice and change the current minimum value to the last minimum value.
			if(stack.pop() == min) min=stack.pop();
		}

		public int top() {
			return stack.peek();
		}

		public int getMin() {
			return min;
		}
	}

	static class MinStack1 {
		private Node head;

		public void push(int x) {
			if (head == null)
				head = new Node(x, x, null);
			else
				head = new Node(x, Math.min(x, head.min), head);
		}

		public void pop() {
			head = head.next;
		}

		public int top() {
			return head.val;
		}

		public int getMin() {
			return head.min;
		}

		private class Node {
			int val;
			int min;
			Node next;

			private Node(int val, int min, Node next) {
				this.val = val;
				this.min = min;
				this.next = next;
			}
		}
	}
}
