package com.davromalc.scala.training

import scala.::

object P08 extends App {

  println(compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  println(compress2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  println(compress3(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  println(compressFunctional(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))

  def compress[U](ls: List[U]): List[U] = ls.distinct

  def compress2[U](ls: List[U]): List[U] = ls.foldLeft(List[U]()){
    (list , next) => if (list.contains(next)) list else list ++ List(next)
  }

  def compress3[U](ls: List[U]): List[U] = ls match {
    case Nil       => Nil
    case h :: tail => h :: compress3(tail.dropWhile(_ == h))
  }

  // Functional.
  def compressFunctional[A](ls: List[A]): List[A] =
    ls.foldRight(List[A]()) { (h, r) =>
      if (r.isEmpty || r.head != h) h :: r
      else r
    }

}
