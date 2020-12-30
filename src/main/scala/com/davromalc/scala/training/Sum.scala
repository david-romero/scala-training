package com.davromalc.scala.training

object Sum extends App {

  println(sum(x => x, 1, 10))

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(x: Int, acc: Int): Int =
      if (x > b) acc
      else loop(x + 1, acc + f(x))

    loop(a, 0)
  }

}
