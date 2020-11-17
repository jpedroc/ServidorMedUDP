package resource;

import domain.Prontuario;
import service.ProntuarioService;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ProntuarioResource {

    public static void main(String[] args) throws Exception {
        try {
            ProntuarioService prontuarioService = new ProntuarioService();
            DatagramSocket serverSocket = new DatagramSocket(5001);

            while(true) {
                byte[] dadosRec = new byte[1024];

                DatagramPacket receberPack = new DatagramPacket(dadosRec, dadosRec.length);
                serverSocket.receive(receberPack);

                String resposta = prontuarioService.tratarProntuario(new String(receberPack.getData()));

                DatagramPacket res = new DatagramPacket(resposta.getBytes(), resposta.getBytes().length, receberPack.getAddress(), receberPack.getPort());
                serverSocket.send(res);
            }
        }
        catch (SocketException se) {
            System.out.println("SERVIDOR - " + se.getMessage());
        }
        catch (IOException ioe) {
            System.out.println("SERVIDOR - "+ ioe.getMessage());
        }
        catch (Exception e) {
            System.out.println("ERROR - "+ e.getMessage());
        }
    }
}
