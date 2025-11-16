package CachorroEGato;

import Animal.Animal;
//classe pai
public class Cachorro extends Animal{
    private String especie;

    public Cachorro(String nome, int idade, String especie) {
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
    public void emitirSom(){
        super.emitirSom();
        System.out.println("Latindo... ");
        System.out.println("AU, AU, AU");
    }
    @Override
    public String toString(){
        super.toString();
        return "|Especie: " + especie;
    }
}
