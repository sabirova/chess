package com.chessgame.client;

import com.chessgame.messenger.InvalidMessageException;
import com.chessgame.messenger.Message;
import com.chessgame.messenger.Messenger;

import javax.xml.bind.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientMessenger {

    private final Messenger messenger;
    private boolean connected = true;

    public ClientMessenger(Messenger messenger) {
        this.messenger = messenger;
    }

    public void waitMessage() throws IOException {
       while(connected){
           try {
               Message message = messenger.getMessageXML();
               if (message == null) {
                   return;
               }
               readMessage(message);
               messenger.sendMessageXML(readFromConsole());
           } catch (JAXBException ex) {
               ex.printStackTrace();
           }
       }

    }

    public void readMessage(Message message) throws JAXBException{
        switch (message.getCommand()) {
            case SERVER: {
                System.out.println(message.getText());
                break;
            }
            case ERROR:{
                System.out.println(message.getText());
                break;
            }
        }
    }

    public Message readFromConsole() {
        Message message = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = br.readLine();
            message = Message.fromString(str);
        } catch (IOException ex) {
            Logger.getLogger(ClientMessenger.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidMessageException ex) {
            System.out.println("Incorrect message");
            //try again
            message = readFromConsole();
        }

        return message;
    }




}
