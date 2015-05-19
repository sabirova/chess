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
            ServerLogger.error(ClientThread.class.toString() + ex);
        } catch (IOException ex) {
            ServerLogger.error(ClientThread.class.toString() + ex);
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
            ServerLogger.error(ClientThread.class.toString() + ex);
        } catch (IOException ex) {
            server.getClients().remove(player);
            ServerLogger.error(ClientThread.class.toString() + ex);
        }
    }

    public void loginPlayer() {
        try {
            while (!messenger.login) {
                player = messenger.login();
            }
            server.getClients().put(player, this);
        } catch (IOException ex) {
            ServerLogger.error(ClientThread.class.toString() + ex);
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
