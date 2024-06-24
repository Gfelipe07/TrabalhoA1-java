import java.util.ArrayList;

public class GerenciamentoEstoque {
    private ArrayList<Produto> listaDeProdutos;

    public GerenciamentoEstoque() {
        this.listaDeProdutos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        this.listaDeProdutos.add(produto);
    }

    public boolean removerProduto(int id) {
        for (Produto produto : listaDeProdutos) {
            if (produto.getId() == id) {
                listaDeProdutos.remove(produto);
                return true;
            }
        }
        return false;
    }

    public void listarProdutos() {
        for (Produto produto : listaDeProdutos) {
            System.out.println(produto);
        }
    }

    public Produto obterProduto(int id) {
        for (Produto produto : listaDeProdutos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    public boolean verificarDisponibilidadeProduto(int id) {
        Produto produto = obterProduto(id);
        return produto != null && produto.verificarDisponibilidade();
    }

    public ArrayList<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public void setListaDeProdutos(ArrayList<Produto> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }
}
