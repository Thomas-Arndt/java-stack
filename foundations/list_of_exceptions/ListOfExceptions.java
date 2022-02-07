import java.util.ArrayList;

public class ListOfExceptions {
    public void runExceptions() {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("12");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for(int i=0; i< myList.size(); i++) {
            try{
                Integer castedValue = (Integer) myList.get(i);
            } catch (Exception e) {
                System.out.printf("Error: %s", e);
                System.out.printf("At index: %s\n", i);
                System.out.printf("With a value of: %s\n\n", myList.get(i));
            }
        }
    }
}