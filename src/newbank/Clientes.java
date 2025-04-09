package newbank;

public class Clientes {
    
    //private para que os atributos só sejam acessados dentro da prórpia classe
    private String nome;
    private String cpf; 
    private String logradouro;
    
    
    //usando o Constructor Clientes para construi r um novo objeto do tipo Clientes, pois recebe os parâmetros e inicializa os atributos
    public Clientes (String nome, String cpf, String logradouro){
        this.nome = nome; // aqui usamos para dizer que o atributo da classe ,identificdo pelo this, é o parâmetro recebido no construtor
        this.cpf = cpf;
        this.logradouro = logradouro;
    }
    
    public String getNome(){
        return nome;
    } //permite acessa o atributo nome fora dessa classe aqui
    
    public void setNome(String nome){
        this.nome = nome;
    } //permite modificar o nome, mas passando por um cotrole

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf= cpf;
    }

    public String getLogradouro(){
        return logradouro;
    }

    public void setLogradouro(String logradouro){
        this.logradouro = logradouro;
    }

    @Override
    public String toString(){
        return "Cliente{" + nome + " de cpf " + cpf + " localizado na rua " + logradouro;
    } //toString é um metodo da classe Object que todas classe Java herda, com o override estaremos sobrescrevendo esse metodo de uma forma personalizada
}