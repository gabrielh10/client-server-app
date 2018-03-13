package serverside;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread {
    private ServerSocket serverSock;

    public Servidor (int porta) throws IOException {
         serverSock = new ServerSocket(porta);
         Thread tServer = new Thread(this);
         tServer.start();
         System.out.println("Server aberto na porta: "+porta);
    }
    public void run(){
        try {
            while(true){
                Socket servicoSock = serverSock.accept();
                Thread tServico = new Servico(servicoSock);
                tServico.start();
                System.out.println("Abriu thread do servico");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        try {
            new Servidor (9999);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
