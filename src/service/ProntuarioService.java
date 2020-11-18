package service;

import domain.Prontuario;

import java.util.ArrayList;

public class ProntuarioService {

    private final ArrayList<Prontuario> prontuarios = new ArrayList<>();

    public String tratarProntuario(String mensagem) {

        try {
            Prontuario prontuario = Prontuario.fromString(mensagem);
            this.prontuarios.add(prontuario);

            return verificarSintomas(prontuario);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private String verificarSintomas(Prontuario prontuario) {
        if (!prontuario.getDoenca().isEmpty()) {
            return prontuario.getDoenca();
        }
        return Apriori.getDoenca(prontuarios, prontuario);
    }

}
