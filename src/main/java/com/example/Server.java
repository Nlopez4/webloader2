package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            int port = 8080;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started");

            while (true) {
                // Accept client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a Runnable task to handle the client
                Runnable clientHandler = new Runnable() {
                    @Override
                    public void run() {
                        // try () {
                          
                        //     // Craft the HTTP response
                            

                            

                        // } catch (IOException e) {
                        //     System.out.println("Error handling client");
                        // } finally {
                            
                        // }
                    }
                };

                // Start the thread
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("IO error");
        }
    }

}
