import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private PersistenciaDados persistencia;
    private List<Produto> produtos;
    private List<Fornecedor> fornecedores;

    public Estoque(PersistenciaDados persistencia) {
        this.persistencia = persistencia;
        this.produtos = new ArrayList<>();
        this.fornecedores = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public List<Produto> listarProdutos() {
        return new ArrayList<>(produtos);
    }

    public Produto buscarProdutoPorNome(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }

    public void adicionarFornecedor(Fornecedor fornecedor) {
        fornecedores.add(fornecedor);
    }

    public void removerFornecedor(Fornecedor fornecedor) {
        fornecedores.remove(fornecedor);
    }

    public List<Fornecedor> listarFornecedores() {
        return new ArrayList<>(fornecedores);
    }

    public Fornecedor buscarFornecedorPorNome(String nome) {
        for (Fornecedor fornecedor : fornecedores) {
            if (fornecedor.getNome().equalsIgnoreCase(nome)) {
                return fornecedor;
            }
        }
        return null;
    }

    public void carregarDados() {
        String dados = persistencia.carregar();
        if (!dados.isEmpty()) {
            String[] linhas = dados.split("\n");
            for (String linha : linhas) {
                String[] partes = linha.split(",");
                if (partes.length > 0) {
                    if (partes.length == 3) { // Produto: nome,preco,quantidade
                        String nomeProduto = partes[0];
                        double precoProduto = Double.parseDouble(partes[1]);
                        int quantidadeProduto = Integer.parseInt(partes[2]);
                        Produto produto = new Produto(nomeProduto, precoProduto, quantidadeProduto);
                        produtos.add(produto);
                    } else if (partes.length == 2) { // Fornecedor: nome,contato
                        String nomeFornecedor = partes[0];
                        String contatoFornecedor = partes[1];
                        Fornecedor fornecedor = new Fornecedor(nomeFornecedor, contatoFornecedor);
                        fornecedores.add(fornecedor);
                    }
                }
            }
        }
    }

    public void salvarDados() {
        StringBuilder dadosParaSalvar = new StringBuilder();

        for (Produto produto : produtos) {
            dadosParaSalvar.append(produto.getNome()).append(",").append(produto.getPreco()).append(",").append(produto.getQuantidade()).append("\n");
        }

        for (Fornecedor fornecedor : fornecedores) {
            dadosParaSalvar.append(fornecedor.getNome()).append(",").append(fornecedor.getContato()).append("\n");
        }

        persistencia.salvar(dadosParaSalvar.toString());
    }

    public void limparEstoque() {
        produtos.clear();
        fornecedores.clear();
    }
}
