package com.bitcrunchy.api;

import java.util.stream.Stream;

public class Turtle {

    private int xPos;

    private int yPos;

    private int lastClearXPos;

    private int lastClearYPos;

    private boolean hasCollided;

    private Direction direction;

    private Grid grid;

    public Turtle(int xPos, int yPos, Direction direction, Grid grid) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.direction = direction;
        this.grid = grid;
    }

    public void feedCommands(char[] commands) {
        validateCommands(commands);
        System.out.println(this);

        int index = 0;
        while (!hasCollided && index < commands.length) {
            if (commands[index] == 'l' || commands[index] == 'r') {
                this.turn(commands[index]);
            } else {
                this.move(commands[index]);
            }
            System.out.println(this);
            index++;
        }

        if (hasCollided) {
            System.out.println("\nThe turtle has gone as far as it can along it's given path (" + lastClearXPos + "," + lastClearYPos + ").\nThere is a collision at: (" + xPos + "," + yPos + ").");
        } else {
            System.out.println("\nThe turtle has completed it's journey to (" + xPos + "," + yPos + ").");
        }
    }


    private void turn(char turnDirection) {
        if (turnDirection == 'l') {
            this.direction = this.direction.turnLeft();
            System.out.println("turned left");
        } else {
            this.direction = this.direction.turnRight();
            System.out.println("turned right");
        }
    }

    private void move(char forwardOrBack) {
        if (forwardOrBack == 'f') {
            System.out.println("moved forward");
            moveForward();
        } else {
            System.out.println("moved backward");
            moveBackward();
        }
    }

    private void moveForward() {
        switch (direction) {
            case NORTH:
                this.yPos = yPos == 1 ? grid.getHeight(): yPos - 1;
                break;
            case SOUTH:
                this.yPos = yPos == grid.getHeight() ? 1 : yPos + 1;
                break;
            case WEST:
                this.xPos = xPos == 1 ? grid.getWidth(): xPos - 1;
                break;
            case EAST:
                this.xPos = xPos == grid.getWidth() ? 1 : xPos + 1;
                break;
        }
        hasCollision(xPos, yPos);
    }

    private void hasCollision(int x, int y) {
        final Stream<Obstacle> obstacleStream = grid.getObstacles().stream().filter(o -> o.getxPos() == x && o.getyPos() == y);
        if (obstacleStream.count() > 0) {
            System.out.println("There would be a collision at : " + x + "," + y);
            hasCollided = true;
        } else  {
            lastClearXPos = xPos;
            lastClearYPos = yPos;
        }
    }

    private void moveBackward() {
        switch (direction) {
            case NORTH:
                this.yPos = yPos == 1 ? grid.getHeight(): yPos -1;
                break;
            case SOUTH:
                this.yPos = yPos == grid.getHeight() ? 1 : yPos + 1;
                break;
            case WEST:
                this.xPos = xPos == grid.getWidth() ? 1: xPos + 1;
                break;
            case EAST:
                this.xPos = xPos == 1 ? grid.getWidth() : xPos - 1;
                break;
        }
        hasCollision(xPos, yPos);
    }

    private void validateCommands(char[] commands) {
        for (Character c : commands) {
            if (isCharValid(c)) {
                throw new IllegalArgumentException("Command '" + c + "' not recognised as valid command.");
            }
        }
    }

    private boolean isCharValid(Character c) {
        return !c.equals('f') && !c.equals('b') && !c.equals('l') && !c.equals('r');
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getLastClearXPos() {
        return lastClearXPos;
    }

    public int getLastClearYPos() {
        return lastClearYPos;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Turtle position and orientation {" +
                "xpos=" + xPos +
                ", yPos=" + yPos +
                ", direction=" + direction +
                '}';
    }

    public boolean hasCollided() {
        return hasCollided;
    }
}
