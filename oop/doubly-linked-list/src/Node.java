
public class Node {
	protected String data;
	protected Node next, prev;
	
	public Node(String data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
