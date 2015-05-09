package com.chessgame.messenger.xml;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XMLMessenger {

    public static void send(Document tosend, OutputStream output) throws TransformerConfigurationException, IOException {
        XMLOutputStream out = new XMLOutputStream(output);

        StreamResult sr = new StreamResult(out);
        DOMSource ds = new DOMSource(tosend);
        Transformer tf = TransformerFactory.newInstance().newTransformer();

        try {
            tf.transform(ds, sr);
        } catch (TransformerException ex) {
            Logger.getLogger(XMLMessenger.class.getName()).log(Level.SEVERE, null, ex);
        }

        out.send();
    }

    public static Document receive(InputStream input) throws ParserConfigurationException, TransformerConfigurationException, IOException, SAXException {

        DocumentBuilderFactory docBuilderFact = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFact.newDocumentBuilder();
        Document request = null;

        XMLInputStream xmlin = new XMLInputStream(input);

        xmlin.recive();

        request = docBuilder.parse(xmlin);

        return request;
    }

}
