import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendaTest {

    //Testes venda
    @Test
    void deveRetornarClienteObrigatorio() {
        try {
            Produto produto = new Produto("Bala",20, 1, 10, 50);
            Venda venda = new Venda("04/08/2021",null,produto,1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Cliente obrigatorio", e.getMessage());
        }
    }

    //Testes vender
    @Test
    void deveRetornarExcecaoQuantidadeInvalida() {
        try {
            Produto produto = new Produto("Bala",20, 1, 10, 50);
            Cliente cliente = new Cliente("Maycon", "999999999");
            Venda venda = new Venda("04/08/2021",cliente,produto,21);
            venda.vender(produto,-1);
            fail();
        } catch(IllegalArgumentException e) {
            assertEquals("Quantidade nao negativa obrigatoria",e.getMessage());
        }
    }


    @Test
    void deveRetornarVenderFalse() {

        Produto produto = new Produto("Bala",20, 1, 10, 50);
        Cliente cliente = new Cliente("Maycon", "999999999");
        Venda venda = new Venda("04/08/2021",cliente,produto,21);

        assertFalse(venda.vender(produto,21));
    }

    @Test
    void deveRetornarVenderTrue() {
        Produto produto = new Produto("Bala",20, 1, 10, 50);
        Cliente cliente = new Cliente("Maycon", "999999999");
        Venda venda = new Venda("04/08/2021",cliente,produto,21);

        assertTrue(venda.vender(produto,20));
    }
}