package com.chessgame.messenger;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _Command_QNAME = new QName("http://www.chessgame.com/message", "command");
    private final static QName _Text_QNAME = new QName("http://www.chessgame.com/message", "text");

    public ObjectFactory() {
    }

    public  Message createMessage() {
        return new Message();
    }

    @XmlElementDecl(namespace = "http://www.chessgame.com/message", name = "command")
    public JAXBElement<Command> createCommand(Command value) {
        return new JAXBElement<Command>(_Command_QNAME, Command.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.chessgame.com/message", name = "text")
    public JAXBElement<String> createText(String value) {
        return new JAXBElement<String>(_Text_QNAME, String.class, null, value);
    }

}
