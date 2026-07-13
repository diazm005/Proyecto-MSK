package com.dsw2.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@Component
public class SocketServerConfig implements CommandLineRunner {

    private static final int PUERTO = 5555;

    @Override
    public void run(String... args) {
        
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
                System.out.println("[Socket] Servidor escuchando en puerto " + PUERTO);
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("[Socket] Cliente conectado: " + clientSocket.getInetAddress());
                    new Thread(() -> handleClient(clientSocket)).start();
                }
            } catch (IOException e) {
                System.err.println(">>> [Socket] Error: " + e.getMessage());
            }
        }).start();
    }

    private void handleClient(Socket clientSocket) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))
        ) {
            String mensaje;
            while ((mensaje = in.readLine()) != null) {
                System.out.println("[Socket] Mensaje recibido: " + mensaje);
                out.write("Servidor recibió: " + mensaje + "\n");
                out.flush();
            }
        } catch (IOException e) {
            System.err.println("[Socket] Cliente desconectado");
        }
    }
}