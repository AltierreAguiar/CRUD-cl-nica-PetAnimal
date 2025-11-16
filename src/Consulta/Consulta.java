package Consulta;

import Animal.Animal;

public class Consulta extends Animal {
    private String tipoConsulta;
    private String dataConsulta;

    public Consulta(String nome, int idade, String tipoConsulta, String dataConsulta) {
        super(nome, idade);
        this.tipoConsulta = tipoConsulta;
        this.dataConsulta = dataConsulta;
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


}
