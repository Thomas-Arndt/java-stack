package com.arndtt.singlylinkedlist;

public class TestSLL {

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.addToEnd(3);
		sll.addToEnd(4);
		sll.addToEnd(10);
		sll.addToEnd(5);
		sll.addToEnd(15);
		sll.addToEnd(2);
		sll.removeFromEnd();
		sll.removeFromEnd();
		sll.printValues();
		Node searchNode = sll.find(10);
		System.out.println(searchNode);
		sll.removeAt(2);
		sll.printValues();
	}

}
