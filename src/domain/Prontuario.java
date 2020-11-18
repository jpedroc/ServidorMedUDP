package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Prontuario implements Serializable {

    private String doenca;
    private List<String> sintomas;

    public static Prontuario fromString(String messagem) {
        List<String> info = new ArrayList<>(Arrays.asList(messagem.split(" - ")));
        return new Prontuario(info.remove(0), info);
    }

    public Prontuario(String doenca, List<String> sintomas) {
        this.doenca = doenca;
        this.sintomas = sintomas;
    }

    public List<String> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<String> sintomas) {
        this.sintomas = sintomas;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    @Override
    public String toString() {
        return doenca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prontuario)) return false;
        Prontuario that = (Prontuario) o;
        return sintomas.equals(that.sintomas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sintomas);
    }
}
