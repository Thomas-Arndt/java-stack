import java.util.ArrayList;

public class CafeUtil {

    public int getStreakGoal() {
        int sum = 0;
        for(int i = 1; i <= 10; i++) {
            sum += i;
        }
        return sum;
    }

    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        for(int i = 1; i <= numWeeks; i++) {
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double total = 0.0;
        for(double item : prices) {
            total += item;
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for(int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%s %s\n", i, menuItems.get(i));
        }
    }

    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> menuPrices) {
        if (menuItems.size() != menuPrices.size()) {
            return false;
        }
        System.out.println("\n----- Menu -----\n");
        for(int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%s %s -- $%.2f\n", i, menuItems.get(i), menuPrices.get(i));
        }
        return true;
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.printf("\nHello, %s!", userName);
        System.out.printf("There are %s people in front of you. \n\n", customers.size());
        customers.add(userName);
        for(int i = 0; i < customers.size(); i++) {
            System.out.printf("%s \n", customers.get(i));
        }
        System.out.println("\n--------------------");
    }

    public void addCustomers(ArrayList<String> customers) {
        boolean addMoreNames = true;
        while(addMoreNames) {
            System.out.println("Please enter customer name, or ':q' when finished:");
            String userName = System.console().readLine();
            if (userName.equals(":q")) {
                addMoreNames = false;
            } else {
                customers.add(userName);
            }
        }
        for(int i = 0; i < customers.size(); i++) {
            System.out.printf("%s \n", customers.get(i));
        }
        System.out.println("\n--------------------");
    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.printf("\n%s\n", product);
        for (int i = 1; i <= maxQuantity; i++) {
            System.out.printf("%s - $%.2f\n", i, ((i*price)-((i-1)*0.5)));
        } 
    }

}