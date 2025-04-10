package newbank;

public class ContaCorrente extends Conta{

    private static final double TAXA_SAQUE = 2.50;

    public ContaCorrente (int numero, Clientes cliente){//chama o construtor da classe mãe, que é Conta
        super(numero, cliente, TipoConta.CORRENTE); // O tipo da conta é corrente, ou seja, é fixo, e conhecido dentro da classe,e não deve ser informado por quem está criando o objeto
    }


    @Override
    public void sacar(double valor){ //usamos o override aqui porque a classe mãe, Conta, é abstrata com métodos abstratos inclusive
        double valorTotal =  valor + TAXA_SAQUE;
        if(valorTotal <= saldo){
            saldo -=valorTotal;
            System.out.println("Você está sacando R$" + valor + " e deverá pagar uma taxa de saque de R$" + TAXA_SAQUE +
                    ". Saque realizado com sucesso");
        }else{
            System.out.println("Saldo insuficiente para saque, devido à taxa de saque de R$" + TAXA_SAQUE);
        }
    }

    @Override
    public void depositar(double valor) { //usamos o override aqui porque a classe mãe, Conta, é abstrata com métodos abstratos inclusive
        if (valor > 0) {
            saldo += valor;
            System.out.println(" Depósito de R$" + valor + " realizado com sucesso." + "Seu saldo atual é de R$" + saldo);
        } else {
            System.out.println(" Deposite um valor válido");
        }
    }

    @Override
    public String toString(){
        return "Conta Corrente nº " + getNumero() + " pertence ao cliente " + getCliente().getNome() + " e possui atualmente o saldo de R$" + getSaldo();
    }
}
