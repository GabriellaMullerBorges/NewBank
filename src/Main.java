import newbank.*;

public class Main {
    public static void main(String[] args) {
        Clientes clienteTeste = new Clientes("Gabi", "1321321231321", "Irmão Norbert Francisco"); //teste do override
        System.out.println(clienteTeste);
        System.out.println("Nome do cliente é " + clienteTeste.getNome());
        System.out.println("O cpf do cliente é " + clienteTeste.getCpf());
        System.out.println("O endereço do cliente é " + clienteTeste.getLogradouro());


        Clientes clienteDoisTeste = new Clientes("Mateus", "00000000003", "Jardim Getsâmani");
        Conta contaCorrente = new ContaCorrente(2, clienteDoisTeste);
        System.out.println("**********************************************************************");
        System.out.println("Nome do cliente é " + clienteDoisTeste.getNome());
        System.out.println("O cpf do cliente é " + clienteDoisTeste.getCpf());
        System.out.println("O endereço do cliente é " + clienteDoisTeste.getLogradouro());

        System.out.print(contaCorrente);

        contaCorrente.depositar(100.00);
        contaCorrente.sacar(50.00);
        contaCorrente.verSaldo();


        Clientes cliente3Teste = new Clientes("Pedro", "00000000002", "Jardim Getsâmani");
        Conta contaPoupanca = new ContaPoupanca(3, cliente3Teste);
        System.out.println("**********************************************************************");
        System.out.println("Nome do cliente é " + cliente3Teste.getNome());
        System.out.println(" A conta é " + contaPoupanca);

        contaPoupanca.depositar(200.00);
        contaPoupanca.sacar(50.00);
        contaPoupanca.sacar(50.00);
        contaPoupanca.sacar(80.00);  /// Modificar a regra depois para não permitir que a conta fique negativa
        contaPoupanca.sacar(50.00);
        System.out.println(" A conta é " + contaPoupanca);


        System.out.println("**********************************************************************");

        Conta conta4 = new ContaCorrente(4, cliente3Teste);
        Conta conta5 = new ContaPoupanca(5, clienteDoisTeste);
        Conta conta6 = new ContaCorrente(6, cliente3Teste);

        Banco banco = new Banco("NewBank");

        banco.adicionarConta(conta4);
        banco.adicionarConta(conta5);
        banco.adicionarConta(conta6);

        banco.listarContas();


        Conta encontrada = banco.buscarContaPorNumero(6);
        if(encontrada != null){
            encontrada.depositar(10.0);
            encontrada.verSaldo();
        } else {
            System.out.println("Conta não encontrada");
        }

        banco.listarContas();
    }
}