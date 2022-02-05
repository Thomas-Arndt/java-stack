public class CafeJava {
    public static void main(String[] args) {
        String generalGreeting = "Welcome to the Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";

        double mochaPrice = 3.5;
        double dripCoffee = 2;
        double latte = 3.25;
        double cappuccino = 3.25;

        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        boolean isReadyOrder1 = false;
        boolean isOrderReady2 = true;
        boolean isOrderReady3 = false;
        boolean isOrderReady4 = true;

        System.out.println(generalGreeting + customer1); 
        System.out.println(customer1 + pendingMessage);
        System.out.println(generalGreeting + customer4);
        if(isOrderReady4){
            System.out.println(customer4 + readyMessage);
            System.out.println(displayTotalMessage + cappuccino);
        } else {
            System.out.println(customer4 + pendingMessage);
        }
        System.out.println(generalGreeting + customer2);
        System.out.println(displayTotalMessage + (2*latte));
        if(isOrderReady2){
            System.out.println(customer2 + readyMessage);
        } else {
            System.out.println(customer2 + pendingMessage);
        }
        System.out.println(customer3);
        System.out.println(displayTotalMessage + (latte-dripCoffee));
        
    }
}