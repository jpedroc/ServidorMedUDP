package domain;


import java.io.Serializable;
import java.util.ArrayList;

public class Prontuario extends Object implements Serializable {
    private String doença;
    private ArrayList sintomas;

    public Prontuario(ArrayList sintomas) {
        this.sintomas = sintomas;
    }

    public Prontuario( ArrayList sintomas, String doença) {
        this.sintomas = sintomas;
        this.doença = doença;
    }

    public Prontuario() {
        this.sintomas = new ArrayList();
    }

    public ArrayList getSintomas() {
        return sintomas;
    }

    public void setSintomas(ArrayList sintomas) {
        this.sintomas = sintomas;
    }

    public String getDoença() {
        return doença;
    }

    public void setDoença(String doença) {
        this.doença = doença;
    }

    @Override
    public String toString() {
        return doença;
    }
}
