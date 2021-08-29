package com.leetcode;

import util.InputHelper;
import util.LinkedList;
import util.Node;

public class ReverseLinkedList
{
	public static void main(String[] args)
	{
		InputHelper inputHelper = new InputHelper();
		LinkedList list = createListNode(inputHelper.getSingleString());
		LinkedList l = new LinkedList();
		l.head = ReverseLinkedList.reverse(list.head);
		l.printNode();

	}

	private static Node reverse(Node head)
	{
		Node next;
		Node prev = null;

		while(head != null){
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	public static LinkedList createListNode(final String singleString)
	{
		String[] s = singleString.split(" ");
		LinkedList list = new LinkedList();

		for (final String value : s)
		{
			list.addNewNode(Integer.parseInt(value));
		}

		return list;

	}
}
