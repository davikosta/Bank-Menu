package br.com.davikosta.bank;

public class BankAccount {
    private String consumerName;
    private String accountType;
    private int consumerSince;
    private double consumerBalance;
    private int finishedOperations;

    public void deposit(double amountToDeposit) {
        consumerBalance += amountToDeposit;
        registerNewOperation();
    }

    public void registerNewOperation() {
        finishedOperations++;
    }

    public void draw(double amountToDraw) {
        if (amountToDraw > 0 && amountToDraw <=consumerBalance) {
            consumerBalance -= amountToDraw;
            registerNewOperation();
        } else {
            String invalidAmountErrorMessage = "Por favor insira um valor válido!";
            System.out.println(invalidAmountErrorMessage);
        }
    }

    //Getters
    public int getFinishedOperations() {
        return finishedOperations;
    }

    public double getConsumerBalance() {
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
