package com.chessgame.game;

import com.chessgame.game.pieces.Board;
import com.chessgame.messenger.Command;
import com.chessgame.messenger.Message;
import com.chessgame.messenger.Messenger;
import com.chessgame.server.ClientThread;

import java.io.IOException;

public class Game {

    private ClientThread whitePlayer;
    private ClientThread blackPlayer;
    private Messenger whiteMessenger;
    private Messenger blackMessenger;
    private boolean checkmate = false;

    public Game(ClientThread whitePlayer, ClientThread blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.whiteMessenger = whitePlayer.getMessenger().getMessenger();
        this.blackMessenger = blackPlayer.getMessenger().getMessenger();
        whitePlayer.setCanMove(true);
    }

    public int play() throws IOException{
        int result = 0;
        Board board = new Board();
        while(!checkmate) {
            Message m;
            whiteMessenger.sendMessageXML(new Message(Command.SERVER, board.drawBoard()));
            blackMessenger.sendMessageXML(new Message(Command.SERVER, board.drawBoard()));
            checkmate = true;
            result = 1;
        }
        return result;
    }

}
