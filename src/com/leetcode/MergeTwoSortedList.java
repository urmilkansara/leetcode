package com.leetcode;

import util.InputHelper;
import util.LinkedList;
import util.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * */
public class MergeTwoSortedList
{
	public static void main(String[] args)
	{
		InputHelper inputHelper = new InputHelper();

		List<LinkedList> linkedLists = new ArrayList<>();
		IntStream.range(0,2).forEachOrdered( n -> {
			linkedLists.add(createListNode(inputHelper.getSingleString()));
			}
		);
		LinkedList finalList = new LinkedList();
		finalList.head = MergeTwoSortedList.mergeLists(linkedLists.get(0).head, linkedLists.get(1).head);;
		finalList.printNode();
	}

	private static Node mergeLists(Node l1, Node l2)
	{
		if(l1 == l2) return l1;  // null == null yields true

		// if one of them is null, return the other
		if(l1 == null) return l2;
		if(l2 == null) return l1;


		Node mergedHead,mergedTail;
		mergedHead = mergedTail = new Node(-1); // dummy node to avoid excessive null checks

		Node next = new Node();
		while(l1 != null && l2 != null) {
			if(l1.num <= l2.num) {
				next = l1.next;
				l1.next = null;

				mergedTail.next = l1;
				mergedTail=l1;
				l1 = next;
			} else {
				next = l2.next;
				l2.next = null;

				mergedTail.next = l2;
				mergedTail=l2;
				l2 = next;
			}
		}

		while(l1 != null) {
			next = l1.next;
			l1.next = null;

			mergedTail.next = l1;
			mergedTail=l1;
			l1= next;
		}

		while(l2 != null) {
			next = l2.next;
			l2.next = null;

			mergedTail.next = l2;
			mergedTail=l2;
			l2 = next;
		}

		return mergedHead.next;

	}

	public static LinkedList createListNode(final String singleString)
	{
		String[] s = singleString.split(" ");
		LinkedList list = new LinkedList(-1);

		for (final String value : s)
		{
			list.addNewNode(Integer.parseInt(value));
		}

		return list;

	}
}
