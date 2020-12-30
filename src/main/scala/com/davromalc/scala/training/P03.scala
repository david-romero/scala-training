package com.davromalc.scala.training

object P03 extends App {

  println(nth(2, List(1, 1, 2, 3, 5, 8)))

  def nth[U](index: Int, list: List[U]): U = (index , list) match {
    case (0, h :: _) => h
    case (n, _ :: tail) => nth(n - 1, tail)
    case (_ , Nil) => throw new NoSuchElementException()
  }

}
