package com.chessgame.game.pieces;

import com.chessgame.game.Player;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    private boolean moved;

    public Pawn(Color color, Position position) {
        super("P", position, color);
    }

    @Override
    public boolean canMove(Position position) {
        return false;
    }

    @Override
    public List<Position> getPossibleMoves(Player player, Board board) {
        List<Position> possibleMoves = new ArrayList<Position>();
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();
        if (this.getColor() == Color.WHITE) {
            if (x==6) {
                if(!board.isOccupiedPosition(x - 1, y)) {
                    possibleMoves.add(new Position(x - 1, y));
                    if(!board.isOccupiedPosition(x - 2, y)) {
                        possibleMoves.add(new Position(x - 2, y));
                    }
                }
            } else {
                if (x - 1 >= 0 && !board.isOccupiedPosition(x - 1, y)) {
                    possibleMoves.add(new Position(x - 1, y));
                }
            }
            if (board.isOccupiedPosition(x - 1, y + 1, Color.BLACK)) {
                possibleMoves.add(new Position(x - 1, y + 1));
            }
            if (board.isOccupiedPosition(x - 1, y - 1, Color.BLACK)) {
                possibleMoves.add(new Position(x - 1, y - 1));
            }
        } else {
            if (x==1) {
                if(!board.isOccupiedPosition(x + 1, y)) {
                    possibleMoves.add(new Position(x + 1, y));
                    if(!board.isOccupiedPosition(x + 2, y)) {
                        possibleMoves.add(new Position(x + 2, y));
                    }
                }
            } else {
                if (x + 1 < 8 && !board.isOccupiedPosition(x + 1, y)) {
                    possibleMoves.add(new Position(x + 1, y));
                }
            }
            if (board.isOccupiedPosition(x + 1, y + 1, Color.BLACK)) {
                possibleMoves.add(new Position(x + 1, y + 1));
            }
            if (board.isOccupiedPosition(x + 1, y - 1, Color.BLACK)) {
                possibleMoves.add(new Position(x + 1, y - 1));
            }
        }
        return possibleMoves;

    }
}
