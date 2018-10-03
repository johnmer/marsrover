package com.johnmer.mars

import org.scalatest.{FlatSpec, Matchers}

class NavigatorSpec extends FlatSpec with Matchers {

  behavior of "Navigator"

  val grid = Grid(10,10)

  val navigator = Navigator(grid)

  val rover = Rover(Coordinate(0,0),NORTH)

  val movedForwardRover = navigator.moveForward(rover)

  it must "return a Rover with NORTH direction and Coordinate (0,1) when move forward is called on Rover facing NORTH at (0,0)" in {
    movedForwardRover.direction should be (NORTH)
    movedForwardRover.coordinate should be (Coordinate(0,1))
  }

  val rotatedRover = navigator.rotateClockwise(rover)
  it must "return a Rover with EAST direction and Coordinate (0,0) when rotate clockwise is called on Rover facing NORTH at (0,0)" in {
    rotatedRover.direction should be (EAST)
    rotatedRover.coordinate should be (Coordinate(0,0))
  }

  val mixCommandedRover = navigator.followCommands("ffcffaffa",rover)
  it must "return a Rover with WEST direction and Coordinate (2,4) when the commands FFCFFAFFA are passed to a Rover facing NORTH at (0,0)" in {
    mixCommandedRover.direction should be (WEST)
    mixCommandedRover.coordinate should be (Coordinate(2,4))
  }

  val rotatedMultipleTimesRover = navigator.followCommands("AAA",rover)
  it must "return a Rover with EAST direction and Coordinate (0,0) when the commands AAA are passed to a Rover facing NORTH at (0,0)" in {
    rotatedMultipleTimesRover.direction should be (EAST)
    rotatedMultipleTimesRover.coordinate should be (Coordinate(0,0))
  }

  val roverMovesOffGrid = navigator.followCommands("FFFFFFCFFFFFFAFFFFFF",rover)
  it must "return a Rover with NORTH direction and Coordinate (6,2) when the commands FFFFFFCFFFFFFAFFFFFF are passed to a Rover initally located at (0,0) on a 10x10 Grid" in {
    roverMovesOffGrid.direction should be (NORTH)
    roverMovesOffGrid.coordinate should be (Coordinate(6,2))
  }

}
