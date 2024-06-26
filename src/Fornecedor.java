public class Fornecedor extends ItemComercial {
    private String contato;

    public Fornecedor(String nome, String contato) {
        super(nome);
        this.contato = contato;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public String descricaoDetalhada() {
        return "Fornecedor: " + getNome() + " | Contato: " + contato;
    }

    @Override
    public void atualizarInformacoes(String novasInformacoes) {
        // Implementação opcional para atualizar informações específicas do fornecedor
    }
}
