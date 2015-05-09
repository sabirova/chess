package com.chessgame.messenger;

import com.chessgame.messenger.xml.XMLMessenger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Messenger {

    private Socket socket;
    private final InputStream is;
    private final OutputStream os;
    private final ObjectInputStream input;
    private final ObjectOutputStream output;

    public Messenger(Socket socket) throws IOException {
        this.socket = socket;
        is = socket.getInputStream();
        os = socket.getOutputStream();
        output = new ObjectOutputStream(os);
        output.flush();
        input = new ObjectInputStream(is);

        output.flush();
    }

    public Socket getSocket() {
        return socket;
    }


    public Message getMessage() throws IOException {
        try {
            return (Message) input.readObject();
        } catch (ClassNotFoundException ex) {
            return null;
        }

    }

    public void sendMessage(Message message) throws IOException {
        output.writeObject(message);
        output.flush();
    }


    public Message getMessageXML() throws IOException {
        try{
            return Message.fromXML(XMLMessenger.receive(is));
        } catch (SAXException ex) {
            Logger.getLogger(Messenger.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Messenger.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Messenger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public void sendMessageXML(Message message) throws IOException {
        try {
            XMLMessenger.send(Message.convertToXML(message), os);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Messenger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




}
