package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Server {
    public static void main(String[] args) {
        try {
            int port = 8081;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started");

            while (true) {
                // Accept client connection
                final Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a Runnable task to handle the client
                Runnable clientHandler = new Runnable() {
                    @Override
                    public void run() {
                        try {
                          InputStream clientInput = clientSocket.getInputStream();
                          OutputStream clientOutput = clientSocket.getOutputStream();

                          // http to read html file 
                            BufferedReader reader = Files.newBufferedReader(Paths.get("src/main/resources/home.html"));
                            reader.readLine();

                            StringBuilder htmlContent = new StringBuilder();
                            String line;
                            while ((line = reader.readLine()) != null) {
                                htmlContent.append(line).append("\n");
                            }
                            String httpResponse = "HTTP/1.1 200 OK\r\n" +
                                                  "Content-Type: text/html\r\n" +
                                                  "Content-Length: " + htmlContent.length() + "\r\n" +
                                                  "\r\n" +
                                                  htmlContent.toString();
                            // send the http response
                            clientOutput.write(httpResponse.getBytes());
                            clientOutput.flush();
                            clientOutput.close();
                            
                        } catch (IOException e) {
                            System.out.println("Error handling client");
                        } 
                    }
                };

                // Start the thread
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("IO error" + e.getMessage());
        }
    }

}
