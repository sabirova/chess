package com.chessgame.messenger.xml;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class XMLInputStream extends ByteArrayInputStream {
    private DataInputStream input;

    public XMLInputStream(InputStream input) {
        super(new byte[2048]);
        this.input = new DataInputStream(input);
    }

    public void receive() throws IOException {
        int i = input.readInt();
        byte[] data = new byte[i];
        input.read(data, 0, i);
        this.buf = data;
        this.count = i;
        this.mark = 0;
        this.pos = 0;
    }

}
