package Bank;

public class BankAccount {
    public static double interestRate = 0.02;
    public static int idCounter = 1;
    private int id;
    private double balance;

    public BankAccount () {
        this.id = idCounter++;
    }
    public static void setInterestRate(double interest) {
        BankAccount.interestRate = interest;
    }
    public void deposit(double amount) {
        this.balance += amount;
    }
    double getInterestRate (int year) {
        return interestRate * year * this.balance;
    }

}
