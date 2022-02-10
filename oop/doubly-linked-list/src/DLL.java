
public class DLL {
	protected Node head;
	protected Node tail;
	
	public DLL() {
		this.head = null;
		this.tail = null;
	}
	
	public void addToEnd(String data) {
		Node newNode = new Node(data);
		if(this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.setNext(newNode);
			newNode.setPrev(this.tail);
			this.tail = newNode;
		}
	}
	
	public void addToStart(String data) {
		Node newNode = new Node(data);
		if(this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.head.setPrev(newNode);
			newNode.setNext(this.head);
			this.head = newNode;
		}
	}
	
	public void printForwards() {
		if(this.head == null) {
			System.out.println("List is empty.");
		} else {
			Node runner = this.head;
			while(runner != null) {
				System.out.println(runner.getData());
				runner = runner.getNext();
			}
			
		}
	}
	
	public void printBackwards() {
		if(this.head == null) {
			System.out.println("List is empty.");
		} else {
			Node runner = this.tail;
			while(runner != null) {
				System.out.println(runner.getData());
				runner = runner.getPrev();
			}
		}
	}
	
	public Node pop() {
		Node popNode = this.tail;
		this.tail = this.tail.getPrev();
		this.tail.setNext(null);
		return popNode;
	}
	
	public boolean contains(String value) {
		if(this.head == null) {
			return false;
		} else {
			Node hRunner = this.head;
			Node tRunner = this.tail;
			while(hRunner != tRunner && hRunner.getPrev() != tRunner) {
				if(hRunner.getData() == value || tRunner.getData() == value) {
					return true;
				}
				hRunner = hRunner.getNext();
				tRunner = tRunner.getPrev();
			}
			if(hRunner.getData() == value) {
				return true;
			}
			return false;
		}
	}
	
	public int size() {
		if(this.head == null) {
			return 0;
		} else {
			int count = 0;
			Node runner = this.head;
			while(runner != null) {
				count++;
				runner = runner.getNext();
			}
			return count;
		}
	}
	
	public void insertAt(String data, int index) {
		Node newNode = new Node(data);
		if(this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			Node runner = this.head;
			for(int i = 0; i < index-1; i++) {
				runner = runner.getNext();
			}
			runner.getNext().setPrev(newNode);
			newNode.setNext(runner.getNext());
			runner.setNext(newNode);
			newNode.setPrev(runner);
		}
	}
	
	public void removeAt(int index) {
		if(this.head == null) {
			System.out.println("List is empty.");
		} else {
			Node runner = this.head;
			for(int i = 0; i < index; i++) {
				runner = runner.getNext();
			}
			runner.getPrev().setNext(runner.getNext());
			runner.getNext().setPrev(runner.getPrev());
		}
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}
	
}
