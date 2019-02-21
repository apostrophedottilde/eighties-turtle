package com.bitcrunchy.api;

import java.util.List;

public class Grid {

    private int width;

    private int height;

    private List<Obstacle> obstacles;

    public Grid(int width, int height, List<Obstacle> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = obstacles;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }
}
