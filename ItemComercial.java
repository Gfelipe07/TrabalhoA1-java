public abstract class ItemComercial {
    private String nome;

    public ItemComercial(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Métodos abstratos a serem implementados pelas subclasses
    public abstract String descricaoDetalhada();
    public abstract void atualizarInformacoes(String novasInformacoes);
}
