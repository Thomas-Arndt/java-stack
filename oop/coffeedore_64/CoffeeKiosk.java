import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public CoffeeKiosk() {
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    public void addMenuItem(String name, double price) {
        Item newItem = new Item(name, price);
        newItem.setIndex(menu.size());
        this.menu.add(newItem);
    }

    public void displayMenu() {
        System.out.print("----- Menu -----\n");
        for(Item item: this.menu) {
            System.out.printf("%s Name: %s -- Price: %.2f\n", item.getIndex(), item.getName(), item.getPrice());
        }
    }

    public void newOrder() {
        System.out.println("Please enter a name for the order:");
        String name = System.console().readLine();
        Order newOrder = new Order(name);
        displayMenu();
        System.out.println("Enter a menu item, or q to continue:");
        String itemIndex = System.console().readLine();
        while(!itemIndex.equals("q")) {
            newOrder.addItem(menu.get(Integer.parseInt(itemIndex)));
            System.out.println("Enter another menu item, or q to continue:");
            itemIndex = System.console().readLine();
        }
        this.orders.add(newOrder);
        System.out.println("\nThank you for your order.");
        for(Order order: orders){
            order.display();
        }
    }

    public void addMenuItemByInput() {
        String moreItems = "y";
        while(!moreItems.equals("n")) {
            System.out.println("Please enter the menu item name:");
            String itemName = System.console().readLine();
            System.out.println("How much does this item cost?");
            String itemPrice = System.console().readLine();
            addMenuItem(itemName, Double.parseDouble(itemPrice));
            System.out.println("Would you like to add another item? (y/n)");
            moreItems = System.console().readLine();
        }
    }
}