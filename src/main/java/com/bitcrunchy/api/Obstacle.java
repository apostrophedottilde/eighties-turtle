package com.bitcrunchy.api;

public class Obstacle {

    private int xPos;

    private int yPos;

    public Obstacle(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }
}
