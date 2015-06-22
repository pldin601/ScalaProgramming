package org.gemini.scala.labs

import math.sqrt

object MutualFractions extends App {

  def calculateFractions(number: Int): Seq[Int] = {
    val list = (2 to sqrt(number).toInt + 1).filter(
      number % _ == 0)
    list union list.map(number / _)
  }

  def calculateMutualFractions(value: Int*): Seq[Int] = {
    value.map(calculateFractions).reduce(
      _ intersect _).sorted
  }

  println(calculateMutualFractions(512, 256, 1024))

}
