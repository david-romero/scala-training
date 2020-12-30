package com.davromalc.scala.training

object P07 extends App {

  println(flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
  println(flatten2(List(List(1, 1), 2, List(3, List(5, 8)))))

  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case ms: List[_] => flatten(ms)
    case e => List(e)
  }

  def flatten2(ls: List[Any]): List[Any] = ls.foldLeft(List[Any]()){
    (list , next) => list ++ ( next match {
      case subList: List[_] => flatten2(subList)
      case element => List(element)
    })
  }
}
