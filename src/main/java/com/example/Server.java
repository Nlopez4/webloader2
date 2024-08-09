package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;

public class Server {
    // GOAL: create my own server from scratch
    // 1. handle sockets
    // 2. need to catch IOException in case there is an Input/output error
    // 3. after accepting a request, create a thread or use a thread pool, how are you handling multiple clients? 
    public static void main(String[] args) {
        try {
            int port = 8080;
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for client");
            ss.accept();
            System.out.println("client accepted");

            // creating new thread
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                }
            });
            thread.start();
            
            // get input and output 
            

        } catch (IOException e) {
            System.out.println("IO error");
        }
    }
}
