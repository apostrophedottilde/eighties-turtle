package com.bitcrunchy.api;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.bitcrunchy.api.Direction.*;
import static org.junit.Assert.*;

public class TurtleTest {

    @Test
    public void shouldMoveToLastSquareBeforeCollisionAndReportBothCollisionAndLastSafeSquare() {
        // given
        final List<Obstacle> obstacles = Arrays.asList(new Obstacle(7, 5));
        final Grid grid = new Grid(10, 10, obstacles);
        final Direction direction = NORTH;
        final Turtle underTest = new Turtle(7, 8, direction, grid );
        final char[] commands = new char[]{'f', 'f', 'f', 'f', 'f'};

        // when
        underTest.feedCommands(commands);

        // then
        assertTrue(underTest.hasCollided());
        assertEquals(underTest.getxPos(), 7);
        assertEquals(underTest.getyPos(), 5);
        assertEquals(underTest.getLastClearXPos(), 7);
        assertEquals(underTest.getLastClearYPos(), 6);

    }

    @Test
    public void shouldBeFacingSameDirectionAfter4Lefts() {
        // given
        final List<Obstacle> obstacles = Arrays.asList();
        final Grid grid = new Grid(10, 10, obstacles);
        final Direction direction = NORTH;
        final Turtle underTest = new Turtle(5, 2, direction, grid );
        final char[] commands = new char[]{'l', 'l', 'l', 'l'};

        // when
        underTest.feedCommands(commands);

        // then
        assertEquals(underTest.getDirection(), NORTH);
    }

    @Test
    public void shouldBeFacingSameDirectionAfter4Right() {
        // given
        final List<Obstacle> obstacles = Arrays.asList();
        final Grid grid = new Grid(10, 10, obstacles);
        final Direction direction = SOUTH;
        final Turtle underTest = new Turtle(5, 2, direction, grid );
        final char[] commands = new char[]{'r', 'r', 'r', 'r'};

        // when
        underTest.feedCommands(commands);

        // then
        assertEquals(underTest.getDirection(), SOUTH);
    }

    @Test
    public void shouldWrapVerticallyAroundGridWhenTravellingForwardAndFacingNorth() {
        // given
        final List<Obstacle> obstacles = Arrays.asList();
        final Grid grid = new Grid(10, 10, obstacles);
        final Direction direction = NORTH;
        final Turtle underTest = new Turtle(5, 2, direction, grid );
        final char[] commands = new char[]{'f', 'f', 'f', 'f', 'f'};

        // when
        underTest.feedCommands(commands);

        // then
        assertEquals(underTest.getxPos(), 5);
        assertEquals(underTest.getyPos(), 7);
    }

    @Test
    public void shouldWrapVerticallyAroundGridWhenTravellingForwardAndFacingSouth() {
        // given
        final List<Obstacle> obstacles = Arrays.asList();
        final Grid grid = new Grid(10, 10, obstacles);
        final Direction direction = SOUTH;
        final Turtle underTest = new Turtle(5, 8, direction, grid );
        final char[] commands = new char[]{'f', 'f', 'f', 'f', 'f'};

        // when
        underTest.feedCommands(commands);

        // then
        assertEquals(underTest.getxPos(), 5);
        assertEquals(underTest.getyPos(), 3);

    }

    @Test
    public void shouldWrapHorizontallyAroundGridWhenTravellingForwardAndFacingWest() {
        // given
        final List<Obstacle> obstacles = Arrays.asList();
        final Grid grid = new Grid(10, 10, obstacles);
        final Direction direction = WEST;
        final Turtle underTest = new Turtle(4, 7, direction, grid );
        final char[] commands = new char[]{'f', 'f', 'f', 'f', 'f'};

        // when
        underTest.feedCommands(commands);

        // then
        assertEquals(underTest.getxPos(), 9);
        assertEquals(underTest.getyPos(), 7);
    }

    @Test
    public void shouldWrapHorizontallyAroundGridWhenTravellingForwardAndFacingEast() {
        // given
        final List<Obstacle> obstacles = Arrays.asList();
        final Grid grid = new Grid(10, 10, obstacles);
        final Direction direction = EAST;
        final Turtle underTest = new Turtle(4, 7, direction, grid );
        final char[] commands = new char[]{'f', 'f', 'f', 'f', 'f', 'f', 'f'};

        // when
        underTest.feedCommands(commands);

        // then
        assertEquals(underTest.getxPos(), 1);
        assertEquals(underTest.getyPos(), 7);

    }

    @Test
    public void shouldWrapVerticallyAroundGridWhenTravellingBackwardAndFacingNorth() {
        // given
        final List<Obstacle> obstacles = Arrays.asList();
        final Grid grid = new Grid(10, 10, obstacles);
        final Direction direction = NORTH;
        final Turtle underTest = new Turtle(5, 2, direction, grid );
        final char[] commands = new char[]{'b', 'b', 'b', 'b', 'b'};

        // when
        underTest.feedCommands(commands);

        // then
        assertEquals(underTest.getxPos(), 5);
        assertEquals(underTest.getyPos(), 7);
    }

    @Test
    public void shouldWrapVerticallyAroundGridWhenTravellingBackwardAndFacingSouth() {
        // given
        final List<Obstacle> obstacles = Arrays.asList();
        final Grid grid = new Grid(10, 10, obstacles);
        final Direction direction = SOUTH;
        final Turtle underTest = new Turtle(5, 8, direction, grid );
        final char[] commands = new char[]{'b', 'b', 'b', 'b', 'b'};

        // when
        underTest.feedCommands(commands);

        // then
        assertEquals(underTest.getxPos(), 5);
        assertEquals(underTest.getyPos(), 3);

    }

    @Test
    public void shouldWrapHorizontallyAroundGridWhenTravellingBackwardAndFacingWest() {
        // given
        final List<Obstacle> obstacles = Arrays.asList();
        final Grid grid = new Grid(10, 10, obstacles);
        final Direction direction = WEST;
        final Turtle underTest = new Turtle(4, 7, direction, grid );
        final char[] commands = new char[]{'b', 'b', 'b', 'b', 'b', 'b', 'b'};

        // when
        underTest.feedCommands(commands);

        // then
        assertEquals(underTest.getxPos(), 1);
        assertEquals(underTest.getyPos(), 7);
    }

    @Test
    public void shouldWrapHorizontallyAroundGridWhenTravellingBackwardAndFacingEast() {
        // given
        final List<Obstacle> obstacles = Arrays.asList();
        final Grid grid = new Grid(10, 10, obstacles);
        final Direction direction = EAST;
        final Turtle underTest = new Turtle(5, 3, direction, grid );
        final char[] commands = new char[]{'b', 'b', 'b', 'b', 'b', 'b'};

        // when
        underTest.feedCommands(commands);

        // then
        assertEquals(underTest.getxPos(), 9);
        assertEquals(underTest.getyPos(), 3);

    }
}