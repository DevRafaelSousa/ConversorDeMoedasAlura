package br.com.conversor;

import br.com.conversor.modelo.RespostaConversao;
import br.com.conversor.servico.ConversaoAPI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversorMoedas {

    private static final String MOEDAS_REQUERIDAS = "USD, BRL, ARS, BOB, CLP, COP";

    private static final String MENU = """
            
            ************************************************
            Bem-vindo ao Conversor de Moedas
            (Moedas Suportadas: %s)
            ************************************************
            
            Escolha uma das conversões rápidas:
            1) Dólar Americano (USD) -> Real Brasileiro (BRL)
            2) Real Brasileiro (BRL) -> Dólar Americano (USD)
            3) Peso Argentino (ARS) -> Real Brasileiro (BRL)
            4) Real Brasileiro (BRL) -> Peso Chileno (CLP)
            5) Peso Colombiano (COP) -> Boliviano Boliviano (BOB)
            6) Conversão Personalizada
            7) Sair
            
            Escolha uma opção (1-7): 
            """.formatted(MOEDAS_REQUERIDAS);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversaoAPI api = new ConversaoAPI();
        int opcao = 0;

        while (opcao != 7) {
            try {
                System.out.println(MENU);
                System.out.print("Sua escolha: ");

                if (scanner.hasNextInt()) {
                    opcao = scanner.nextInt();
                    scanner.nextLine();

                    String moedaBase = "", moedaAlvo = "";

                    switch (opcao) {
                        case 1: moedaBase = "USD"; moedaAlvo = "BRL"; break;
                        case 2: moedaBase = "BRL"; moedaAlvo = "USD"; break;
                        case 3: moedaBase = "ARS"; moedaAlvo = "BRL"; break;
                        case 4: moedaBase = "BRL"; moedaAlvo = "CLP"; break;
                        case 5: moedaBase = "COP"; moedaAlvo = "BOB"; break;
                        case 6: // Opção Personalizada
                            System.out.println("\n-- Conversão Personalizada --");
                            System.out.print("Digite a moeda base (ex: USD): ");
                            moedaBase = scanner.nextLine().trim().toUpperCase();
                            System.out.print("Digite a moeda alvo (ex: ARS): ");
                            moedaAlvo = scanner.nextLine().trim().toUpperCase();
                            break;
                        case 7: // Sair
                            System.out.println("\nObrigado por usar o conversor. Encerrando...");
                            continue;
                        default:
                            System.err.println("Opção inválida. Tente novamente ou use a Conversão Personalizada (opção 6).");
                            continue;
                    }

                    if (!moedaBase.isEmpty()) {
                        System.out.print("Digite o valor a ser convertido: ");
                        double valor = scanner.nextDouble();
                        executarConversao(api, moedaBase, moedaAlvo, valor);
                    }

                } else {
                    String entrada = scanner.nextLine();
                    System.err.println("Entrada inválida. Por favor, digite um número de opção (1-7).");
                }

            } catch (InputMismatchException e) {
                System.err.println("\n❌ ERRO: Entrada inválida. Por favor, digite um número para o valor ou a opção.");
                scanner.nextLine();
            } catch (Exception e) {
                System.err.println("\nOcorreu um erro inesperado: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void executarConversao(ConversaoAPI api, String moedaBase, String moedaAlvo, double valor) {
        System.out.println("\nProcessando conversão de " + valor + " " + moedaBase + " para " + moedaAlvo + "...");

        RespostaConversao resultado = api.converter(moedaBase, moedaAlvo, valor);

        if (resultado != null) {
            System.out.println("\n✅ Conversão concluída:");
            System.out.printf("   > Valor Original: %.2f %s%n", valor, moedaBase);
            System.out.printf("   > Taxa de Câmbio: 1 %s = %.4f %s%n", moedaBase, resultado.getTaxaConversao(), moedaAlvo);
            System.out.printf("   > Resultado Final: %.2f %s%n", resultado.getResultadoConversao(), moedaAlvo);
            System.out.println("-------------------------------------------------");
        } else {
            System.err.println("\n❌ Não foi possível realizar a conversão. Verifique a chave da API e os códigos das moedas.");
        }
    }
}