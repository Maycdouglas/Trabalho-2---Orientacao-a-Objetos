import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorTest {

    //Teste CNPJ Obrigatório
    @Test
    void deveRetornarExcecaoCNPJObrigatorio() {
        try {
            Fornecedor fornecedor = new Fornecedor("Maycon", null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("CNPJ obrigatorio", e.getMessage());
        }
    }
}