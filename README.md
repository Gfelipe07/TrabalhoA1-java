Informação Gerais:

    - Projeto universitário de gerenciamento de estoque
    - Objetivo: Gerenciar produtos, fornecedores e vendas
    
Classes e Relações:

    - Console: Leitura de dados do console
    - Estoque: Gerencia produtos e fornecedores
    - Fornecedor: Nome e produtos fornecidos
    - ItemComercial: Classe base para itens comerciais
    - ManipuladorArquivo: Manipulação de arquivos (implementa PersistenciaDados)
    - PersistenciaDados: Interface para salvar e carregar dados
    - Produto: Nome, preço e quantidade
    - Venda: Processa vendas de produtos

Relações:

    - Associação: Estoque com Produto e Fornecedor
    - Agregação: Fornecedor com Produto
    - Composição: ManipuladorArquivo com PersistenciaDados

Como usar:

    Início: Execute o sistema e siga as instruções no console
        Menu Principal:
        1. Adicionar Produto: Insira os detalhes do produto (nome, preço, quantidade)
        2. Remover Produto: Informe o nome do produto a ser removido
        3. Listar Produtos: Exibe todos os produtos cadastrados
        4. Buscar Produto: Procure um produto pelo nome
        5. Adicionar Fornecedor: Insira os detalhes do fornecedor
        6. Listar Fornecedores: Exibe todos os fornecedores cadastrados
        7. Processar Venda: Informe o nome do produto e a quantidade a ser vendida


Uso do ChatGPT:
    
    - Auxílio na elaboração da estrutura do READ.ME
    - Auxílio em partes do código
    - Elaboração da ideia do projeto

Referências:

    - Códigos feitos em sala de aula

    
