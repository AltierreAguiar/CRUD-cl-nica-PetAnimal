package CachorroEGato;

import Animal.Animal;

public class Cachorro extends Animal{
    // Removido: private String especie;

    public Cachorro(String nome, int idade) {
        super(nome, idade);
        // Removido: this.especie = especie;
    }

    // Removido: getters/setters para especie

    @Override
    public void emitirSom(){
        super.emitirSom();
        System.out.println("Latindo... ");
        System.out.println("AU, AU, AU");
    }

    @Override
    public String toString(){
        // Remove 'especie' do toString
        return "Cachorro | " + super.toString();
    }
}