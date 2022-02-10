
public class TestDLL {

	public static void main(String[] args) {
		DLL dll = new DLL();
		
		dll.addToStart("node 2");
		dll.addToEnd("node 3");
		dll.addToStart("node 1");
		dll.addToEnd("node 4");
		dll.printForwards();
		System.out.println("*********");
		dll.printBackwards();
		System.out.println("*********");
		System.out.println(dll.pop());
		System.out.println("*********");
		dll.printForwards();
		System.out.println(dll.contains("node 2"));
		System.out.println(dll.contains("node 5"));
		System.out.println("*********");
		System.out.println(dll.size());
		dll.insertAt("node 5", 2);
		System.out.println("*********");
		dll.printForwards();
		dll.removeAt(2);
		System.out.println("*********");
		dll.printForwards();
		
	}

}
