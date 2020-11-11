package service;

import domain.Prontuario;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class ProntuarioService {

    private ArrayList<Prontuario> listaProntuarios = new ArrayList<Prontuario>();

    public String tratarProntuario(String mensagem) {
        try {
            Prontuario prontuario = stringToProntuario(mensagem);

            this.listaProntuarios.add(prontuario);

            return verificarSintomas(prontuario);

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private Prontuario stringToProntuario(String message) {
        Prontuario prontuario = new Prontuario();
        ArrayList<String> info = new ArrayList(Arrays.asList(message.split(" - ")));
        prontuario.setDoença(info.remove(0));
        for(String atr: info) {
            if(atr != null) {
                prontuario.getSintomas().add(atr);
            }
        }
        return prontuario;
    }

    private String verificarSintomas(Prontuario prontuario) {
        if(!prontuario.getDoença().isEmpty()) {
            return prontuario.getDoença();
        }
        return algoritmoAprioriImpl(prontuario.getSintomas());
    }

    private String algoritmoAprioriImpl(ArrayList sintomas) {
        return "";
    }

}
