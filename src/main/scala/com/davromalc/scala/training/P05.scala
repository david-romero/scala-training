package com.davromalc.scala.training

import scala.::

object P05 extends App {

  println(reverse(List(1, 1, 2, 3, 5, 8)))
  println(reverseFunctional(List(1, 1, 2, 3, 5, 8)))

  def reverse[U](list: List[U]): List[U] = list match {
    case h :: tail => reverse(tail) ++ List(h)
    case Nil => List()
  }

  def reverseFunctional[U](list: List[U]): List[U] = list.foldLeft( List[U]()){
    (cumulativeList, nextElement) =>   List(nextElement) ++ cumulativeList
  }


}
