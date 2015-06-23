package org.gemini.scala.labs

import math.sqrt

object MutualFractions extends App {

  def calculateFractions(number: Int): Seq[Int] = {
    def isFraction(x: Int) = number % x == 0
    val list = (2 to sqrt(number).toInt + 1).filter(isFraction)
    list union list.reverseMap(number / _)
  }

  def calculateMutualFractions(value: Int*): Seq[Int] = {
    value.map(calculateFractions).reduce(_ intersect _)
  }

  val start = System.currentTimeMillis()
  var counter = 0L

  while (System.currentTimeMillis() - start < 5000L) {
    calculateMutualFractions(2048, 1024)
    counter += 1
  }

  println(counter)

}
