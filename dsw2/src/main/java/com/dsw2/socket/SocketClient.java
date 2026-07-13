package com.dsw2.socket;

import java.io.*;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 12345;

        try (
            Socket socket = new Socket(host, puerto);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            java.util.Scanner scanner = new java.util.Scanner(System.in)
        ) {
            System.out.println("Conectado al servidor " + host + ":" + puerto);

            while (true) {
                System.out.print("Escribe un mensaje (o 'exit'): ");
                String msg = scanner.nextLine();
                if ("exit".equalsIgnoreCase(msg)) break;

                out.write(msg + "\n");
                out.flush();

                String respuesta = in.readLine();
                System.out.println("Respuesta: " + respuesta);
            }
        } catch (IOException e) {
            System.err.println("Error de conexion: " + e.getMessage());
        }
    }
}