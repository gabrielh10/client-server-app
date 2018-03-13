package clientside;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente extends Thread{

    public void run(){
        try {
            Socket socket = new Socket("localhost", 9999);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("Criou os buffers cliente");
            Scanner scan = new Scanner(System.in);

            System.out.println("Instanciou scanner");
            String options = in.readLine();
            System.out.println("aqui");
            System.out.println(options);

            //digito  a opcao escolhida
            out.println(scan.nextLine());

            //recebo o resultado de acordo com opção
            String resultado = in.readLine();
            System.out.println(resultado);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main (String[] args){
       Thread tCliente = new Cliente();
       tCliente.start();

    }
}
