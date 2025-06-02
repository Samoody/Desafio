/**
 * Nome: Samuel Kleber Vieira
 * RA: 12123150
 * Data: 02/06/2025
 * 
 * Programa para gerenciamento dos valores da conta de luz de uma empresa de energia fotovoltaica.
 * Armazena nome, código, consumo médio em kWh e calcula o valor médio em R$ de 20 clientes.
 */

import java.util.Scanner;

public class ContaLuz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Vetores para armazenar dados dos clientes
        String[] nomes = new String[20];
        int[] codigos = new int[20];
        double[] consumoMedio = new double[20]; // em kWh
        double[] valorMedio = new double[20];   // em R$

        // Leitura da tarifa do kWh
        System.out.print("Informe o valor da tarifa por kWh (em R$): ");
        double tarifa = sc.nextDouble();
        sc.nextLine(); // Limpar buffer

        // Cadastro dos clientes
        for (int i = 0; i < 20; i++) {
            System.out.println("\nCadastro do cliente " + (i + 1) + ":");
            
            System.out.print("Informe o nome do cliente: ");
            nomes[i] = sc.nextLine();

            System.out.print("Informe o código do cliente (número inteiro): ");
            codigos[i] = sc.nextInt();

            System.out.print("Informe o consumo médio dos últimos 12 meses (em kWh): ");
            consumoMedio[i] = sc.nextDouble();
            sc.nextLine(); // Limpar buffer

            // Calcula o valor médio em reais
            valorMedio[i] = consumoMedio[i] * tarifa;
        }

        // Menu de opções
        int opcao;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Consultar por nome");
            System.out.println("2 - Consultar por código");
            System.out.println("3 - Exibir tabela completa");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente para consulta: ");
                    String nomeConsulta = sc.nextLine();
                    boolean encontradoNome = false;
                    for (int i = 0; i < 20; i++) {
                        if (nomes[i].equalsIgnoreCase(nomeConsulta)) {
                            System.out.println("\nCliente encontrado:");
                            System.out.println("Nome: " + nomes[i]);
                            System.out.println("Código: " + codigos[i]);
                            System.out.println("Consumo médio (kWh): " + consumoMedio[i]);
                            System.out.println("Valor médio (R$): " + String.format("%.2f", valorMedio[i]));
                            encontradoNome = true;
                        }
                    }
                    if (!encontradoNome) {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 2:
                    System.out.print("Digite o código do cliente para consulta: ");
                    int codigoConsulta = sc.nextInt();
                    boolean encontradoCodigo = false;
                    for (int i = 0; i < 20; i++) {
                        if (codigos[i] == codigoConsulta) {
                            System.out.println("\nCliente encontrado:");
                            System.out.println("Nome: " + nomes[i]);
                            System.out.println("Código: " + codigos[i]);
                            System.out.println("Consumo médio (kWh): " + consumoMedio[i]);
                            System.out.println("Valor médio (R$): " + String.format("%.2f", valorMedio[i]));
                            encontradoCodigo = true;
                        }
                    }
                    if (!encontradoCodigo) {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("\n===== TABELA COMPLETA DOS CLIENTES =====");
                    System.out.printf("%-20s %-10s %-20s %-20s%n", "Nome", "Código", "Consumo Médio (kWh)", "Valor Médio (R$)");
                    for (int i = 0; i < 20; i++) {
                        System.out.printf("%-20s %-10d %-20.2f %-20.2f%n", nomes[i], codigos[i], consumoMedio[i], valorMedio[i]);
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        sc.close();
    }
}
