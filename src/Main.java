import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersistenciaDados persistencia = new ManipuladorArquivo();
        Estoque estoque = new Estoque(persistencia);

        // Carregar dados do arquivo, se existir
        estoque.carregarDados();

        boolean running = true;

        while (running) {
            System.out.println("\n--- Menu de Gerenciamento de Estoque ---\n");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Remover Produto");
            System.out.println("3. Listar Produtos");
            System.out.println("4. Adicionar Fornecedor");
            System.out.println("5. Remover Fornecedor");
            System.out.println("6. Listar Fornecedores");
            System.out.println("7. Realizar Venda");
            System.out.println("8. Limpar Estoque");
            System.out.println("9. Salvar e Sair");

            int opcao = Console.lerInt("\nEscolha uma opção: ");

            switch (opcao) {
                case 1:
                    String nomeProduto = Console.lerString("Informe o nome do Produto: ");
                    double precoProduto = Console.lerDouble("Informe o preço do Produto: ");
                    int quantidadeProduto = Console.lerInt("Informe a quantidade do Produto: ");
                    Produto produto = new Produto(nomeProduto, precoProduto, quantidadeProduto);
                    estoque.adicionarProduto(produto);
                    System.out.println("\nProduto adicionado com sucesso.");
                    break;
                case 2:
                    nomeProduto = Console.lerString("Informe o nome do Produto a ser removido: ");
                    Produto produtoParaRemover = estoque.buscarProdutoPorNome(nomeProduto);

                    if (produtoParaRemover != null) {
                        estoque.removerProduto(produtoParaRemover);
                        System.out.println("Produto removido com sucesso.");
                    } else {
                        System.out.println("Produto não encontrado no estoque.");
                    }
                    break;
                case 3:
                    System.out.println("\n--- Produtos no Estoque ---\n");
                    List<Produto> produtos = estoque.listarProdutos();
                    if (produtos.isEmpty()) {
                        System.out.println("\nNenhum produto cadastrado.");
                    } else {
                        for (Produto p : produtos) {
                            System.out.println(p.descricaoDetalhada());
                        }
                    }
                    break;
                case 4:
                    String nomeFornecedor = Console.lerString("Informe o nome do Fornecedor: ");
                    String contatoFornecedor = Console.lerString("Informe o contato do Fornecedor: ");
                    Fornecedor fornecedor = new Fornecedor(nomeFornecedor, contatoFornecedor);
                    estoque.adicionarFornecedor(fornecedor);
                    System.out.println("\nFornecedor adicionado com sucesso.");
                    break;
                case 5:
                    nomeFornecedor = Console.lerString("Informe o nome do Fornecedor a ser removido: ");
                    Fornecedor fornecedorParaRemover = estoque.buscarFornecedorPorNome(nomeFornecedor);

                    if (fornecedorParaRemover != null) {
                        estoque.removerFornecedor(fornecedorParaRemover);
                        System.out.println("\nFornecedor removido com sucesso.");
                    } else {
                        System.out.println("\nFornecedor não encontrado.");
                    }
                    break;
                case 6:
                    System.out.println("\n--- Fornecedores ---");
                    List<Fornecedor> fornecedores = estoque.listarFornecedores();
                    if (fornecedores.isEmpty()) {
                        System.out.println("\nNenhum fornecedor cadastrado.");
                    } else {
                        for (Fornecedor f : fornecedores) {
                            System.out.println(f.descricaoDetalhada());
                        }
                    }
                    break;
                case 7:
                    if (estoque.listarProdutos().isEmpty()) {
                        System.out.println("\nNão há produtos disponíveis para venda.");
                        break;
                    }

                    System.out.println("\n--- Realizar Venda ---");
                    System.out.println("\nProdutos Disponíveis:");

                    List<Produto> produtosDisponiveis = estoque.listarProdutos();
                    for (int i = 0; i < produtosDisponiveis.size(); i++) {
                        System.out.printf("%d. %s%n", i + 1, produtosDisponiveis.get(i).getNome());
                    }

                    int opcaoProduto = Console.lerInt("\nEscolha o produto a ser vendido (ou 0 para cancelar): ");
                    if (opcaoProduto < 1 || opcaoProduto > produtosDisponiveis.size()) {
                        System.out.println("\nOpção inválida ou cancelada.");
                        break;
                    }

                    Produto produtoVenda = produtosDisponiveis.get(opcaoProduto - 1);
                    int quantidadeVenda = Console.lerInt("\nInforme a quantidade a ser vendida: ");

                    if (quantidadeVenda <= 0 || quantidadeVenda > produtoVenda.getQuantidade()) {
                        System.out.println("\nQuantidade inválida ou superior ao estoque disponível.");
                        break;
                    }

                    // Realiza a venda
                    Venda venda = new Venda();
                    venda.processarVenda(produtoVenda, quantidadeVenda);
                    produtoVenda.setQuantidade(produtoVenda.getQuantidade() - quantidadeVenda);
                    System.out.println("\nVenda realizada com sucesso.");
                    break;
                case 8:
                    estoque.limparEstoque();
                    System.out.println("\nEstoque limpo com sucesso.");
                    break;
                case 9:
                    // Salva os dados e finaliza o programa
                    estoque.salvarDados();
                    running = false;
                    System.out.println("\nSistema encerrado.");
                    break;
                default:
                    System.out.println("\nOpção inválida.");
                    break;
            }
        }
    }
}
