package Animal;

public class Animal {
    private String nome;
    private int idade;
    private int id;

    private static int idIncremental = 1;

    public Animal(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.id = idIncremental++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void emitirSom(){
        System.out.println("Emitindo som...");
    }

    @Override
    public String toString(){
        return "Nome: " + nome + "|Idadade: " + idade;
    }


}
