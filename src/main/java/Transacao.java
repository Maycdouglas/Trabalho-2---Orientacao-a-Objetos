public class Transacao {

    private String dataTransacao;
    private int qtde;
    private Produto produto;

    public Transacao(String dataTransacao, Produto produto, int qtde){
        if (produto == null) {
            throw new IllegalArgumentException("Produto obrigatorio");
        }
        if (qtde < 0){
            throw new IllegalArgumentException("Quantidade nao negativa obrigatoria");
        }
        if (dataTransacao == null)
        {
            throw new IllegalArgumentException("Data de transacao obrigatoria");
        }
        this.dataTransacao = dataTransacao;
        this.produto = produto;
        this.qtde = qtde;
    }

    public Produto getProduto() {
        return produto;
    }
}
