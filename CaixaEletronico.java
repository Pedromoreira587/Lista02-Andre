
import java.util.Scanner;

public class CaixaEletronico {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double saldo = 0.0;
        char opcao;
        double saque;

        do {

            System.out.println("===========================================");
            System.out.println("      BEM VINDO OS BANCO MÃO DE VACA      ");
            System.out.println("===========================================");
            System.out.println("Digite a tecla correspondente a operação que deseja realizar");
            System.out.println("(a) consulta saldo");
            System.out.println("(b) saque");
            System.out.println("(c) depósito");
            System.out.println("(d) sair ");
            opcao = scanner.next().toLowerCase().charAt(0);

            switch (opcao) {
                case 'a' ->
                    System.out.printf("Seu saldo é: R$ %.2f\n", saldo);
                case 'b' -> {
                    System.out.print("Informe o valor para saque: R$ ");
                    saque = scanner.nextDouble();
                    if (saque > saldo) {
                        System.out.println("Saldo insuficiente.");
                    } else {
                        saldo -= saque;
                        System.out.printf("Saque realizado. Novo saldo: R$ %.2f\n", saldo);
                    }
                }
                case 'c' -> {
                    System.out.print("Informe o valor para depósito: R$ ");
                    double deposito = scanner.nextDouble();
                    if (deposito <= 0) {
                        System.out.println("Valor inválido.");
                    } else {
                        saldo += deposito;
                        System.out.printf("Depósito realizado. Novo saldo: R$ %.2f\n", saldo);
                    }
                }
                case 'd' ->
                    System.out.println("programa finalizado!");
                default ->
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 'd');

        scanner.close();
    }
}
