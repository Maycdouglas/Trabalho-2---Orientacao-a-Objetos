import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Produto {

    private String nome;
    private int qntdEstoque;
    private Integer precoUnit;
    private int estoqueMinimo;
    private int estoqueMaximo;
    private List<String> historico;

    public Produto(String nome, int qntdEstoque, Integer precoUnit, int estoqueMinimo, int estoqueMaximo)
    {
        if(nome == null){
            throw new IllegalArgumentException("Nome obrigatorio");
        }
        if(qntdEstoque < 0 || estoqueMinimo < 0 || estoqueMaximo < 0) {
            throw new IllegalArgumentException("Quantidade nao negativa obrigatoria");
        }
        if(precoUnit < 0){
            throw new IllegalArgumentException("Valor nao negativo obrigatorio");
        }

        this.nome = nome;
        this.qntdEstoque = qntdEstoque;
        this.precoUnit = precoUnit;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
        this.historico = new ArrayList<String>();
    }

    public int getQntdEstoque() {
        return qntdEstoque;
    }

    public List<String> getHistorico() {
        return historico;
    }

    public void registrarHistorico(String transacao){
        if (transacao == null) {
            throw new NullPointerException("Transacao obrigatoria");
        }
        this.historico.add(transacao);
    }

    public String exibirHistorico(){
        String historico = String.join("\n", this.historico);
        return historico;
    }

    public void debitarEstoque(int quantidade){
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade nao negativa obrigatoria");
        }
        this.qntdEstoque = this.qntdEstoque - quantidade;
    }

    public void creditarEstoque(int quantidade){
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade nao negativa obrigatoria");
        }
        this.qntdEstoque = this.qntdEstoque + quantidade;
    }

    public boolean verificarEstoqueBaixo(){
        if(this.qntdEstoque < this.estoqueMinimo){
            return true;
        }
        return false;
    }

    public boolean verificarEstoqueInsuficiente(int quantidade){
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade nao negativa obrigatoria");
        }
        if(this.qntdEstoque < quantidade){
            return true;
        }
        return false;
    }

    public boolean verificarEstoqueExcedente(int quantidade){
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade nao negativa obrigatoria");
        }
        if(this.qntdEstoque + quantidade > this.estoqueMaximo){
            return true;
        }
        return false;
    }

    public Integer calcularValorVenda(int quantidade){
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade nao negativa obrigatoria");
        }
        return this.precoUnit * quantidade;
    }

    public boolean vender(String dataVenda, Cliente cliente, int qntdVendida){

        Venda venda = new Venda(dataVenda,cliente, this, qntdVendida);

        if(venda.vender(this,qntdVendida)){
            this.registrarHistorico("Venda do produto " + this.nome);
            return true;
        }
        return false;

    }

    public boolean comprar(String dataCompra, Fornecedor fornecedor, int qtdeCompra, Integer precoUnit){

        Compra compra = new Compra(dataCompra,this,fornecedor,qtdeCompra,precoUnit);
        if(compra.comprar(this,qtdeCompra)){
            this.registrarHistorico("Compra do produto " + this.nome);
            return true;
        }
        return false;
    }

}
