import newbank.Banco;
import newbank.Clientes;
import newbank.Conta;
import newbank.MenuBancario;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco("New Bank");
        List<Clientes> clientes = new ArrayList<>(); //cria uma lista para armazenar os cluentes criados (antes estava chumbado)

        int opcao;

        do {
            MenuBancario.mostrarMenu();
            try {
                opcao = Integer.parseInt(scanner.nextLine()); //converte para inteiro

                switch (opcao) {
                    case 1 -> clientes.add(MenuBancario.criarCliente(scanner, clientes));
                    case 2 -> {
                        Conta conta = MenuBancario.criarConta(scanner, clientes, banco); //cria uma conta com base em um cliente existente por meio do cpf
                        if (conta != null) banco.adicionarConta(conta);
                    }
                    case 3 -> MenuBancario.listarContas(banco);
                    case 4 -> MenuBancario.fazerDeposito(scanner, banco);
                    case 5 -> MenuBancario.fazerSaque(scanner, banco);
                    case 0 -> System.out.println("Encerrando o sistema...");
                    default -> System.out.println("Opção inválida");
                }

            } catch (NumberFormatException e) { // só pode digitar número
                System.out.println("Entrada inválida.");
                opcao = -1; // pra continuar no loop
            }
        } while (opcao != 0);

        scanner.close();
    }
}
