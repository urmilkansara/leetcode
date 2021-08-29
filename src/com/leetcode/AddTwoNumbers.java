package com.leetcode;

import util.InputHelper;
import util.LinkedList;
import util.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AddTwoNumbers
{
	public static void main(String[] args)
	{
		InputHelper inputHelper = new InputHelper();
		List<LinkedList> linkedLists = new ArrayList<>();
		IntStream.range(0,2).forEachOrdered( n -> {
				linkedLists.add(LinkedList.createListNode(inputHelper.getSingleString()));
			}
		);
		LinkedList s = new LinkedList();
		s.head = AddTwoNumbers.addTwoNumbers(linkedLists.get(0).head, linkedLists.get(1).head);
		s.printNode();


	}

	public static Node addTwoNumbers(Node l1, Node l2){
		if (l1 == l2) return null;

		if (l2 == null) return l1;
		if (l1 == null) return l2;
		Node l3 = null;
		Node headNode = null;
		int carry = 0;
		int flag = 0;
		while(l1 != null && l2 != null){
			int total = l1.num + l2.num + carry;
			if(total >= 10){
				carry = 1;
				total = total % 10;
			} else { carry = 0;}
			Node newNode = new Node(total);
			if(flag == 0) {
				l3 = newNode;
				headNode = l3;
			} else {
				l3.next = newNode;
				l3 = newNode;
			}
			flag = 1;
			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null){
			int total = l1.num + carry;
			if (total >= 10)
			{
				carry = 1;
				total = total % 10;
			}else { carry = 0;}
			Node newNode = new Node(total);
			l3.next = newNode;
			l3 = newNode;
				l1 = l1.next;
		}

		while (l2 != null){
			int total = l2.num + carry;
			if (total >= 10)
			{
				carry = 1;
				total = total % 10;
			}else { carry = 0;}
			Node newNode = new Node(total);
			l3.next = newNode;
			l3 = newNode;
			l2 = l2.next;
		}
		if(carry == 1) {
			Node newNode = new Node(carry);
			l3.next = newNode;
			l3 = newNode;
		}

		return headNode;
	}


}
