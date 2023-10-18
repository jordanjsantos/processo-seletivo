package me.dio.candidatura.contador;

import java.util.Scanner;

public class Contador {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro parâmetro: ");
        int parametroUm = sc.nextInt();
        System.out.print("Digite o segundo parâmetro: ");
        int parametroDois = sc.nextInt();

        try {
            contar(parametroUm, parametroDois);
        } catch (ParametrosInvalidosException exception) {
            System.out.println("O segundo parâmetro deve ser maior que o primeiro!");
        }
    }
    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        // Valida se parametroUm é maior que parametroDois, caso verdadeiro, lança a exceção
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException();
        }

        int contador = parametroDois - parametroUm;
        // Realiza o for para imprimir os números com base na variável contador
        for (int i = 0; i < contador; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }

}
