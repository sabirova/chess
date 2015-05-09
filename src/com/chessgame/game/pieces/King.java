package com.chessgame.game.pieces;

import com.chessgame.game.Player;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    public King(Color color, Position position) {
        super("K", position, color);
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
        //right
        if (Position.isCorrectPosition(x, y + 1) && !board.isOccupiedPosition(x, y + 1, this.getColor())) {
            possibleMoves.add(new Position(x, y + 1));
        }
        //left
        if (Position.isCorrectPosition(x, y - 1) && !board.isOccupiedPosition(x, y - 1, this.getColor())) {
            possibleMoves.add(new Position(x, y - 1));
        }
        //up
        if (Position.isCorrectPosition(x - 1, y) && !board.isOccupiedPosition(x - 1, y, this.getColor())) {
            possibleMoves.add(new Position(x - 1, y));
        }
        //down
        if (Position.isCorrectPosition(x + 1, y) && !board.isOccupiedPosition(x + 1, y, this.getColor())) {
            possibleMoves.add(new Position(x + 1, y));
        }
        //up-right
        if (Position.isCorrectPosition(x - 1, y + 1) && !board.isOccupiedPosition(x - 1, y + 1, this.getColor())) {
            possibleMoves.add(new Position(x - 1, y + 1));
        }
        //up-left
        if (Position.isCorrectPosition(x - 1, y - 1) && !board.isOccupiedPosition(x - 1, y - 1, this.getColor())) {
            possibleMoves.add(new Position(x - 1, y - 1));
        }
        //down-right
        if (Position.isCorrectPosition(x + 1, y + 1) && !board.isOccupiedPosition(x + 1, y + 1, this.getColor())) {
            possibleMoves.add(new Position(x + 1, y + 1));
        }
        //down-left
        if (Position.isCorrectPosition(x + 1, y - 1) && !board.isOccupiedPosition(x + 1, y - 1, this.getColor())) {
            possibleMoves.add(new Position(x + 1, y - 1));
        }
        return possibleMoves;
    }
}
