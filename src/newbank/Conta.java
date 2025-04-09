package newbank;

public abstract class Conta { //classe abstrata, não pode ser instanciada diretamente, erve apenas como molde e facilita a hernaça
    private int numero;
    protected double saldo; //acesso para as classes filhas
    private Clientes cliente;

    public Conta(int numero, Clientes cliente){
        this.numero = numero;
        this.cliente = cliente; //composição tem-um pois a conta tem um cliente
        this.saldo= 0.0;
    }

    //Métodos abstratos para que as classes filhas implementem
    public abstract void sacar(double valor);
    public abstract void depositar(double valor);

    public void verSaldo(){
        System.out.println("O saldo atual da conta nº " + numero + " é de R$" + saldo);
    }

    public int getNumero(){
        return numero;
    }

    public Clientes getCliente(){
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString(){
        return "Conta de nº " + numero + " pertecente ali cliente " + cliente + " possui atualmente o saldo de R$" + saldo;
    }
}
