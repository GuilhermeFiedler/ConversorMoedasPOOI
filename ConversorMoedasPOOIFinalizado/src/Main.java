import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConverterMoeda converter = new ConverterMoeda();

        System.out.println("Bem-vindo à Calculadora de Conversão de Moeda!");

        while (true) {
            try {
                System.out.println("Selecione a moeda de origem:");

                for (Moedas moedas : Moedas.values()) {
                    System.out.printf("- %s%n", moedas.name());
                }

                String fromCurrencyInput = scanner.nextLine().toUpperCase();
                Moedas fromMoedas = Moedas.valueOf(fromCurrencyInput);

                System.out.println("Digite o valor a ser convertido:");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Selecione a moeda de destino:");

                for (Moedas moedas : Moedas.values()) {
                    System.out.printf("- %s%n", moedas.name());
                }

                String toCurrencyInput = scanner.nextLine().toUpperCase();
                Moedas toMoedas = Moedas.valueOf(toCurrencyInput);

                double convertedAmount = converter.convert(amount, fromMoedas, toMoedas);
                System.out.printf("O valor de %.2f %s equivale a %.2f %s.%n", amount, fromMoedas.name(), convertedAmount, toMoedas.name());

                break;

            } catch (Exception e) {
                System.out.println("Erro, tente novamente.");
            }
        }

        scanner.close();
    }
}
