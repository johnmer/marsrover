package com.johnmer.mars

import org.scalatest.{FlatSpec, Matchers}

class RoverSpec extends FlatSpec with Matchers {

  behavior of "Rover"

  val roverCoordinate = Coordinate(1,3)
  val roverDirection = NORTH
  val rover = Rover(roverCoordinate,roverDirection)

  it must "have NORTH direction and Coordinate (1,3)" in {
    rover.direction should be (NORTH)
    rover.coordinate should be (Coordinate(1,3))
  }
}
