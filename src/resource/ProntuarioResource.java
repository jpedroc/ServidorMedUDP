package resource;

import domain.Prontuario;
import service.ProntuarioService;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ProntuarioResource {

    private final ProntuarioService prontuarioService = new ProntuarioService();

    public void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9999);

        byte[] dadosRec = new byte[1024];
        byte[] dadosEnvio = new  byte[1024];

        DatagramPacket receberPack = new DatagramPacket(dadosRec, dadosRec.length);
        serverSocket.receive(receberPack);

        this.prontuarioService.tratarProntuario(receberPack.getData());

    }
}
