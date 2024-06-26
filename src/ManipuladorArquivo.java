import java.io.*;

public class ManipuladorArquivo implements PersistenciaDados {
    private static final String NOME_ARQUIVO = "dados.txt";

    @Override
    public void salvar(String dados) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
            writer.write(dados);
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados no arquivo: " + e.getMessage());
        }
    }

    @Override
    public String carregar() {
        StringBuilder dados = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                dados.append(linha).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar dados do arquivo: " + e.getMessage());
        }
        return dados.toString();
    }
}
