package Consulta;

import Animal.Animal;

public class Consulta {
    private String tipoConsulta;
    private String dataConsulta;
    private Animal petAtendido;
    private String nomeVeterinario;
    private String nomeTutor;

    public Consulta(Animal pet, String tipoConsulta, String dataConsulta, String nomeVeterinario, String nomeTutor) {
        this.petAtendido = pet;
        this.tipoConsulta = tipoConsulta;
        this.dataConsulta = dataConsulta;
        this.nomeVeterinario = nomeVeterinario;
        this.nomeTutor = nomeTutor;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Animal getPetAtendido() {
        return petAtendido;
    }

    public void setPetAtendido(Animal petAtendido) {
        this.petAtendido = petAtendido;
    }

    public String getNomeVeterinario() {
        return nomeVeterinario;
    }

    public void setNomeVeterinario(String nomeVeterinario) {
        this.nomeVeterinario = nomeVeterinario;
    }

    public String getNomeTutor() {
        return nomeTutor;
    }

    public void setNomeTutor(String nomeTutor) {
        this.nomeTutor = nomeTutor;
    }

    @Override
    public String toString(){
        return super.toString() + "| Tipo de consulta: "  + tipoConsulta
                + "| Data da consulta: " +  dataConsulta;
    }
}
