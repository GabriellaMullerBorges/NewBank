package newbank;
import java.util.*;

public class MenuBancario {

    public static void mostrarMenu() {
        System.out.println("\n======= MENU =======");
        System.out.println("1 - Criar cliente");
        System.out.println("2 - Criar conta");
        System.out.println("3 - Listar contas");
        System.out.println("4 - Depositar");
        System.out.println("5 - Sacar");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static Clientes criarCliente(Scanner scanner, List<Clientes> clientes) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        //Validação para não permitir que se cadastre CPFs duplicados;

        for(Clientes c : clientes){
            if(c.getCpf().equals(cpf)){
                System.out.println("Há um cliente já cadastrado com este CPF");
                return null;
            }
        }

        if (cpf.length() != 11 || cpf.matches("\\d+")){
            System.out.println("O CPF deve conter 11 números");
            return null;
        }

        System.out.println("=== Endereço ===");
        System.out.print("Rua: ");
        String rua = scanner.nextLine();
        System.out.print("Número: ");
        String numero = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();

        Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado);
        return new Clientes(nome, cpf, endereco);
    }

    public static Conta criarConta(Scanner scanner, List<Clientes> clientes, Banco banco) {
        System.out.print("CPF do cliente: ");
        String cpfBusca = scanner.nextLine();

        for (Clientes c : clientes) {
            if (c.getCpf().equals(cpfBusca)) {
                System.out.print("Número da nova conta: ");
                int numeroConta = Integer.parseInt(scanner.nextLine());

                //Verificação para ver se não está cadastrando uma conta que já foi cadastrada
                if(banco.buscarContaPorNumero(numeroConta) !=null){
                    System.out.println("Já há uma conta com ese número");
                }

                System.out.print("Tipo da conta (1 - Corrente, 2 - Poupança): ");
                int tipo = Integer.parseInt(scanner.nextLine());

                return (tipo == 1)
                        ? new ContaCorrente(numeroConta, c)
                        : new ContaPoupanca(numeroConta, c);
            }
        }

        System.out.println("Cliente não encontrado.");
        return null;
    }

    public static void fazerDeposito(Scanner scanner, Banco banco) {
        System.out.print("Número da conta: ");
        int numero = Integer.parseInt(scanner.nextLine());
        Conta conta = banco.buscarContaPorNumero(numero);
        if (conta != null) {
            System.out.print("Valor a depositar: ");
            double valor = Double.parseDouble(scanner.nextLine());

            if(valor<=0){
                System.out.println("O valor precisa ser maior que zero");
                return;
            }
            conta.depositar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public static void fazerSaque(Scanner scanner, Banco banco) {
        System.out.print("Número da conta: ");
        int numero = Integer.parseInt(scanner.nextLine());
        Conta conta = banco.buscarContaPorNumero(numero);
        if (conta != null) {
            System.out.print("Valor a sacar: ");
            double valor = Double.parseDouble(scanner.nextLine());

            if(valor<=0){
                System.out.println("O valor precisa ser maior que zero");
                return;
            }

            if(valor> conta.getSaldo()){
                System.out.println("Saldo insuficiente");
                return;
            }
            conta.sacar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public static void listarContas(Banco banco) {
        banco.listarContas();
    }
}
