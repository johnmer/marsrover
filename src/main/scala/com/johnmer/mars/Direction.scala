package com.johnmer.mars

sealed trait Direction {

  def rotateClockWise:Direction
  def rotateAntiClockWise:Direction
}

case object NORTH extends Direction{
  def rotateClockWise:Direction = EAST
  def rotateAntiClockWise:Direction = WEST
}

case object EAST extends Direction{
  def rotateClockWise:Direction = SOUTH
  def rotateAntiClockWise:Direction = NORTH
}

case object SOUTH extends Direction{
  def rotateClockWise:Direction = WEST
  def rotateAntiClockWise:Direction = EAST
}

case object WEST extends Direction{
  def rotateClockWise:Direction = NORTH
  def rotateAntiClockWise:Direction = SOUTH
}
