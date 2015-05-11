package com.chessgame.server;

import com.chessgame.game.Game;
import com.chessgame.game.Player;
import com.chessgame.messenger.Command;
import com.chessgame.messenger.Message;
import com.chessgame.messenger.Messenger;
import javax.xml.bind.JAXBException;
import java.io.*;

public class ClientThreadMessenger {

    private final Messenger messenger;
    private Player player;
    boolean login;
    Server server;
    ClientThread anotherClientThread;

    public ClientThreadMessenger(Server server, Messenger messenger) {
        this.server = server;
        this.messenger = messenger;
        try{
            messenger.getSocket().getOutputStream().flush();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public Messenger getMessenger() {
        return messenger;
    }

    public void waitMessage() throws IOException{
        try {
            Message message = messenger.getMessageXML();
            if (message == null) {
                return;
            }
            readMessage(message);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

    public void readMessage(Message message)  throws IOException, JAXBException{
        switch (message.getCommand()) {
            case TURN: {
                turn(message.getText());
                break;
            }
            case EXIT: {

            }
            case JOIN: {
                joinPlayer(message.getText());
                break;
            }
            case ACCEPT: {

            }
            case SERVER: {
                System.out.println(message.getText());
                break;
            }
            case LIST: {
                sendPlayerList();
                break;
            } case LOGIN: {
                messenger.sendMessageXML(new Message(Command.SERVER, "you have already login"));
                break;
            } case PING: {
                messenger.sendMessageXML(new Message(Command.SERVER,"ping"));
                break;
            }
        }
    }

    public Player login() throws IOException{
        Message message = messenger.getMessageXML();
        if (message == null|| message.getCommand() != Command.LOGIN) {
            messenger.sendMessageXML(new Message(Command.ERROR, ""));
        }
        player = new Player(message.getText());
        if (!server.getClients().containsKey(player)) {
            messenger.sendMessageXML(new Message(Command.SERVER, "Success login"));
            login = true;
            return player;
        } else {
            messenger.sendMessageXML(new Message(Command.ERROR, "You have already logged in"));
            return null;
        }
    }

    public void sendPlayerList() throws IOException{
        messenger.sendMessageXML(new Message(Command.SERVER, server.getPlayerList(player)));
    }

    public void joinPlayer(String name) throws IOException {
        Player anotherPlayer = new Player(name);
        if (server.getClients().containsKey(anotherPlayer)) {
            anotherClientThread = server.getClients().get(anotherPlayer);
            if (getAcceptForPlay()) {
                player.setFree(false);
                anotherPlayer.setFree(false);
                server.createGame(server, server.getClients().get(player), anotherClientThread);
            } else {
                messenger.sendMessageXML(new Message(Command.SERVER, "Player " + anotherPlayer + " refused to play"));
            }
        } else {
            messenger.sendMessageXML(new Message(Command.SERVER, "This player is not in the system"));
        }
    }

    public boolean getAcceptForPlay() throws IOException {
        anotherClientThread.getMessenger().getMessenger().sendMessageXML
                (new Message(Command.SERVER, "Player " + player + " wants play with you. Enter: Accept or Refuse"));
        Message accessMessage;
        accessMessage = anotherClientThread.getMessenger().getMessenger().getMessageXML();
        if (accessMessage != null && accessMessage.getCommand() == Command.ACCEPT) {
            return true;
        }
        return false;
    }

    public void turn(String text) throws IOException {
        anotherClientThread.getMessenger().getMessenger().sendMessageXML(new Message(Command.SERVER, text));
    }








}
