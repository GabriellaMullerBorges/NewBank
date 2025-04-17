package newbank;

public interface OperacoesBancarias { //maior desacoplamento
    void sacar (double valor);
    void depositar (double valor);
    void verSaldo();
    // nas novas verões de java é possível declarar um metodo como default, que dai torna ele nao obrigatorio
}
