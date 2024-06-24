public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(int id, String nome, String descricao, double preco, int quantidadeEmEstoque) {

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

}
