public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto() {
    }

    public Produto(int id, String nome, String descricao, double preco, int quantidadeEmEstoque) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void atualizarQuantidadeEmEstoque(int quantidade) {
        if (quantidade >= 0) {
            this.quantidadeEmEstoque = quantidade;
        } else {
            System.out.println("A quantidade em estoque não pode ser negativa.");
        }
    }

    public boolean verificarDisponibilidade() {
        return this.quantidadeEmEstoque > 0;
    }

    @Override
    public String toString() {
        return "Produto {" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", quantidadeEmEstoque=" + quantidadeEmEstoque +
                '}';
    }
}
