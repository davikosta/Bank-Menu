package br.com.davikosta.bank;
import br.com.davikosta.messages.Errors;
import br.com.davikosta.messages.NewBalance;

import java.util.ArrayList;

public class BankAccount {
    private String consumerName;
    private String accountType;
    private int consumerSince;
    private static double consumerBalance;
    private int finishedOperations;
    private final ArrayList<Double> transactionHistory = new ArrayList<>();

    public void deposit(double amountToDeposit) {
        consumerBalance += amountToDeposit;
        registerNewOperation();
        incrementHistory(amountToDeposit);
        NewBalance.message();
    }

    public void printHistory() {
        System.out.printf("Ao todo foram feitas %d operações. As operações mais recentes ficam ao final da lista.%n", finishedOperations);
        for (double operation : transactionHistory) {
            System.out.println(operation);
        }
    }

    private void incrementHistory(double amountToIncrement) {
        this.transactionHistory.add(amountToIncrement);
    }

    public void registerNewOperation() {
        this.finishedOperations++;
    }

    public void draw(double amountToDraw) {
        if (amountToDraw > 0 && amountToDraw <= consumerBalance) {
            consumerBalance -= amountToDraw;
            registerNewOperation();
            incrementHistory(-amountToDraw);
            NewBalance.message();
        } else {
            Errors.invalidAmountErrorMessage();
        }
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getConsumerSince() {
        return consumerSince;
    }

    public void setConsumerSince(int consumerSince) {
        this.consumerSince = consumerSince;
    }

    public static double getConsumerBalance() {
        return consumerBalance;
    }

    public void setConsumerBalance(double consumerBalance) {
        BankAccount.consumerBalance = consumerBalance;
    }

    public int getFinishedOperations() {
        return finishedOperations;
    }
}
