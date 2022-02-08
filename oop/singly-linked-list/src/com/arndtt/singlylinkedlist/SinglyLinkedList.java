package com.arndtt.singlylinkedlist;

public class SinglyLinkedList {
	protected Node head;
	
	public SinglyLinkedList() {
		this.head = null;
	}
	
	public void addToEnd(int value) {
		Node newNode = new Node(value);
		if(this.head == null) {
			this.head = newNode;
		} else {
			Node runner = this.head;
			while(runner.getNext() != null) {
				runner = runner.getNext();
			}
			runner.setNext(newNode);
		}
	}
	
	public void removeFromEnd() {
		Node runner = this.head;
		while(runner.getNext().getNext() != null) {
			runner = runner.getNext();
		}
		runner.setNext(null);
	}
	
	public void printValues() {
		Node runner = this.head;
		while(runner != null) {
			System.out.printf("%s: %s\n", runner, runner.getValue());
			runner = runner.getNext();
		}
	}
	
	public Node find(int value) {
		Node runner = this.head;
		while(runner != null) {
			if(runner.getValue() == value) {
				return runner;
			}
			runner = runner.getNext();
		}
		return null;
	}
	
	public void removeAt(int index) {
		Node runner = this.head;
		if(index == 0) {
			this.setHead(runner.getNext());
		} else {
			for(int i = 0; i < index-1; i++) {
				runner = runner.getNext();
			}
			runner.setNext(runner.getNext().getNext());
		}
		
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
}
