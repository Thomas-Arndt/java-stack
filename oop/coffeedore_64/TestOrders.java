import java.util.ArrayList;

public class TestOrders {

    public static void main(String[] args) {
        CoffeeKiosk kiosk = new CoffeeKiosk();
        kiosk.addMenuItem("Drip Coffee", 1.5);
        kiosk.addMenuItem("Latte", 3.5);
        kiosk.addMenuItem("Mocha", 4.0);
        kiosk.addMenuItem("Cappuccino", 3.5);
        kiosk.addMenuItem("Banana", 1.5);
        kiosk.addMenuItem("Doughnut", 1.5);
        kiosk.addMenuItem("Muffin", 2.5);
        kiosk.addMenuItemByInput();
        kiosk.newOrder();
    }
}