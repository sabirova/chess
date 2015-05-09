package com.chessgame.game.pieces;

import com.chessgame.game.Player;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    public Queen(Color color, Position position) {
        super("Q", position, color);
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
        possibleMoves.addAll(new Bishop(this.getColor(), this.getPosition()).getPossibleMoves(player, board));
        possibleMoves.addAll(new Rook(this.getColor(), this.getPosition()).getPossibleMoves(player, board));
        return possibleMoves;
    }
}
