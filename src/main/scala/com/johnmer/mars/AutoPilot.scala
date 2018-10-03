package com.johnmer.mars

case class AutoPilot(grid: Grid) {

  def findShortestPathSimple(startCoord: Coordinate, destCoord: Coordinate): Int = {
    Math.abs(startCoord.x - destCoord.x) + Math.abs(startCoord.y - destCoord.y)
  }

  def findSimpleShortestPathRecursive(startCoord: Coordinate, destCoord: Coordinate): Int = {

    if (startCoord == destCoord)
      0
    else if (startCoord.x < 0 || startCoord.x >= grid.xBound || startCoord.y < 0 || startCoord.y >= grid.yBound) {
      1000000000
    }
    else
    {
      (findSimpleShortestPathRecursive(Coordinate(startCoord.x + 1, startCoord.y), destCoord) min
        findSimpleShortestPathRecursive(Coordinate(startCoord.x, startCoord.y + 1), destCoord)
        ) + 1
    }
  }
}
