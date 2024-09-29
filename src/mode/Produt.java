package mode;

//import utils.utili;


public class Produt {
//  Contador de produto
    private static int count = 1;

    // Atributos do produto
    private int id;
    private String nome;
    private Double preco;

    // Construtor dos atributos
    public Produt(String nome, Double preco) {
        this.id = count;
        this.nome = nome;
        this.preco = preco;

        //  Incrementação do produto
        Produt.count += 1; 
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String toString(){
        return "Id: " + this.getId() + "\rNome: " 
        + this.getNome() + "\rPreço: "
        /*+ utili.doubleToString(this.getPreco())*/; 
    }

}
