import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class ProdutoTest {

    //Testes Produto
    @Test
    void deveRetornarExcecaoNomeObrigatorio() {
        try {
            Produto produto = new Produto(null,20, 1, 10, 50);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome obrigatorio", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoQuantidadeEstoqueInvalida() {
        try {
            Produto produto = new Produto("bala",-1, 1, 10, 50);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade nao negativa obrigatoria", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoQuantidadeEstoqueMinimoInvalida() {
        try {
            Produto produto = new Produto("bala",20, 1, -1, 50);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade nao negativa obrigatoria", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoQuantidadeEstoqueMaximoInvalida() {
        try {
            Produto produto = new Produto("bala",20, 1, 10, -1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade nao negativa obrigatoria", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoValorInvalido() {
        try {
            Produto produto = new Produto("bala",20, -1, 10, 50);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Valor nao negativo obrigatorio", e.getMessage());
        }
    }

    //Testes debitarEstoque
    @Test
    void deveRetornarEstoqueDebitado() {
        Produto produto = new Produto("Bala",20, 1, 10, 50);
        produto.debitarEstoque(10);

        assertEquals(10, produto.getQntdEstoque());
    }

    @Test
    void deveRetornarExcecaoQuantidadeDebitadaInvalida() {
        try {
            Produto produto = new Produto("bala",20, 1, 10, 50);
            produto.debitarEstoque(-1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade nao negativa obrigatoria", e.getMessage());
        }
    }

    //Testes creditarEstoque
    @Test
    void deveRetornarEstoqueCreditado() {
        Produto produto = new Produto("Bala",10, 1, 10, 50);
        produto.creditarEstoque(10);

        assertEquals(20, produto.getQntdEstoque());
    }

    @Test
    void deveRetornarExcecaoQuantidadeCreditadaInvalida() {
        try {
            Produto produto = new Produto("bala",20, 1, 10, 50);
            produto.creditarEstoque(-1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade nao negativa obrigatoria", e.getMessage());
        }
    }

    //Testes verificarEstoqueBaixo
    @Test
    void deveRetornarEstoqueBaixoTrue() {
        Produto produto = new Produto("Bala",9, 1, 10, 50);

        assertTrue(produto.verificarEstoqueBaixo());
    }

    @Test
    void deveRetornarEstoqueBaixoFalse() {
        Produto produto = new Produto("Bala",10, 1, 10, 50);

        assertFalse(produto.verificarEstoqueBaixo());
    }

    //Testes verificarEstoqueInsuficiente
    @Test
    void deveRetornarExcecaoQuantidadeEstoqueInsuficienteInvalida() {
        try {
            Produto produto = new Produto("bala",20, 1, 10, 50);
            produto.verificarEstoqueInsuficiente(-1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade nao negativa obrigatoria", e.getMessage());
        }
    }

    @Test
    void deveRetornarEstoqueInsuficienteTrue() {
        Produto produto = new Produto("Bala",10, 1, 10, 50);

        assertTrue(produto.verificarEstoqueInsuficiente(11));
    }

    @Test
    void deveRetornarEstoqueInsuficienteFalse() {
        Produto produto = new Produto("Bala",10, 1, 10, 50);

        assertFalse(produto.verificarEstoqueInsuficiente(10));
    }

    //Testes verificarEstoqueExcedente
    @Test
    void deveRetornarExcecaoQuantidadeEstoqueExcedenteInvalida() {
        try {
            Produto produto = new Produto("bala",20, 1, 10, 50);
            produto.verificarEstoqueExcedente(-1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade nao negativa obrigatoria", e.getMessage());
        }
    }
    @Test
    void deveRetornarEstoqueExcedenteTrue() {
        Produto produto = new Produto("Bala",10, 1, 10, 50);

        assertTrue(produto.verificarEstoqueExcedente(41));
    }

    @Test
    void deveRetornarEstoqueExcedenteFalse() {
        Produto produto = new Produto("Bala",10, 1, 10, 50);

        assertFalse(produto.verificarEstoqueExcedente(40));
    }

    //Testes calcularValorVenda
    @Test
    void deveRetornarExcecaoQuantidadeCalcularValorVendaInvalida() {
        try {
            Produto produto = new Produto("bala",20, 1, 10, 50);
            produto.calcularValorVenda(-1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade nao negativa obrigatoria", e.getMessage());
        }
    }

    @Test
    void deveRetornarValorVenda() {
        Produto produto = new Produto("Bala",10, 1, 10, 50);

        assertEquals(5,produto.calcularValorVenda(5));
    }

    //Testes vender
    @Test
    void deveRetornarVenderTrue() {
        Produto produto = new Produto("Bala",10, 1, 10, 50);
        Cliente cliente = new Cliente("Maycon", "999999999");

        assertTrue(produto.vender("04/08/2021",cliente,1));
    }

    @Test
    void deveRetornarVenderFalse() {
        Produto produto = new Produto("Bala",10, 1, 10, 50);
        Cliente cliente = new Cliente("Maycon", "999999999");

        assertFalse(produto.vender("04/08/2021",cliente,11));
    }

    //Testes comprar
    @Test
    void deveRetornarComprarTrue() {
        Produto produto = new Produto("Bala",10, 1, 10, 50);
        Fornecedor fornecedor = new Fornecedor("Maycon", "999999999");

        assertTrue(produto.comprar("04/08/2021",fornecedor,40,1));
    }

    @Test
    void deveRetornarComprarFalse() {
        Produto produto = new Produto("Bala",10, 1, 10, 50);
        Fornecedor fornecedor = new Fornecedor("Maycon", "999999999");

        assertFalse(produto.comprar("04/08/2021",fornecedor,41,1));
    }

    //Testes registrarHistorico
    @Test
    void deveRetornarExcecaoTransacaoObrigatoria(){
        try {
            Produto produto = new Produto("Bala",20, 1, 10, 50);
            produto.registrarHistorico(null);
            fail();
        } catch(NullPointerException e) {
            assertEquals("Transacao obrigatoria",e.getMessage());
        }
    }

    @Test
    void deveRetornarHistoricoComUmItem() {
        Produto produto = new Produto("Bala",20, 1, 10, 50);
        produto.registrarHistorico("Maycon");

        List lista = new ArrayList<String>();
        lista.add("Maycon");

        assertEquals(lista, produto.getHistorico());
    }

    @Test
    void deveRetornarHistoricoComVariosItens() {
        Produto produto = new Produto("Bala",20, 1, 10, 50);
        produto.registrarHistorico("Maycon");
        produto.registrarHistorico("Douglas");

        List lista = new ArrayList<String>();
        lista.add("Maycon");
        lista.add("Douglas");

        assertEquals(lista, produto.getHistorico());
    }

    //Testes exibirHistorico
    @Test
    void deveRetornarStringHistoricoSemItens() {
        Produto produto = new Produto("Bala",20, 1, 10, 50);

        assertEquals("", produto.exibirHistorico());
    }

    @Test
    void deveRetornarStringHistoricoComUmItem() {
        Produto produto = new Produto("Bala",20, 1, 10, 50);
        produto.registrarHistorico("Maycon");

        assertEquals("Maycon", produto.exibirHistorico());
    }

    @Test
    void deveRetornarStringHistoricoComVariosItens() {
        Produto produto = new Produto("Bala",20, 1, 10, 50);
        produto.registrarHistorico("Maycon");
        produto.registrarHistorico("Douglas");

        assertEquals("Maycon\nDouglas", produto.exibirHistorico());
    }

}