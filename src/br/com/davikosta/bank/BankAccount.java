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
        this.consumerBalance += amountToDeposit;
        registerNewOperation();
        NewBalance.message();
    }

    public void registerNewOperation() {
        finishedOperations++;
    }

    public void draw(double amountToDraw) {
        if (amountToDraw > 0 && amountToDraw <=this.consumerBalance) {
            this.consumerBalance -= amountToDraw;
            registerNewOperation();
            NewBalance.message();
        } else {
            Errors.invalidAmountErrorMessage();
        }
    }

<<<<<<< HEAD
=======
    //Getters
    public int getFinishedOperations() {
        return finishedOperations;
    }

    public static double getConsumerBalance() {
        return consumerBalance;
    }

>>>>>>> 74dc1693aadb00883bd8e2d9bfb09eaef1fa322b
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

    public double getConsumerBalance() {
        return consumerBalance;
    }

    public void setConsumerBalance(double consumerBalance) {
        this.consumerBalance = consumerBalance;
    }

    public int getFinishedOperations() {
        return finishedOperations;
    }
}
