package Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<BankAccount> listOfUsers = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "Create":
                    System.out.printf("Account ID%s created%n", BankAccount.idCounter);
                    BankAccount bankAccount = new BankAccount();
                    listOfUsers.add(bankAccount);
                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]) - 1;
                    int amount = Integer.parseInt(tokens[2]);
                    if (listOfUsers.size() > id) {
                        listOfUsers.get(id).deposit(amount);
                        System.out.printf("Deposited %d to ID%d%n", amount, id+1);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]) -1;
                    int years = Integer.parseInt(tokens[2]);
                    if (listOfUsers.size() > id) {
                        System.out.printf("%.2f%n",listOfUsers.get(id).getInterestRate(years));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
