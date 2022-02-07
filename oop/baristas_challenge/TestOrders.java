import java.util.ArrayList;

public class TestOrders {

    public static void main(String[] args) {
        Item item1 = new Item("Drip Coffee", 1.5);
        Item item2 = new Item("Cappuccino", 3.5);
        Item item3 = new Item("Latte", 4.5);
        Item item4 = new Item("Mocha", 3.5);

        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order("Chinihuri");
        Order order4 = new Order("Jimmy");
        Order order5 = new Order("Noah");
        
        order1.addItem(item1);
        order1.addItem(item3);
        order2.addItem(item2);
        order2.addItem(item4);
        order3.addItem(item1);
        order3.addItem(item4);
        order4.addItem(item2);
        order4.addItem(item3);
        order5.addItem(item1);
        order5.addItem(item1);

        order2.setIsReady(true);
        order4.setIsReady(true);
        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();
    }
}