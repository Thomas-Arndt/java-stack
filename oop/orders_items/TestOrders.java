import java.util.ArrayList;

public class TestOrders {

    public static void main(String[] args) {
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        Item item4 = new Item();
        item1.name = "Drip Coffee";
        item2.name = "Cappicciono";
        item3.name = "Latte";
        item4.name = "Mocha";
        item1.price = 1.5;
        item2.price = 3.5;
        item3.price = 4.5;
        item4.price = 3.5;
        
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();
        order1.name = "Cindihuri";
        order2.name = "Jimmy";
        order3.name = "Noah";
        order4.name = "Sam";

    // Jimmy orders a drip coffee
        order2.items.add(item1);
        order2.total += item1.price;

    // Noah orders a cappuccino
        order3.items.add(item2);
        order3.total += item2.price;

    // Sam orders a latte
        order4.items.add(item3);
        order4.total += item3.price;
    
    // Cindihuri's order is ready
        order1.isReady = true;
    
    // Sam orders 2 lattes
        order4.items.add(item3);
        order4.items.add(item3);
        order4.total += (2*item3.price);
    
    // Jimmy's order is now ready
        order2.isReady = true;

    }
}