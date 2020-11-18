package domain;

import java.util.ArrayList;
import java.util.List;

public class RegraForte {

    private String nome;
    private List<String> sintomas = new ArrayList<>();
    private Long frequencia = (long) 0;
    private Long confiabilidade = (long) 0;

    public static RegraForte fromProntuario(Prontuario prontuario) {
        return new RegraForte(prontuario.getDoenca(), prontuario.getSintomas());
    }

    public RegraForte(String nome, List<String> sintomas) {
        this.nome = nome;
        this.sintomas = sintomas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<String> sintomas) {
        this.sintomas = sintomas;
    }

    public Long getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Long frequencia) {
        this.frequencia = frequencia;
    }

    public Long getConfiabilidade() {
        return confiabilidade;
    }

    public void setConfiabilidade(Long confiabilidade) {
        this.confiabilidade = confiabilidade;
    }
}
