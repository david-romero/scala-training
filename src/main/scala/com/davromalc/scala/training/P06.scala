package com.davromalc.scala.training

object P06 extends App {

  println(isPalindrome(List(1, 2, 3, 2, 1)))

  def isPalindrome[U](list: List[U]): Boolean = list == list.reverse
}
