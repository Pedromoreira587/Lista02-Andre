import java.util.Scanner;

public class NumeroPrimo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=============================================");
        System.out.println("| BEM VINDO AO VERIFICADOR DE NUMEROS PRIMOS |");
        System.out.println("=============================================");
        System.out.print("Digite o numero que deseja verificar: ");
        int numero = scanner.nextInt();

        boolean numprimo = true; 

        if (numero <= 1) {
            numprimo = false; 
        } else {
            for (int i = 2; i < numero; i++) {
                if (numero % i == 0) {
                    numprimo = false; 
                }
            }
        }

        if (numprimo) {
            System.out.println("====================================");
            System.out.println(numero + " o numero digitado é primo.");
            System.out.println("====================================");
        } else {
            System.out.println("======================================");
            System.out.println(numero + "o numero digitado não é primo.");
            System.out.println("======================================");
        }

        scanner.close(); 
    }
}