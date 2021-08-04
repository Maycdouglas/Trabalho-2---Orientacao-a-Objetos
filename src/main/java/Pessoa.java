public class Pessoa {

    protected String nome;

    public Pessoa(String nome){
        if (nome == null) {
            throw new IllegalArgumentException("Nome obrigatorio");
        }
        this.nome = nome;
    }
}
