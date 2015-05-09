package com.chessgame.server;

import com.chessgame.game.Player;
import com.chessgame.messenger.Messenger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


public class Server {

    private ServerSocket serverSocket;

    public Map<Player, Messenger> clients = new HashMap<Player, Messenger>();

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public synchronized String getPlayerList(Player player) {
        StringBuilder str = new StringBuilder();
        for (Player p: clients.keySet()) {
            if (!p.equals(player)) {
                str.append(p.getName() + " ");
            }
        }
        return str.toString();
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }


}
