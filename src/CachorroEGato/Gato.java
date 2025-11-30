package CachorroEGato;

import Animal.Animal;

public class Gato extends Animal {

    public Gato(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void emitirSom() {
        super.emitirSom();
        System.out.println("Miando....");
        System.out.println("Miau, miau");
    }

    @Override
    public String toString(){

        return "Gato | " + super.toString();
    }
}
