public class TestBankAccount {

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        account1.depositCash("checking", 150.0);
        account2.depositCash("savings", 200.0);
        account1.withdrawCash("checking", 100.0);
        account2.displayBalances();
        System.out.println(BankAccount.accountQuantity);
        System.out.println(BankAccount.totalBalance);
    }
}