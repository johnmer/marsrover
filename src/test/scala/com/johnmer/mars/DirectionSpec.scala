package com.johnmer.mars

import org.scalatest.{FlatSpec, Matchers}

class DirectionSpec extends FlatSpec with Matchers {

  behavior of "Direction"

  val direction = NORTH

  it must "return EAST direction when NORTH is rotated clockwise" in {
    val expectedDirection = EAST
    direction.rotateClockWise should be (expectedDirection)
  }

  it must "return WEST direction when NORTH is rotated anticlockwise" in {
    val expectedDirection = WEST
    direction.rotateAntiClockWise should be (expectedDirection)
  }

}
