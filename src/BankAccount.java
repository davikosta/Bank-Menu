public class BankAccount {
    private String consumerName;
    private String accountType;
    private int consumerSince;
    private double consumerBalance;
    private int finishedOperations = 0;

    public void draw(double amountToDeposit) {
        this.consumerBalance -= amountToDeposit;
    }

    public void registerNewOperation() {
        this.finishedOperations++;
    }

    public void deposit(double amountToDeposit) {
        this.consumerBalance += amountToDeposit;
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
