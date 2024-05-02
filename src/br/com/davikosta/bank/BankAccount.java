package br.com.davikosta.bank;

public class BankAccount {
    private String consumerName;
    private String accountType;
    private int consumerSince;
    private double consumerBalance;
    private int finishedOperations;

    public void deposit(double amountToDeposit) {
        this.consumerBalance += amountToDeposit;
        registerNewOperation();
    }

    public void registerNewOperation() {
        finishedOperations++;
    }

    public void draw(double amountToDraw) {
        if (amountToDraw > 0 && amountToDraw <=this.consumerBalance) {
            this.consumerBalance -= amountToDraw;
            registerNewOperation();
        } else {
            String invalidAmountErrorMessage = "Por favor insira um valor válido!";
            System.out.println(invalidAmountErrorMessage);
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
