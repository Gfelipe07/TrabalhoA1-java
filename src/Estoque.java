import java.util.ArrayList;

public class Estoque {

    private GerenciamentoEstoque gerenciamentoEstoque;

    public Estoque() {
        this.gerenciamentoEstoque = new GerenciamentoEstoque();
    }

    public void adicionarProduto(Produto produto) {
        gerenciamentoEstoque.adicionarProduto(produto);
    }

    public boolean removerProduto(int id) {
        return gerenciamentoEstoque.removerProduto(id);
    }

    public void listarProdutos() {
        gerenciamentoEstoque.listarProdutos();
    }

    public Produto obterProduto(int id) {
        return gerenciamentoEstoque.obterProduto(id);
    }

    public boolean verificarDisponibilidadeProduto(int id) {
        return gerenciamentoEstoque.verificarDisponibilidadeProduto(id);
    }

    public ArrayList<Produto> getListaDeProdutos() {
        return gerenciamentoEstoque.getListaDeProdutos();
    }

    public void setListaDeProdutos(ArrayList<Produto> listaDeProdutos) {
        gerenciamentoEstoque.setListaDeProdutos(listaDeProdutos);
    }
}
