package domain;


import java.io.Serializable;

public class Prontuario implements Serializable {
    private String[] sintomas;
    private String doença;

    public Prontuario(String[] sintomas) {
        this.sintomas = sintomas;
    }

    public Prontuario( String[] sintomas, String doença) {
        this.sintomas = sintomas;
        this.doença = doença;
    }

    public Prontuario() {
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
