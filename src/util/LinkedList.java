package util;

/**
 * singly linked list
 *
 */
public class LinkedList
{
	public Node head;
	public Node tail;
	public LinkedList(){}

	public LinkedList(final int i)
	{
	}

	public void addNewNode(int num)
	{
		Node newNode = new Node(num);
		if (head == null)
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			while (tail.next != null)
			{
				tail = tail.next;
			}
			tail.next = newNode;
			tail = newNode;
		}
	}

	public void printNode()
	{
		Node current = head;
		while(current != null){
			System.out.println(current.num);
			current = current.next;
		}
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
