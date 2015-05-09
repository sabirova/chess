package com.chessgame.game.pieces;

import com.chessgame.game.Player;

import java.util.ArrayList;
import java.util.List;


public class Knight extends Piece {

    public Knight(Color color, Position position) {
        super("N", position, color);
    }

    @Override
    public boolean canMove(Position positionTo) {
        return false;
    }

    @Override
    public List<Position> getPossibleMoves(Player player, Board board) {
        List<Position> possibleMoves = new ArrayList<Position>();
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();
        //up-right
        if (Position.isCorrectPosition(x + 2, y - 1)) {
            if (!board.isOccupiedPosition(x+2, y-1, this.getColor())) {
                possibleMoves.add(new Position(x+2, y-1));
            }
        }
        if (Position.isCorrectPosition(x + 1, y - 2)) {
            if (!board.isOccupiedPosition(x+1, y-2, this.getColor())) {
                possibleMoves.add(new Position(x+1, y-2));
            }
        }
        //up-left
        if (Position.isCorrectPosition(x - 2, y - 1)) {
            if (!board.isOccupiedPosition(x-2, y-1, this.getColor())) {
                possibleMoves.add(new Position(x-2, y-1));
            }
        }
        if (Position.isCorrectPosition(x - 1, y - 2)) {
            if (!board.isOccupiedPosition(x-1, y-2, this.getColor())) {
                possibleMoves.add(new Position(x-1, y-2));
            }
        }
        //down-right
        if (Position.isCorrectPosition(x + 2, y + 1)) {
            if (!board.isOccupiedPosition(x+2, y+1, this.getColor())) {
                possibleMoves.add(new Position(x+2, y+1));
            }
        }
        if (Position.isCorrectPosition(x + 1, y + 2)) {
            if (!board.isOccupiedPosition(x+1, y+2, this.getColor())) {
                possibleMoves.add(new Position(x+1, y+2));
            }
        }
        //down-left
        if (Position.isCorrectPosition(x - 2, y + 1)) {
            if (!board.isOccupiedPosition(x-2, y+1, this.getColor())) {
                possibleMoves.add(new Position(x-2, y+1));
            }
        }
        if (Position.isCorrectPosition(x - 1, y + 2)) {
            if (!board.isOccupiedPosition(x-1, y+2, this.getColor())) {
                possibleMoves.add(new Position(x-1, y+2));
            }
        }
        return possibleMoves;
    }
}
