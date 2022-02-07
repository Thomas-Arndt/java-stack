import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private String accountNumber;
    public static int accountQuantity;
    public static double totalBalance;

    public BankAccount() {
        accountQuantity++;
        this.accountNumber = createAccountNumber();
    }

    private String createAccountNumber() {
        Random randomGenerator = new Random();
        String acctNumber = "";
        for(int i = 0; i < 10; i++) {
            acctNumber = acctNumber+randomGenerator.nextInt(10);
        }
        return acctNumber;
    }

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public void depositCash(String account, double amount) {
        if(account == "checking") {
            this.checkingBalance += amount;
        }
        else if(account == "savings") {
            this.savingsBalance += amount;
        }
        totalBalance += amount;
    }

    public void withdrawCash(String account, double amount) {
        if(account == "checking" && this.checkingBalance >= amount) {
            this.checkingBalance -= amount;
            totalBalance -= amount;
        }
        else if(account == "savings" && this.savingsBalance >= amount) {
            this.savingsBalance -= amount;
            totalBalance -= amount;
        }
    }

    public void displayBalances() {
        System.out.printf("Account No: %s\n", this.accountNumber);
        System.out.printf("Checking: $%.2f\n", this.checkingBalance);
        System.out.printf("Savings: $%.2f", this.savingsBalance);
    }

}