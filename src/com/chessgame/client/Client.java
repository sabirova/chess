package com.chessgame.client;

import com.chessgame.messenger.Messenger;

import java.io.IOException;
import java.net.Socket;

public class Client {

    private static final int PORT = 5001;

    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 8080);
            ClientMessenger messenger = new ClientMessenger(new Messenger(client));
            messenger.waitMessage();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }





}
