import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompraTest {

    //Testes compra
    @Test
    void deveRetornarExcecaoFornecedorObrigatorio() {
        try {
            Produto produto = new Produto("Bala",20, 1, 10, 50);
            Compra compra = new Compra("04/08/2021", produto, null,1, 1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Fornecedor obrigatorio", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoValorInvalido() {
        try {
            Produto produto = new Produto("Bala",20, 1, 10, 50);
            Fornecedor fornecedor = new Fornecedor("Maycon","999999999");
            Compra compra = new Compra("04/08/2021", produto, fornecedor,1, -1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Valor nao negativo obrigatorio", e.getMessage());
        }
    }

    //Testes comprar
    @Test
    void deveRetornarExcecaoQuantidadeInvalida() {
        try {
            Produto produto = new Produto("Bala",20, 1, 10, 50);
            Fornecedor fornecedor = new Fornecedor("Maycon","999999999");
            Compra compra = new Compra("04/08/2021", produto, fornecedor,1, 1);

            compra.comprar(produto, -1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade nao negativa obrigatoria", e.getMessage());
        }
    }

    @Test
    void deveRetornarComprarFalse() {
        Produto produto = new Produto("Bala",20, 1, 10, 50);
        Fornecedor fornecedor = new Fornecedor("Maycon","999999999");
        Compra compra = new Compra("04/08/2021", produto, fornecedor,31, 1);

        assertFalse(compra.comprar(produto,31));
    }

    @Test
    void deveRetornarComprarTrue() {
        Produto produto = new Produto("Bala",20, 1, 10, 50);
        Fornecedor fornecedor = new Fornecedor("Maycon","999999999");
        Compra compra = new Compra("04/08/2021", produto, fornecedor,30, 1);

        assertTrue(compra.comprar(produto,30));
    }
}