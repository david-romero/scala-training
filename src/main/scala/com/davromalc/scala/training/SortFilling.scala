package com.davromalc.scala.training

object SortFilling extends App {

  val cond: (Int, Int) => Boolean = (a , b) => b > a

  def insert(x: Int, xs: List[Int]): List[Int] =
    xs match {
      case List() => x :: Nil

      case y :: ys =>
        if (cond(x, y)) x :: y :: ys
        else y :: insert(x, ys)
    }
  println(insert(2, 1 :: 3 :: Nil))
  println(insert(1, 2 :: 3 :: Nil))
  println(insert(3, 1 :: 2 :: Nil))

}
