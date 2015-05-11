package com.chessgame.server;

import com.chessgame.game.Player;
import com.chessgame.messenger.Command;
import com.chessgame.messenger.Message;
import com.chessgame.messenger.Messenger;


import javax.xml.soap.SOAPException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class ClientThread extends Thread {

    private Player player;
    private ClientThreadMessenger messenger;
    private Server server;
    private boolean canMove;

    public ClientThread(Server server, Socket socket) throws IOException {
        this.server = server;
        try {
            messenger = new ClientThreadMessenger(server, new Messenger(socket));
            messenger.getMessenger().sendMessageXML(new Message(Command.SERVER,"Connected"));
        } catch (SocketException ex) {
            System.out.println("Connection error");
        } catch (IOException ex) {
            //TODO: logging
            ex.printStackTrace();
        }
        start();
    }

    @Override
    public void run() {
        loginPlayer();
        try {
            while (true) {
                messenger.waitMessage();
            }
        } catch (SocketException ex) {
            server.getClients().remove(player);
            System.out.println("Player " + player + " left");
        } catch (IOException ex) {
            server.getClients().remove(player);
            System.out.printf("player " + player + " left");
        }
    }

    public void loginPlayer() {
        try {
            while (!messenger.login) {
                player = messenger.login();
            }
            server.getClients().put(player, this);
        } catch (IOException ex) {
            System.out.println("Login error");
        }
    }

    public ClientThreadMessenger getMessenger() {
        return messenger;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public boolean isCanMove() {
        return canMove;
    }



}
