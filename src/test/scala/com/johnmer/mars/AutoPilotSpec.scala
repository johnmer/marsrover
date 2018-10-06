package com.johnmer.mars

import org.scalatest.{FlatSpec, Matchers}

class AutoPilotSpec extends FlatSpec with Matchers {

  behavior of "AutoPilot"

  val grid = Grid(10, 10)
  val autoPilot = AutoPilot(grid)

  val findShortestPathSimple = autoPilot.findShortestPathSimple(Coordinate(1,1), Coordinate(9,9));
  it must "return 16 when the positions are (1,1) and (9,9) using the basic shortest path calulation" in {
    findShortestPathSimple should be(16)
  }

  val findShortestPathSimpleReversed = autoPilot.findShortestPathSimple(Coordinate(9,9), Coordinate(1,1));
  it must "return 16 when the positions are (9,9) and (1,1) using the basic shortest path calulation" in {
    findShortestPathSimpleReversed should be(16)
  }

  val findShortestPathSameRecursive = autoPilot.findShortestPathRecursive(Coordinate(5,5), Coordinate(5,5));
  it must "return 0 when the two positions are the same using the recursive shortest path calulation" in {
    findShortestPathSameRecursive should be(0)
  }

  val findShortestPathDiffRecursive = autoPilot.findShortestPathRecursive(Coordinate(0, 0), Coordinate(4, 2));
  it must "find shortest path when starting coordinate (0,0) and destination coordinate(4,2) are different using the recursive shortest path calulation" in {
    findShortestPathDiffRecursive should be(6)
  }

  val findShortestSameX = autoPilot.findShortestPathRecursive(Coordinate(0, 0), Coordinate(0, 4));
  it must "find shortest path of length 4 when starting coordinate (0,0) and destination coordinate(0,4) have the same x value using the recursive shortest path calulation" in {
    findShortestSameX should be(4)
  }

  val findShortestSameY = autoPilot.findShortestPathRecursive(Coordinate(0, 0),  Coordinate(6, 0));
  it must "find shortest path of length 6 when starting coordinate (0,0) and destination coordinate(6,0) have the same y value using the recursive shortest path calulation" in {
    findShortestSameY should be(6)
  }


}