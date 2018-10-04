# Mars Rover
Mars Rover Technical Challenge in Scala

=====================================

The next Mars Rover is being developed, and we need you to come up with a simple way of issuing navigation instructions to it from back on Earth!

#### Part 1: Basic Movement
1. The Mars Rover operates on a grid of arbitrary size.
2. You can only issue three commands: Move forward, rotate clockwise, and rotate anticlockwise.
3. If the rover moves off the grid, it reappears on the opposite side of the grid.

#### Part 2: Autopilot
1. Devise a simple process for determining the shortest possible path from one position on the grid to another.
2. Improve the solution so that it can avoid mountain ranges that occupy a number of inconvenient grid squares scattered around the map.

Part 3: Putting it all together
Output all the instructions and moves carried out by the rover to get from one grid square to another. The output can take any form e.g rows of text, JSON data, or something graphical.

## Solution
=====================================

#### Part 1: 
This is implemented in Navigator.scala The Navigator operates on an NxM size grid. A Rover with a location within the grid can then be issued commands to move Forward "F", roatate clockwise "C" or rotate anticlockwise "A".
A sequence of such commands can be issued via the followCommands function which accepts a String of commands and a Rover with an initial location and orientation.

e.g.a Rover initally located at (0,0) on a 10x10 Grid, when the commands String "FFFFFFCFFFFFFAFFFFFF" are passed to followCommands will produce a Rover with NORTH direction at Coordinate (6,2)  (The rover reappears at the other side of the grid if it goes beyond the grid boundaries)

#### Part 2:
1. This is implemented in the AutoPilot findShortestPathSimple method which calculates the ditance between 2 coordinates (x1, y1) and (x2, y2) as |x1-x2|+|y1-y2|
A second function findShortestPathRecursive attempts to calculate the shortest path recursively
2. To be completed

#### Part 3:
To be completed


#### To compile:

run command sbt
run command test

There is no main() (yet). Inputs and ouputs can be checked by modifying the NavigatorSpec and AutoPilotSpec files in the test folders

