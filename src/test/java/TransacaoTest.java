import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransacaoTest {

    @Test
    void deveRetornarExcecaoProdutoObrigatorio() {
        try{
            Transacao transacao = new Transacao("04/08/2021",null,1);
        } catch (IllegalArgumentException e) {
            assertEquals("Produto obrigatorio", e.getMessage());
        }

    }

    @Test
    void deveRetornarExcecaoQuantidadeInvalida() {
        try{
            Produto produto = new Produto("Bala",20, 1, 10, 50);
            Transacao transacao = new Transacao("04/08/2021",produto,-1);
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade nao negativa obrigatoria", e.getMessage());
        }

    }

    @Test
    void deveRetornarExcecaoDataTransacaoObrigatoria() {
        try{
            Produto produto = new Produto("Bala",20, 1, 10, 50);
            Transacao transacao = new Transacao(null,produto,1);
        } catch (IllegalArgumentException e) {
            assertEquals("Data de transacao obrigatoria", e.getMessage());
        }

    }
}
