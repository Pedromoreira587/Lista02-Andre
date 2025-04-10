
import java.util.Scanner;

public class Senha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int senha = 3573;

        System.out.println("ola bem vindo ao andre.java");

        while (true) {
            System.out.println("DIgite sua senha");
            int senhadig = scanner.nextInt();
            if (senhadig == senha) {
                System.out.println(" Senha Correta! vamos comecar");
                break;

            } else {
                System.out.println("senha incorreta digite novamente!");
            }
        }

    }

}
