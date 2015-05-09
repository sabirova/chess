package com.chessgame.messenger.xml;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class XMLOutputStream extends ByteArrayOutputStream{

    private DataOutputStream output;

    public XMLOutputStream(OutputStream outchannel) {
        super();
        this.output = new DataOutputStream(outchannel);
    }

    public void send() throws IOException {
        byte[] data = toByteArray();
        output.writeInt(data.length);
        output.write(data);
        output.flush();
        reset();
    }

}
