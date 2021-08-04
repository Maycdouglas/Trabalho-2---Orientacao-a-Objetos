import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    //Teste CPF Obrigatório
    @Test
    void deveRetornarExcecaoCPFObrigatorio() {
        try {
            Cliente cliente = new Cliente("Maycon", null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("CPF obrigatorio", e.getMessage());
        }
    }

}