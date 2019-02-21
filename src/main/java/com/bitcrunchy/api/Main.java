package com.bitcrunchy.api;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){

        // please play around with the positioning of these obstacles to find collisions occurring.
        Obstacle ob1 = new Obstacle(3, 4);
        Obstacle ob2 = new Obstacle(4, 3);
        Obstacle ob3 = new Obstacle(8, 8);

        Grid grid = new Grid(10, 10, Arrays.asList(ob1, ob2, ob3));

        Turtle rover = new Turtle(3, 3, Direction.WEST, grid);

        rover.feedCommands(new char[]{'f', 'f', 'f', 'f', 'f', 'f'});


//        rover.feedCommands(new char[]{'f', 'r', 'f', 'r', 'f', 'l', 'f', 'r', 'f', 'b', 'l', 'r'});
    }
}
