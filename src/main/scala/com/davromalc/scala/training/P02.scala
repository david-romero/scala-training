package com.davromalc.scala.training

object P02 extends App {

  println(penultimate(List(1, 1, 2, 3, 5, 8)))

  def penultimate[U](list: List[U]): U = list match {
    case h :: _ :: Nil => h
    case _ :: tail => penultimate(tail)
    case _ => throw new UnsupportedOperationException()
  }

  def lastNthRecursive[A](n: Int, ls: List[A]): A = {
    def lastNthR(count: Int, resultList: List[A], curList: List[A]): A =
      curList match {
        case Nil if count > 0 => throw new NoSuchElementException
        case Nil              => resultList.head
        case _ :: tail        =>
          lastNthR(count - 1,
            if (count > 0) resultList else resultList.tail,
            tail)
      }
    if (n <= 0) throw new IllegalArgumentException
    else lastNthR(n, ls, ls)
  }

}
