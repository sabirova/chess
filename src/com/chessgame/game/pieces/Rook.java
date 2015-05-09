package com.chessgame.game.pieces;

import com.chessgame.game.Player;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    public Rook(Color color, Position position) {
        super("R", position, color);
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
        Color enemyColor;
        if (this.getColor() == Color.WHITE) {
            enemyColor= Color.BLACK;
        } else {
            enemyColor= Color.WHITE;
        }
        int i, j;
        //up
        i = x;
        i--;
        while (i>=0) {
            if (board.isOccupiedPosition(i, y, this.getColor())) {
                break;
            } else if (board.isOccupiedPosition(i, y, this.getEnemyColor())) {
                possibleMoves.add(new Position(i, y));
                break;
            } else {
                possibleMoves.add(new Position(i, y));
            }
            i--;
        }
        //down
        i = x;
        i++;
        while (i<=7) {
            if (board.isOccupiedPosition(i, y, this.getColor())) {
                break;
            } else if (board.isOccupiedPosition(i, y, this.getEnemyColor())) {
                possibleMoves.add(new Position(i, y));
                break;
            } else {
                possibleMoves.add(new Position(i, y));
            }
            i++;
        }
        //right
        j = y;
        j++;
        while (j<=7) {
            if (board.isOccupiedPosition(x, j, this.getColor())) {
                break;
            } else if (board.isOccupiedPosition(x, j, this.getEnemyColor())) {
                possibleMoves.add(new Position(x, j));
                break;
            }  else {
                possibleMoves.add(new Position(x, j));
            }
            j++;
        }
        //left
        j = y;
        j--;
        while (j>=0) {
            if (board.isOccupiedPosition(x, y, this.getColor())) {
                break;
            } else if (board.isOccupiedPosition(x, j, this.getEnemyColor())) {
                possibleMoves.add(new Position(x, j));
                break;
            }  else {
                possibleMoves.add(new Position(x, j));
            }
            j--;
        }
        return possibleMoves;
    }
}
