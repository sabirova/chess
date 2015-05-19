package com.chessgame.server;

import com.chessgame.game.Game;
import com.chessgame.game.Player;
import com.chessgame.messenger.Command;
import com.chessgame.messenger.Message;
import com.chessgame.messenger.Messenger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Server {

    private ServerSocket serverSocket;

    private Map<Player, ClientThread> clients = new HashMap<Player, ClientThread>();

    private Set<Game> games = new HashSet<Game>();

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public synchronized String getPlayerList(Player player) {
        if (clients.size() == 1 && clients.containsKey(player)) {
            return "Not one to play";
        } else {
            StringBuilder str = new StringBuilder();
            for (Player p: clients.keySet()) {
                if (p.isFree() && !p.equals(player)) {
                    str.append(p.getName() + " ");
                }
            }
            return str.toString();
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public Map<Player, ClientThread> getClients() {
        return clients;
    }

    public void playGame(ClientThread whitePlayer, ClientThread blackPlayer) {
        Game game = new Game(whitePlayer, blackPlayer);
    }

    public void createGame(Server server, ClientThread whitePlayer, ClientThread blackPlayer) throws IOException {
        Game game = new Game(whitePlayer, blackPlayer);
        games.add(game);
        whitePlayer.getMessenger().getMessenger().sendMessageXML(new Message(Command.SERVER, "game"));
        blackPlayer.getMessenger().getMessenger().sendMessageXML(new Message(Command.SERVER, "game"));
        int result = game.play();
    }

    public void removeGame(Game game) {
        games.remove(game);
    }
}
