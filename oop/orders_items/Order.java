import java.util.ArrayList;

public class Order {
    public String name;
    public double total;
    public boolean isReady = false;
    public ArrayList<Item> items = new ArrayList<Item>();
}