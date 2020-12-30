package com.davromalc.scala.training

object P01 extends App {

  println(last(List(1, 1, 2, 3, 5, 8)))

  def last[U](list: List[U]): U = list match {
    case h :: Nil => h
    case _ :: tail => last(tail)
    case _ => throw new UnsupportedOperationException()
  }

}
