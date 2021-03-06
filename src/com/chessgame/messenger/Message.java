package com.chessgame.messenger;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"command","text"})
@XmlRootElement
public class Message implements Serializable {

    @XmlElement(name = "command")
    Command command;

    @XmlElement(name = "text")
    String text;

    public Message(Command command, String text) {
        this.command = command;
        this.text = text;
    }

    public Message(String text) {
        this(null, text);
    }

    public Message(Command command) {
        this(command, null);
    }
    public Message() {

    }


    public Command getCommand() {
        return command;
    }

    public String getText() {
           return text;
    }


    public static Message fromString(String str) throws InvalidMessageException {
        Command command;
        if (str != null) {
            str = str.trim();
            if (str.contains(" ")) {
                String args[] = str.split(" ");
                command = Command.fromValue(args[0]);
                String text = args[1];
                return new Message(command, text);
            } else if ((command = Command.fromValue(str)) != null) {
                return new Message(command, command.toString());
            }
        }
        throw  new InvalidMessageException();

    }

    public static Document convertToXML(Message message) {

        Document doc = null;
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            doc = docBuilder.newDocument();
            Element root = doc.createElement("message");
            doc.appendChild(root);

            Element command = doc.createElement("command");
            command.appendChild(doc.createTextNode(message.getCommand().getValue()));
            root.appendChild(command);

            Element text = doc.createElement("text");
            text.appendChild(doc.createTextNode(message.getText()));
            root.appendChild(text);

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
        }

        return doc;
    }

    public static Message fromXML(Document doc) {
        Message message = null;
        doc.getDocumentElement().normalize();
        Element root = doc.getDocumentElement();

        String value = doc.getElementsByTagName("command").item(0).getTextContent();
        Command command = Command.fromValue(value);

        String text = doc.getElementsByTagName("text").item(0).getTextContent();

        message = new Message(command, text);

        return  message;
    }

    @Override
    public String toString() {
        return command + " " + text;
    }


}
