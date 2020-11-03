package domain;


import java.io.Serializable;

public class Prontuario implements Serializable {
    private String nomePaciente;
    private String[] sintomas;
    private String doença;

    public Prontuario(String nomePaciente, String[] sintomas) {
        this.nomePaciente = nomePaciente;
        this.sintomas = sintomas;
    }

    public Prontuario(String nomePaciente, String[] sintomas, String doença) {
        this.nomePaciente = nomePaciente;
        this.sintomas = sintomas;
        this.doença = doença;
    }

    public Prontuario() {
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String[] getSintomas() {
        return sintomas;
    }

    public void setSintomas(String[] sintomas) {
        this.sintomas = sintomas;
    }

    public String getDoença() {
        return doença;
    }

    public void setDoença(String doença) {
        this.doença = doença;
    }
}
