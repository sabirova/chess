package com.chessgame.game;

import com.chessgame.game.pieces.Color;
import com.chessgame.game.pieces.Piece;

public class Player {

    private Color color;
    private String name;
    private boolean free = true;
    private int rating;
    private int gamesCount;
    private int winGames;
    private int losGames;

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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setGamesCount(int games) {
        this.gamesCount = games;
    }

    public int getGamesCount() {
        return gamesCount;
    }

    public void setWinGames(int winGames) {
        this.winGames = winGames;
    }

    public int getWinGames() {
        return winGames;
    }

    public void setLosGames(int losGames) {
        this.losGames = losGames;
    }

    public int losWinGames() {
        return losGames;
    }

    public void loseGame() {
        gamesCount++;
        losGames++;
    }

    public void winGame(int opponentRating) {
        gamesCount++;
        winGames++;
        rating = (int)(opponentRating * 0.25);
    }

    public void drawGame(int opponentRating) {
        gamesCount++;
        rating = (int)(opponentRating * 0.125);
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
