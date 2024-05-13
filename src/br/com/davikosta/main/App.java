package br.com.davikosta.main;

import br.com.davikosta.bank.BankAccount;
import br.com.davikosta.messages.Errors;

import java.util.Scanner;

public class App {
    //Consumer information
    static BankAccount bankAccount1 = new BankAccount("João Pedro da Silva", "Conta corrente", 2021, 0);
    //Attributes to make the operations
    static Scanner scanner = new Scanner(System.in);
    static int userChoice = 0;
    static double amount = 0;

    public static void main(String[] args) {

        App app = new App();

        System.out.println(showConsumerData());

        while (userChoice != 6) {

            System.out.println(app.showMenu());

            userChoice = scanner.nextInt();

            doOperations(userChoice);
        }
    }

    private static String showConsumerData() {
        return String.format("""
                ---------------------------------------------------------------------
                Resumo:
                
                Nome completo:         %s
                
                Cliente desde:         %d
                
                Tipo de conta:         %s
                
                Saldo:                 %.2f
                
                Número de
                operações realizadas:  %d
                """,bankAccount1.getConsumerName(), bankAccount1.getConsumerSince(), bankAccount1.getAccountType(), BankAccount.getConsumerBalance(), bankAccount1.getFinishedOperations());
    }

    public String showMenu() {
        return """
                ---------------------------------------------------------------------
                Operações:
                
                1 - Consultar Saldo.
                
                2 - Depositar.
                
                3 - Sacar.
                
                4 - Exibir resumo.
                
                5 - Exibir histórico de operações.
                
                6 - Encerrar programa.
                """;
    }

    private static void doOperations(int userChoice) {
        switch (userChoice) {
            case 1:
                System.out.println("O saldo atual é de " + BankAccount.getConsumerBalance());
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
                System.out.println(showConsumerData());
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
