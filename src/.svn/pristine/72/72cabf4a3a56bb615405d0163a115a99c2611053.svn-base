package com.chessgame.game.pieces;

public class Position {

    private int x;
    private int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public String toString() {
        switch (y) {
            case 0:
                return "a" + (8 - x);
            case 1:
                return "b" + (8 - x);
            case 2:
                return "c" + (8 - x);
            case 3:
                return "d" + (8 - x);
            case 4:
                return "e" + (8 - x);
            case 5:
                return "f" + (8 - x);
            case 6:
                return "g" + (8 - x);
            case 7:
                return "h" + (8 - x);
            default:
                return "  ";
        }
    }

    public static boolean isCorrectPosition(int x, int y) {
        if ((x>=0 && x<=7) && (y>=0&&y<=7)) {
            return true;
        } else {
            return false;
        }
    }
}
