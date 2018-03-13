package serverside;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Servico extends Thread {
    private Socket socket;

    public Servico(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("Criou os buffers");

            out.println(("Deseja fazer qual operação ? jogar ou dormir"));

            String resposta = in.readLine();
            //processa
            if (resposta.equals("jogar")) {
                out.println("Você escolheu jogar");
            } else if (resposta.equals("dormir")) {
                out.println("Você escolheu dormir");
            } else {
                out.println("Error 404");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}