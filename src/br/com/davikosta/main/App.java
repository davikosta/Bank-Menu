package br.com.davikosta.main;

import br.com.davikosta.bank.BankAccount;
import br.com.davikosta.menus.CustomerSummary;
import br.com.davikosta.menus.OperationsMenu;
import br.com.davikosta.messages.Errors;

import java.util.Scanner;

public class App {
    static CustomerSummary customerSummary = new CustomerSummary();
    static OperationsMenu operationsMenu = new OperationsMenu();
    //Consumer information
    static BankAccount bankAccount1 = new BankAccount("João Pedro da Silva", "Conta corrente", 2021, 0);
    //Attributes to make the operations
    static Scanner scanner = new Scanner(System.in);
    static int userChoice = 0;
    static double amount = 0;

    public static void main(String[] args) {

        customerSummary.showCustomerData(bankAccount1);

        while (userChoice != 6) {

            operationsMenu.showMenu();

            userChoice = scanner.nextInt();

            doOperations(userChoice);
        }
    }



    private static void doOperations(int userChoice) {
        switch (userChoice) {
            case 1:
                System.out.println("O saldo atual é de " + BankAccount.getCustomerBalance());
                break;
            case 2:
                System.out.println("Quanto deseja depositar na sua conta?");
                amount = scanner.nextDouble();
                bankAccount1.deposit(amount);
                break;
            case 3:
                System.out.println("Quanto deseja sacar da sua conta?");
                amount = scanner.nextDouble();
                bankAccount1.draw(amount);
                break;
            case 4:
                customerSummary.showCustomerData(bankAccount1);
                break;
            case 5:
                bankAccount1.printHistory();
                break;
            default:
                if (userChoice != 6) {
                    Errors.errorMessage();
                }
                break;
        }
    }

}
