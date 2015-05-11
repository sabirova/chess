package com.chessgame.client;

import com.chessgame.messenger.InvalidMessageException;
import com.chessgame.messenger.Message;
import com.chessgame.messenger.Messenger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ainur on 11.05.2015.
 */
public class ReadConsole implements Runnable{

    Messenger messenger;
    BufferedReader br;

    ReadConsole(Messenger messenger)  {
        this.messenger = messenger;
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        try {
            while (true) {
                messenger.sendMessageXML(readFromConsole());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Message readFromConsole() {
        Message message = null;
        try {
            String str = br.readLine();
            message = Message.fromString(str);
            Message.convertToXML(message).toString();
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
