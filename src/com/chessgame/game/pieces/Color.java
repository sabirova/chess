package com.chessgame.game.pieces;

public enum Color {

    WHITE("W"), BLACK("B");

    private String shortName;

    Color(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }
}
