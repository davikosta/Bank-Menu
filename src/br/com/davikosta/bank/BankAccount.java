package br.com.davikosta.bank;
import br.com.davikosta.messages.Errors;
import br.com.davikosta.messages.NewBalance;
import java.util.LinkedList;
import java.util.List;

public class BankAccount {
    private String consumerName;
    private String accountType;
    private int consumerSince;
    private static double consumerBalance;
    private int finishedOperations;
    private final List<Double> transactionHistory = new LinkedList<>();

    public void deposit(double amountToDeposit) {
        consumerBalance += amountToDeposit;
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
        if (amountToDraw > 0 && amountToDraw <= consumerBalance) {
            consumerBalance -= amountToDraw;
            registerNewOperation();
            incrementHistory(-amountToDraw);
            NewBalance.message();
        } else {
            Errors.invalidAmountErrorMessage();
        }
    }

    public BankAccount (String consumerName, String accountType, int consumerSince, double consumerBalance) {
        this.setConsumerName(consumerName);
        this.setAccountType(accountType);
        this.setConsumerSince(consumerSince);
        this.setConsumerBalance(consumerBalance);
    }

    public String getConsumerName() {
        return consumerName;
    }

    private void setConsumerName(String consumerName) {
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

    private void setConsumerSince(int consumerSince) {
        this.consumerSince = consumerSince;
    }

    public static double getConsumerBalance() {
        return consumerBalance;
    }

    private void setConsumerBalance(double consumerBalance) {
        BankAccount.consumerBalance = consumerBalance;
    }

    public int getFinishedOperations() {
        return finishedOperations;
    }
}
