package com.chessgame.game.pieces;

import com.chessgame.game.Player;

import java.util.List;

public abstract class Piece {

    private String name;

    private Position position;

    private Color color;

    private boolean captured;

    public Piece() {

    }

    public Piece(String name, Position position, Color color) {
        this.name = name;
        this.color = color;
        this.position = position;
    }

    public Color getColor(){
        return color;
    }
    public Position getPosition(){
        return position;
    }
    public String getName() {return name;}
    public Color getEnemyColor() {
        return color == Color.WHITE ? Color.BLACK : Color.WHITE;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    public void move() {};

    public abstract boolean canMove(Position positionTo);

    public abstract List<Position> getPossibleMoves(Player player, Board board);

    @Override
    public String toString() {
        return color.getShortName() + name;
    }
}
