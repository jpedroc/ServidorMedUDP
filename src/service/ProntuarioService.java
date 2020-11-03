package service;

import domain.Prontuario;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ProntuarioService {


    public Prontuario tratarProntuario(byte[] mensagem) {
        try {
            Prontuario prontuario = new Prontuario();
            ByteArrayInputStream bao = new ByteArrayInputStream(mensagem);
            ObjectInputStream ous;

            ous = new ObjectInputStream(bao);
            prontuario = (Prontuario) ous.readObject();

            return prontuario;

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
