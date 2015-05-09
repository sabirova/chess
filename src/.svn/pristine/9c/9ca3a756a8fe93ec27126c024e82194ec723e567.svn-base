package com.chessgame.game.pieces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Board {

    private Piece[][] board = new Piece[8][8];
    private ArrayList<Piece> pieces = new ArrayList<Piece>(32);

    public Board() {
        init();
    }

    public void init() {
        createPieces();
        fillBoard();
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void createPieces() {
        //Pawns
        for (int i = 0; i < 8; i++) {
            pieces.add(new Pawn(Color.WHITE, new Position(6, i)));
            pieces.add(new Pawn(Color.BLACK, new Position(1, i)));
        }
        //rooks
        pieces.add(new Rook(Color.WHITE, new Position(7, 0)));
        pieces.add(new Rook(Color.WHITE, new Position(7, 7)));
        pieces.add(new Rook(Color.BLACK, new Position(0, 0)));
        pieces.add(new Rook(Color.BLACK, new Position(0, 7)));
        //knights
        pieces.add(new Knight(Color.WHITE, new Position(7, 1)));
        pieces.add(new Knight(Color.WHITE, new Position(7, 6)));
        pieces.add(new Knight(Color.BLACK, new Position(0, 1)));
        pieces.add(new Knight(Color.BLACK, new Position(0, 6)));
        //bishops
        pieces.add(new Bishop(Color.WHITE, new Position(7, 2)));
        pieces.add(new Bishop(Color.WHITE, new Position(7, 5)));
        pieces.add(new Bishop(Color.BLACK, new Position(0, 2)));
        pieces.add(new Bishop(Color.BLACK, new Position(0, 5)));
        //queens
        pieces.add(new Queen(Color.WHITE, new Position(7, 3)));
        pieces.add(new Queen(Color.BLACK, new Position(0, 3)));
        //kings
        pieces.add(new King(Color.WHITE, new Position(7, 4)));
        pieces.add(new King(Color.BLACK, new Position(0, 4)));
    }

    public void fillBoard() {
        for (Piece piece: pieces) {
            board[piece.getPosition().getX()][piece.getPosition().getY()] = piece;
        }
    }

    public String drawBoard() {
        fillBoard();
        StringBuilder drawedBoard = new StringBuilder();
        drawedBoard.append("     a  b  c  d  e  f  g  h\n");
        drawedBoard.append("  ###########################\n");
        for (int i=0; i<=7; i++) {
            drawedBoard.append(8 - i + " #|");
            for (int j=0; j<=7; j++) {
                if (board[i][j] == null) {
                    drawedBoard.append("  ");
                    drawedBoard.append("|");
                } else {
                    drawedBoard.append(board[i][j]);
                    drawedBoard.append("|");
                }
            }
            drawedBoard.append("# " + (8 - i) + "\n");
            if (i!=7) {
                drawedBoard.append("  #|-----------------------|#\n");
            }
        }
        return drawedBoard.toString();

    }

    public boolean isOccupiedPosition(int x, int y){
        for (Piece piece: pieces) {
            if (piece.getPosition().getX() == x && piece.getPosition().getY() == y) {
                return true;
            }
        }
        return false;
    }

    public boolean isOccupiedPosition(int x, int y, Color color){
        for (Piece piece: pieces) {
            if (piece.getColor() == color) {
                if (piece.getPosition().getX() == x && piece.getPosition().getY() == y) {
                    return true;
                }
            }
        }
        return false;
    }

    public void removePiece(Piece piece) {
        board[piece.getPosition().getX()][piece.getPosition().getY()] = null;
        pieces.remove(piece);
    }

    public void changePiecePosition(Piece piece, Position position) {
        removePiece(piece);
        piece.setPosition(position);
        pieces.add(piece);
        board[position.getX()][position.getY()] = piece;
    }

    public void turn() {

    }

}
