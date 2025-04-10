import java.util.Scanner;

public class Urna02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int votos;
        boolean votacaoAtiva = true;

        int candidato1 = 0;
        int candidato2 = 0;
        int candidato3 = 0;
        int brancos = 0;
        int nulos = 0;
        int totalVotos = 0;

        while (votacaoAtiva) {
            System.out.println("===========================================");
            System.out.println("     BEM VINDO AS ELEICOES UNA2055      ");
            System.out.println("===========================================");
            System.out.println("As opções de candidatos são:");
            System.out.println("1. Candidato Jair Rodrigues ");
            System.out.println("2. Candidato Carlos Luz");
            System.out.println("3. Candidato Neves Rocha");
            System.out.println("4. Nulo ");
            System.out.println("5. Branco");
            System.out.println("6. Resultado");
            System.out.print("Digite seu voto: ");
            votos = scanner.nextInt();

            totalVotos++; // Incrementa o total de votos

            switch (votos) {
                case 1 -> candidato1++;
                case 2 -> candidato2++;
                case 3 -> candidato3++;
                case 4 -> nulos++;
                case 5 -> brancos++;
                case 6 -> {
                    // Passa totalVotos
                    votacaoAtiva = false; exibirResultados(candidato1, candidato2, candidato3, nulos, brancos, totalVotos);
                }
                default -> {
                    System.out.println("Voto inválido.");
                    totalVotos--; // Decrementa se o voto for inválido
                }
            }
            if (votacaoAtiva && votos != 6) {
                System.out.print("novo voto? (s/n): ");
                String resp = scanner.next();
                if (resp.equalsIgnoreCase("n")) {
                    votacaoAtiva = false;
                }
            }
        }
        scanner.close();
    }

    public static void exibirResultados(int candidato1, int candidato2, int candidato3, int nulos, int brancos, int totalVotos) {
        int maisvotado = 0;
        String vencedor = "";

        if (candidato1 > candidato2 && candidato1 > candidato3) {
            maisvotado = candidato1;
            vencedor = "Jair Rodrigues";
        } else if (candidato2 > candidato1 && candidato2 > candidato3) {
            maisvotado = candidato2;
            vencedor = "Carlos Luz";
        } else if (candidato3 > candidato1 && candidato3 > candidato2) {
            maisvotado = candidato3;
            vencedor = "Neves Rocha";
        } else if (candidato1 == candidato2 && candidato1 > candidato3) {
            vencedor = "Jair Rodrigues e Carlos Luz (Empate)";
        } else if (candidato1 == candidato3 && candidato1 > candidato2) {
            vencedor = "Jair Rodrigues e Neves Rocha (Empate)";
        } else if (candidato2 == candidato3 && candidato2 > candidato1) {
            vencedor = "Carlos Luz e Neves Rocha (Empate)";
        } else if (candidato1 == candidato2 && candidato1 == candidato3) {
            vencedor = "Jair Rodrigues, Carlos Luz e Neves Rocha (Empate)";
        }

        System.out.println("===========================================");
        System.out.println(" O total de votos de cada candidato e:");
        System.out.println("===========================================");
        System.out.println("1. Candidato Jair Rodrigues: " + candidato1);
        System.out.println("2. Candidato Carlos Luz: " + candidato2);
        System.out.println("3. Candidato Neves Rocha: " + candidato3);
        System.out.println("Nulo: " + nulos + " (" + calcularPorcentagem(nulos, totalVotos) + "%)");
        System.out.println("Branco: " + brancos + " (" + calcularPorcentagem(brancos, totalVotos) + "%)");

        if (!vencedor.isEmpty()) {
            System.out.println("Vencedor(es): " + vencedor);
            System.out.println("Total de votos do(s) vencedor(es): " + maisvotado);
        }
    }

    public static double calcularPorcentagem(int votos, int totalVotos) {
        if (totalVotos == 0) {
            return 0.0;
        }
        return (double) votos / totalVotos * 100.0;
    }
}