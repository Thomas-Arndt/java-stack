import java.util.ArrayList;

public class Order {
    private String name;
    private double total;
    private boolean isReady = false;
    private ArrayList<Item> items = new ArrayList<Item>();

    public Order() {
        this("Guest");
    }

    public Order(String name) {
        this.name = name;
    }

    // Order Methods
    public void addItem(Item item) {
        this.items.add(item);
        this.total += item.getPrice();
    }

    public String getStatusMessage() {
        if(isReady) {
            return "Your order is ready";
        } else {
            return "Thank you for waiting, your order will be ready soon.";
        }
    }

    public double getOrderTotal() {
        return this.total;
    }

    public void display() {
        System.out.printf("Customer Name: %s\n", this.name);
        for(Item item: this.items){
            System.out.printf("%s - $%.2f\n", item.getName(), item.getPrice());
        }
        System.out.printf("Total: $%.2f\n", this.total);
    }
    
    // Getters and Setters
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setIsReady(boolean isReady) {
        this.isReady = isReady;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setItems(ArrayList items) {
        this.items = items;
    }

    public ArrayList getItems() {
        return items;
    }
}