package service;

import domain.Prontuario;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ProntuarioService {

    private ArrayList<Prontuario> listaProntuarios = new ArrayList<Prontuario>();

    public String tratarProntuario(byte[] mensagem) {
        try {
            Prontuario prontuario = new Prontuario();
            ByteArrayInputStream bao = new ByteArrayInputStream(mensagem);
            ObjectInputStream ous;

            ous = new ObjectInputStream(bao);
            prontuario = (Prontuario) ous.readObject();
            this.listaProntuarios.add(prontuario);

            return verificarSintomas(prontuario);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String verificarSintomas(Prontuario prontuario) {
        if(prontuario.getDoença() != null) {
            return prontuario.getDoença();
        }
        return algoritmoAprioriImpl(prontuario.getSintomas());
    }

    private String algoritmoAprioriImpl(String[] sintomas) {
        return "";
    }

}
