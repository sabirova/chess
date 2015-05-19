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

    public void createGame(Player whitePlayer, Player blackPlayer) throws IOException {
        Game game = new Game(clients.get(whitePlayer), clients.get(blackPlayer));
        games.add(game);
        int result = game.play();
        switch (result) {
            case 0: {
                whitePlayer.drawGame(blackPlayer.getRating());
                blackPlayer.drawGame(whitePlayer.getRating());
                clients.get(whitePlayer).getMessenger().getMessenger().sendMessageXML(new Message(Command.SERVER, "draw. Rating: " + whitePlayer.getRating()));
                clients.get(blackPlayer).getMessenger().getMessenger().sendMessageXML(new Message(Command.SERVER, "draw. Rating: " + blackPlayer.getRating()));
                break;
            }
            case 1: {
                whitePlayer.winGame(blackPlayer.getRating());
                blackPlayer.loseGame();
                clients.get(whitePlayer).getMessenger().getMessenger().sendMessageXML(new Message(Command.SERVER, "you won. Rating: " + whitePlayer.getRating()));
                clients.get(blackPlayer).getMessenger().getMessenger().sendMessageXML(new Message(Command.SERVER, "you lost. Rating: " + blackPlayer.getRating()));
                break;
            }
            case 2: {
                whitePlayer.loseGame();
                blackPlayer.winGame(whitePlayer.getRating());
                clients.get(whitePlayer).getMessenger().getMessenger().sendMessageXML(new Message(Command.SERVER, "you lost. Rating: " + whitePlayer.getRating()));
                clients.get(blackPlayer).getMessenger().getMessenger().sendMessageXML(new Message(Command.SERVER, "you won. Rating: " + blackPlayer.getRating()));
                break;
            }
        }

    }

    public void removeGame(Game game) {
        games.remove(game);
    }
}
