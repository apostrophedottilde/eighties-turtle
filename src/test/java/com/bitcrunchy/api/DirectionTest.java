package com.bitcrunchy.api;

import org.junit.Test;

import static org.junit.Assert.*;

public class DirectionTest {

    @Test
    public void shouldReturnEastWhenFacingNorthAndInvokeTurnRight() {
        Direction dir = Direction.NORTH;
        Direction newDirection = dir.turnRight();
        assertEquals(newDirection, Direction.EAST);
    }

    @Test
    public void shouldReturnWestWhenFacingNorthAndInvokeTurnLeft() {
        Direction dir = Direction.NORTH;
        Direction newDirection = dir.turnLeft();
        assertEquals(newDirection, Direction.WEST);
    }

    @Test
    public void shouldReturnWestWhenFacingSouthAndInvokeTurnRight() {
        Direction dir = Direction.SOUTH;
        Direction newDirection = dir.turnRight();
        assertEquals(newDirection, Direction.WEST);
    }

    @Test
    public void shouldReturnEastWhenFacingSouthAndInvokeTurnLeft() {
        Direction dir = Direction.SOUTH;
        Direction newDirection = dir.turnLeft();
        assertEquals(newDirection, Direction.EAST);
    }

    @Test
    public void shouldReturnNorthWhenFacingWestAndInvokeTurnRight() {
        Direction dir = Direction.WEST;
        Direction newDirection = dir.turnRight();
        assertEquals(newDirection, Direction.NORTH);
    }

    @Test
    public void shouldReturnSouthWhenFacingWestAndInvokeTurnLeft() {
        Direction dir = Direction.WEST;
        Direction newDirection = dir.turnLeft();
        assertEquals(newDirection, Direction.SOUTH);
    }

    @Test
    public void shouldReturnSouthWhenFacingEastAndInvokeTurnRight() {
        Direction dir = Direction.EAST;
        Direction newDirection = dir.turnRight();
        assertEquals(newDirection, Direction.SOUTH);
    }

    @Test
    public void shouldReturnNorthWhenFacingEastAndInvokeTurnLeft() {
        Direction dir = Direction.EAST;
        Direction newDirection = dir.turnLeft();
        assertEquals(newDirection, Direction.NORTH);
    }
}