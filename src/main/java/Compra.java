public class Compra extends Transacao{

    private Integer precoUnit;
    private Fornecedor fornecedor;

    public Compra(String dataCompra, Produto produto, Fornecedor fornecedor, int qtdeCompra, Integer precoUnit){
        super(dataCompra,produto,qtdeCompra);
        if(fornecedor == null){
            throw new IllegalArgumentException("Fornecedor obrigatorio");
        }
        this.fornecedor = fornecedor;
        if(precoUnit < 0){
            throw new IllegalArgumentException("Valor nao negativo obrigatorio");
        }
        this.precoUnit = precoUnit;
    }

    public boolean comprar(Produto produto, int qtdeCompra){
        if (qtdeCompra < 0) {
            throw new IllegalArgumentException("Quantidade nao negativa obrigatoria");
        }

        if(produto.verificarEstoqueExcedente(qtdeCompra)) {
            produto.registrarHistorico("Quantidade desejada excede o estoque");
            return false;
        }

        produto.creditarEstoque(qtdeCompra);
        return true;
    }

}
