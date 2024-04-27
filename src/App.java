import br.com.davikosta.bank.BankAccount;
import br.com.davikosta.messages.Errors;

import java.util.Scanner;

public class App {
    //Consumer information
    static BankAccount bankAccount1 = new BankAccount();
    //Attributes to make the operations
    static Scanner scanner = new Scanner(System.in);
    static int userChoice = 0;
    static double amount = 0;

    public static void main(String[] args) {
        bankAccount1.setConsumerName("João Pedro da Silva");
        bankAccount1.setAccountType("Conta corrente");
        bankAccount1.setConsumerSince(2021);
        bankAccount1.setConsumerBalance(2000);

        App app = new App();

        System.out.println(showConsumerData());

        while (userChoice != 5) {

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
                
                5 - Encerrar programa.
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
            default:
                if (userChoice != 5) {
                    Errors.errorMessage();
                }
                break;
        }
    }

}
