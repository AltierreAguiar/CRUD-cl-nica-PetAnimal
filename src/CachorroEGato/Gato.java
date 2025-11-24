package CachorroEGato;

import Animal.Animal;

public class Gato extends Animal {
    // Removido: private String especie;

    public Gato(String nome, int idade) {
        super(nome, idade);
        // Removido: this.especie = especie;
    }

    // Removido: getters/setters para especie

    @Override
    public void emitirSom() {
        super.emitirSom();
        System.out.println("Miando....");
        System.out.println("Miau, miau");
    }

    @Override
    public String toString(){
        // Remove 'especie' do toString
        return "Gato | " + super.toString();
    }
}
