package Consulta;

import Animal.Animal;
import Veterinario.Veterinario; // Importar a nova classe

public class Consulta {
    private String tipoConsulta;
    private String dataConsulta;
    private Animal petAtendido;
    private Veterinario veterinario; // Usar a classe Veterinario
    private String nomeTutor; // Mantendo o nome do tutor por simplicidade

    // Construtor atualizado
    public Consulta(Animal pet, String tipoConsulta, String dataConsulta, Veterinario vet, String nomeTutor) {
        this.petAtendido = pet;
        this.tipoConsulta = tipoConsulta;
        this.dataConsulta = dataConsulta;
        this.veterinario = vet; // Novo atributo
        this.nomeTutor = nomeTutor;
    }

    // Getters/Setters para tipoConsulta, dataConsulta, petAtendido, nomeTutor

    // Novo Getter/Setter para Veterinario
    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    // Outros métodos (getters/setters para os atributos restantes...)
    // ...

    @Override
    public String toString(){
        // Incluindo o ID do Pet e o nome do Veterinário no toString
        return "Tipo de consulta: "  + tipoConsulta
                + " | Data da consulta: " +  dataConsulta
                + " | Pet (ID " + petAtendido.getId() + "): " + petAtendido.getNome()
                + " | Veterinário: " + veterinario.getNome()
                + " | Tutor: " + nomeTutor;
    }
}
