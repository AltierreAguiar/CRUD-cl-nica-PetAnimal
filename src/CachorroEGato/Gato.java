package CachorroEGato;

import Animal.Animal;

public class Gato extends Animal {
    private String especie;

    public Gato(String nome, int idade, String especie) {
        super(nome, idade);
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Override
    public void emitirSom() {
        super.emitirSom();
        System.out.println("Miando....");
        System.out.println("Miau, miau");
    }
    @Override
    public String toString(){
        return super.toString() +  "|Especie: " + especie;
    }
}
