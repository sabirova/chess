package com.chessgame.server;

import com.chessgame.game.Player;
import com.chessgame.messenger.Command;
import com.chessgame.messenger.Message;
import com.chessgame.messenger.Messenger;


import java.io.IOException;
import java.net.Socket;

public class ClientThread extends Thread {

    private Player player;
    private ClientThreadMessenger messenger;
    Server server;

    public ClientThread(Server server, Socket socket) {
        this.server = server;
        try {
            messenger = new ClientThreadMessenger(server, new Messenger(socket));
            messenger.getMessenger().sendMessageXML(new Message(Command.SERVER,"Connected"));
            while (!messenger.login) {
                player = messenger.login();
            }
        } catch (IOException ex) {
            //TODO: logging
            ex.printStackTrace();
        }
        start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                messenger.waitMessage();
            }
        } catch (IOException ex) {
            Server.clients.remove(player);
            System.out.println("User exit");
        }
    }




}
