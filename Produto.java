public class Produto extends ItemComercial {
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        super(nome);
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String descricaoDetalhada() {
        return "Produto: " + getNome() + " | Preço: R$" + preco + " | Quantidade: " + quantidade;
    }

    @Override
    public void atualizarInformacoes(String novasInformacoes) {
        // Implementação opcional para atualizar informações específicas do produto
    }
}
