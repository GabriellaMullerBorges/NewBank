package newbank;

public class ContaPoupanca extends Conta{ //herança

    private static final int LIMITE_SAQUES = 3;
    private int saquesRealizados = 0;

    public ContaPoupanca(int numero, Clientes cliente){
        super(numero, cliente); //chama o construtor da classe mãe, que é Conta
    }
    @Override
    public void sacar(double valor){ //usamos o override aqui porque a classe mãe, Conta, é abstrata com métodos abstratos inclusive
        if(saquesRealizados >= LIMITE_SAQUES){
            System.out.println("Limite de 3 saques atingido");
            return;
        }
        if (valor <= saldo){
            saldo-= valor;
            saquesRealizados++;
        System.out.println(" Saque de R$" + valor + " realizado com sucesso. Você já realizou " + saquesRealizados + " saques.");
        }else{
            System.out.println(" Saldo de" + saldo + " é insuficiente para saque.");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println(" Depósito de  R$" + valor + " realizado com sucesso");
        } else {
            System.out.println("Valor inválido");
        }
    }


    @Override
    public String toString(){
        return "Conta de nº " + getNumero() +
                " pertecente ao cliente " + getCliente().getNome() +
                " possui atualmente o saldo de R$" + getSaldo() +
                " e teve " + saquesRealizados + " saques realizados";
    }
}

