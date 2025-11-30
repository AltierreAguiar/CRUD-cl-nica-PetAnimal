package CachorroEGato;

import Animal.Animal;

public class Cachorro extends Animal{

    public Cachorro(String nome, int idade) {
        super(nome, idade);

    }

    @Override
    public void emitirSom(){
        super.emitirSom();
        System.out.println("Latindo... ");
        System.out.println("AU, AU, AU");
    }

    @Override
    public String toString(){
        return "Cachorro | " + super.toString();
    }
}