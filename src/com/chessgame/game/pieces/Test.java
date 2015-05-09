package com.chessgame.game.pieces;

import com.chessgame.game.Player;

public class Test {

    public static void main(String[] args) {
        Board b = new Board();
        System.out.println(b.drawBoard());
        Piece piece = b.getPieces().get(20);

        for (Position p: piece.getPossibleMoves(new Player(), b)) {
            System.out.println(piece.toString() +" " + p);
        }
        b.changePiecePosition(piece, new Position(5, 0));

        System.out.println(b.drawBoard());
        for (Position p: piece.getPossibleMoves(new Player(), b)) {
            System.out.println(piece.toString() + " " + p);
        }
    }
}
