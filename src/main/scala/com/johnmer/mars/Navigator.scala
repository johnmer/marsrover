package com.johnmer.mars

import scala.annotation.tailrec

case class Navigator(grid: Grid) {

  val mapOfCommands = Map[Char, Rover => Rover]('F' -> moveForward, 'C' -> rotateClockwise, 'A' -> rotateAntiClockwise)

  @tailrec
  final def followCommands(commands: String, rover: Rover): Rover = {
    commands.length match {
      case 0 => rover
      case _ => followCommands(commands.tail, mapOfCommands.get(commands.head.toUpper).get(rover))
    }
  }

  def moveForward(rover: Rover): Rover = rover.direction match {

    case NORTH => Rover(Coordinate(rover.coordinate.x, yOffGridCheck(rover.coordinate.y + 1)), rover.direction)
    case EAST => Rover(Coordinate(xOffGridCheck(rover.coordinate.x + 1), rover.coordinate.y), rover.direction)
    case SOUTH => Rover(Coordinate(rover.coordinate.x, yOffGridCheck(rover.coordinate.y - 1)), rover.direction)
    case WEST => Rover(Coordinate(xOffGridCheck(rover.coordinate.x - 1), rover.coordinate.y), rover.direction)

  }

  def rotateClockwise(rover: Rover) = Rover(rover.coordinate, rover.direction.rotateClockWise)

  def rotateAntiClockwise(rover: Rover) = Rover(rover.coordinate, rover.direction.rotateAntiClockWise)

  def yOffGridCheck(y: Int): Int = {
    if (y < 0) {
      grid.yBound - 1
    }
    else if (y == grid.yBound) {
      0
    }
    else
      y
  }

  def xOffGridCheck(x: Int): Int = {
    if (x < 0) {
      grid.xBound - 1
    }
    else if
    (x == grid.xBound) {
      0
    }
    else
      x
  }

}
