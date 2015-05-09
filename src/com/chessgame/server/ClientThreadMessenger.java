package com.chessgame.server;

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

            }
            case EXIT: {

            }
            case JOIN: {

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
            }
            case LOGIN:{
                if (login) {
                    messenger.sendMessageXML(new Message(Command.SERVER, "You have already logged in"));
                } else {
                    login(message.getText());
                }
            }
        }
    }

    public Player login() throws IOException{
        Message message = messenger.getMessageXML();
        if (message == null|| message.getCommand() != Command.LOGIN) {
            messenger.sendMessageXML(new Message(Command.ERROR, "to log on, type: login name"));
        }
        player = new Player(message.getText());
        if (!Server.clients.containsKey(player)) {
            Server.clients.put(player, messenger);
            messenger.sendMessageXML(new Message(Command.SERVER, "Success login"));
            login = true;
            return player;
        } else {
            messenger.sendMessageXML(new Message(Command.ERROR, "You have already logged in"));
            return null;
        }
    }

    public void sendPlayerList() throws IOException{
        messenger.sendMessageXML(new Message(Command.SERVER, Server.getPlayerList(player)));
    }

    public void login(String name) {
        player = new Player();
        if (!server.clients.containsKey(player)) {
            server.clients.put(player, messenger);

        }
    }






}
