package com.chessgame.game;

import com.chessgame.game.pieces.Board;
import com.chessgame.server.ClientThread;

public class Game {

    ClientThread whitePlayer;
    ClientThread blackPlayer;
    boolean checkmate = false;

    public Game(ClientThread whitePlayer, ClientThread blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        whitePlayer.setCanMove(true);
    }

    public void play() {
        Board board = new Board();
    }

}
