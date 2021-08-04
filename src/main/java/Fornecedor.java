public class Fornecedor extends Pessoa{

    private String cnpj;

    public Fornecedor (String nome, String cnpj){
        super(nome);
        if (cnpj == null) {
            throw new IllegalArgumentException("CNPJ obrigatorio");
        }
        this.cnpj = cnpj;
    }

}
