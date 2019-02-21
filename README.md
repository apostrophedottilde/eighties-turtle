# eighties-turtle #

A basic turtle type like the ones from the eighties.

Provide a sequence of commands and a grid to traverse and the turtle will follow your commands step-by-step.

Available commands are:

- 'f' - move forward one square
- 'b' - move backward one square
- 'l' - turn left 90 degrees
- 'r' - turn right 90 degrees

You need to pass an array of commands and watch the turtles follow. At each step the turtle's location and orientation will be pinted to the console.

An array of Obstacles is also provided and if the turtle would collide with one then it will perform all its commands up until just before the collision at which point the turtles final valid state is displayed along with an indication of where the collision was due to occur.