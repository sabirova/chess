package com.chessgame.game.pieces;

import com.chessgame.game.Player;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(Color color, Position position) {
        super("B", position, color);
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
        int i = x - 1;
        int j = y + 1;
        while (i>=0 && j<=7) {
            if (board.isOccupiedPosition(i, j, this.getColor())) {
                break;
            } else if (board.isOccupiedPosition(i, j, this.getEnemyColor())) {
                possibleMoves.add(new Position(i, j));
                break;
            } else {
                possibleMoves.add(new Position(i, j));
            }
            i--;
            j++;
        }
        //up-left
        i = x - 1;
        j = y - 1;
        while (i>=0 && j>=0) {
            if (board.isOccupiedPosition(i, j, this.getColor())) {
                break;
            } else if (board.isOccupiedPosition(i, j, this.getEnemyColor())) {
                possibleMoves.add(new Position(i, j));
                break;
            }  else {
                possibleMoves.add(new Position(i, j));
            }
            i--;
            j--;
        }
        //down-right
        i = x + 1;
        j = y + 1;
        while (i<=7 && j<=7) {
            if (board.isOccupiedPosition(i, j, this.getColor())) {
                break;
            } else if (board.isOccupiedPosition(i, j, this.getEnemyColor())) {
                possibleMoves.add(new Position(i, j));
                break;
            }  else {
                possibleMoves.add(new Position(i, j));
            }
            i++;
            j++;
        }
        //down-left
        i = x + 1;
        j = y - 1;
        while (i<=7 && j>=0) {
            if (board.isOccupiedPosition(i, j, this.getColor())) {
                break;
            } else if (board.isOccupiedPosition(i, j, this.getEnemyColor())) {
                possibleMoves.add(new Position(i, j));
                break;
            }  else {
                possibleMoves.add(new Position(i, j));
            }
            i++;
            j--;
        }

        return possibleMoves;
    }
}
