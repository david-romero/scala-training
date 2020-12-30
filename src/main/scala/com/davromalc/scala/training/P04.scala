package com.davromalc.scala.training

object P04 extends App {

  println(length(List(1, 1, 2, 3, 5, 8)))
  println(lengthTailRecursive(List(1, 1, 2, 3, 5, 8)))
  println(lengthFunctional(List(1, 1, 2, 3, 5, 8)))

  def length[U](list: List[U]): Int = list match {
      case _ :: tail => 1 + length(tail)
      case Nil => 0
  }

  // Tail recursive solution.  Theoretically more efficient; with tail-call
  // elimination in the compiler, this would run in constant space.
  // Unfortunately, the JVM doesn't do tail-call elimination in the general
  // case.  Scala *will* do it if the method is either final or is a local
  // function.  In this case, `lengthR` is a local function, so it should
  // be properly optimized.
  // For more information, see
  // http://blog.richdougherty.com/2009/04/tail-calls-tailrec-and-trampolines.html
  def lengthTailRecursive[A](ls: List[A]): Int = {
    def lengthR(result: Int, curList: List[A]): Int = curList match {
      case Nil       => result
      case _ :: tail => lengthR(result + 1, tail)
    }
    lengthR(0, ls)
  }

  // More pure functional solution, with folds.
  def lengthFunctional[A](ls: List[A]): Int = ls.foldLeft(0) { (c, _) => c + 1 }

}
