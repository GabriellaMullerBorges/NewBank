package newbank;

public class Endereco {
    private final String rua;
    private final String numero;
    private final String bairro;
    private final String cidade;
    private final String estado;

    public Endereco (String rua, String numero, String bairro, String cidade, String estado){
        this.rua = rua; // aqui usamos para dizer que o atributo da classe ,identificdo pelo this, é o parâmetro recebido no construtor
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getRua(){
        return rua;
    }

    public String getNumero(){
        return numero;
    }

    public String getBairro(){
        return bairro;
    }

    public String getCidade(){
        return cidade;
    }

    public String getEstado(){
        return estado;
    }

    @Override
    public String toString(){
        return "Endereço à Rua " + getRua() + " Nº " + getNumero() + " no bairro " + getBairro() + " na cidade " + getCidade() + "/" + getEstado();
    }

}
