package com.chessgame.messenger;

import javax.xml.bind.annotation.*;

@XmlType(name = "command")
@XmlEnum
public enum Command {

    @XmlEnumValue("Turn")
    TURN("Turn"),
    @XmlEnumValue("Exit")
    EXIT("Exit"),
    @XmlEnumValue("Join")
    JOIN("Join"),
    @XmlEnumValue("Login")
    LOGIN("Login"),
    @XmlEnumValue("Error")
    ERROR("Error"),
    @XmlEnumValue("Accept")
    ACCEPT("Accept"),
    @XmlEnumValue("Server")
    SERVER("Server"),
    @XmlEnumValue("List")
    LIST("List");

    private final String value;

    Command(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


    public static Command fromValue(String value) {
        for (Command c: Command.values()) {
            if (c.getValue().equalsIgnoreCase(value)) {
                return c;
            }
        }
        throw new IllegalArgumentException("No Enum specified for this string");
    }
}
