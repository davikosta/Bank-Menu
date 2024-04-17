import java.util.Scanner;

public class App {
    //Consumer information
    static String consumerName = "João Pedro da Silva";
    static String accountType = "Conta corrente";
    static int consumerSince = 2021;
    static double consumerBalance = 2000;
    static int finishedOperations = 0;

    //Attributes to make the operations
    static Scanner scanner = new Scanner(System.in);
    static int userChoice = 0;
    static double amount = 0;

    //Messages
    static String errorMessage = "Operação inválida!";
    static String invalidAmountErrorMessage = "Por favor insira um valor válido!";


    public static void main(String[] args) {
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
                """,consumerName, consumerSince, accountType, consumerBalance, finishedOperations);
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
                System.out.println("O saldo atual é de " + consumerBalance);
                break;
            case 2:
                System.out.println("Quanto deseja depositar na sua conta?");
                amount = scanner.nextDouble();
                consumerBalance += amount;
                System.out.println(newBalanceMessage());
                finishedOperations++;
                break;
            case 3:
                System.out.println("Quanto deseja sacar da sua conta?");
                amount = scanner.nextDouble();
                if (amount > 0 && amount <= consumerBalance) {
                    consumerBalance-= amount;
                    System.out.println(newBalanceMessage());
                    finishedOperations++;
                } else {
                    System.out.println(invalidAmountErrorMessage);
                }
                break;
            case 4:
                System.out.println(showConsumerData());
                break;
            default:
                if (userChoice != 5) {
                    System.out.println(errorMessage);
                }
                break;
        }
    }
    private static String newBalanceMessage() {
        return String.format("O seu novo saldo é de R$ %.2f",consumerBalance);
    }

}
