package com.chessgame.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ainur on 09.05.2015.
 */
public class ServerApp {

    public static void main(String[] args) {

        try {
            Server server = new Server(8080);
            while (true) {
                Socket client = server.getServerSocket().accept();
                new ClientThread(server, client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
