package newbank;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contas; //polimorfismo para armazenar qualquer tipo de conta;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
        System.out.println("Conta adicionada com sucesso");
    }

    public void listarContas() {
        System.out.println(nome + " possui as seguintes contas: ");
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }

    public Conta buscarContaPorNumero(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null; // caso não encontre a conta;
    }

    public String getNome(){
        return nome;
    };
}
