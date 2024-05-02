package br.com.davikosta.messages;

import br.com.davikosta.bank.BankAccount;

public class NewBalance {
    public static void message() {
        System.out.printf("O seu novo saldo é de R$ %.2f%n", BankAccount.getConsumerBalance());
    }
}
