package br.com.davikosta.bank;
import br.com.davikosta.messages.Errors;
import br.com.davikosta.messages.NewBalance;
import java.util.LinkedList;
import java.util.List;

public class BankAccount {
    private String customerName;
    private String accountType;
    private int customerSince;
    private static double customerBalance;
    private int finishedOperations;
    private final List<Double> transactionHistory = new LinkedList<>();

    public void deposit(double amountToDeposit) {
        customerBalance += amountToDeposit;
        registerNewOperation();
        incrementHistory(amountToDeposit);
        NewBalance.message();
    }

    public void printHistory() {
        System.out.printf("Ao todo foram feitas %d operações. As operações mais recentes ficam ao final da lista.%n", finishedOperations);
        for (double operation : transactionHistory) {
            if (operation < 0) {
                System.out.println("Saque: " + operation);
            } else {
                System.out.println("Depósito: " + operation);
            }
        }
    }

    private void incrementHistory(double amountToIncrement) {
        this.transactionHistory.add(amountToIncrement);
    }

    public void registerNewOperation() {
        this.finishedOperations++;
    }

    public void draw(double amountToDraw) {
        if (amountToDraw > 0 && amountToDraw <= customerBalance) {
            customerBalance -= amountToDraw;
            registerNewOperation();
            incrementHistory(-amountToDraw);
            NewBalance.message();
        } else {
            Errors.invalidAmountErrorMessage();
        }
    }

    public BankAccount (String customerName, String accountType, int customerSince, double customerBalance) {
        this.setCustomerName(customerName);
        this.setAccountType(accountType);
        this.setCustomerSince(customerSince);
        this.setCustomerBalance(customerBalance);
    }

    public String getCustomerName() {
        return customerName;
    }

    private void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getCustomerSince() {
        return customerSince;
    }

    private void setCustomerSince(int customerSince) {
        this.customerSince = customerSince;
    }

    public static double getCustomerBalance() {
        return customerBalance;
    }

    private void setCustomerBalance(double customerBalance) {
        BankAccount.customerBalance = customerBalance;
    }

    public int getFinishedOperations() {
        return finishedOperations;
    }
}
