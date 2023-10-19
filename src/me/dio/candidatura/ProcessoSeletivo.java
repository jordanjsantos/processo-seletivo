package me.dio.candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    public static void main(String[] args) {
        System.out.println("Processo seletivo");

        analisarCandidato(1400.0);
        analisarCandidato(2200.0);
        analisarCandidato(2000.0);

        System.out.println("\n-- Seleção de candidatos --");
        selecionarCandidatos();

        System.out.println("\n-- Imprimir Selecionados --");
        imprimirSelecionados();

        String[] candidatos = {"Maria", "João", "Ana", "Pedro", "Clara", "Lucas", "Isabella", "Bruno", "Carolina", "Gustavo"};
        for (String candidato : candidatos) {
            entrarEmContato(candidato);
        }
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato.");
        } else if(salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contraproposta.");
        } else {
            System.out.println("Aguardando demais candidatos.");
        }
    }

    static void selecionarCandidatos() {
        String[] candidatos = {"Maria", "João", "Ana", "Pedro", "Clara", "Lucas", "Isabella", "Bruno", "Carolina", "Gustavo"};
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("Candidato: " + candidato + " - valor: " + salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                System.out.println(candidato + " selecionado para a vaga!");
                candidatosSelecionados++;
            }

            candidatosAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1500, 2500);
    }

    static void imprimirSelecionados() {
        String[] candidatos = {"Maria", "João", "Ana", "Pedro", "Clara", "Lucas", "Isabella", "Bruno", "Carolina", "Gustavo"};
        System.out.println("Imprimindo a lista de candidatos de acordo com o índice");

        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("O candidato de número " + (i + 1) + " é " + candidatos[i]);
        }
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void entrarEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuaTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuaTentando = !atendeu;

            if (continuaTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("Contato realizado com sucesso!");
            }
        } while (continuaTentando && tentativasRealizadas < 3);

        if (atendeu) {
            System.out.println("Conseguimos o contato com " + candidato + " com " + tentativasRealizadas + " tentativas!");
        } else {
            System.out.println("NÃO conseguimos o contato com " + candidato + " com " + tentativasRealizadas + " tentativas!");
        }
    }

}
