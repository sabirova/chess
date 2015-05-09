package com.chessgame.game;

import com.chessgame.game.pieces.Color;
import com.chessgame.game.pieces.Piece;

public class Player {

    private Color color;
    private String name;
    private boolean free = true;

    public Player() {

    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Player(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isOwnPiece(Piece piece){
        if(piece.getColor()==color) {
            return true;
        } else {
            return false;
        }
    }

    public void setFree (boolean free) {
        this.free = free;
    }
    public boolean isFree() {
        return free;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Player)) {
            return false;
        }
        Player other = (Player)obj;
        if(!this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
