package br.com.davikosta.bank;
import br.com.davikosta.messages.Errors;
import br.com.davikosta.messages.NewBalance;

public class BankAccount {
    private String consumerName;
    private String accountType;
    private int consumerSince;
    private static double consumerBalance;
    private int finishedOperations;

    public void deposit(double amountToDeposit) {
        consumerBalance += amountToDeposit;
        registerNewOperation();
        NewBalance.message();
    }

    public void registerNewOperation() {
        finishedOperations++;
    }

    public void draw(double amountToDraw) {
        if (amountToDraw > 0 && amountToDraw <=consumerBalance) {
            consumerBalance -= amountToDraw;
            registerNewOperation();
            NewBalance.message();
        } else {
            Errors.invalidAmountErrorMessage();
        }
    }

    //Getters
    public int getFinishedOperations() {
        return finishedOperations;
    }

    public static double getConsumerBalance() {
        return consumerBalance;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public int getConsumerSince() {
        return consumerSince;
    }

    public String getAccountType() {
        return accountType;
    }


    //Setters
    public void setConsumerBalance(double consumerBalance) {
        this.consumerBalance = consumerBalance;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setConsumerSince(int consumerSince) {
        this.consumerSince = consumerSince;
    }
}
