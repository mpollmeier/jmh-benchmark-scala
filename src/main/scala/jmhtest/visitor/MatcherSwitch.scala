package jmhtest.visitor

import scala.annotation.switch

object MatcherSwitch2 {
  def foo(node: Node): String = (node.tpe: @switch) match {
    case 1 => "N1Foo"
    case 2 => "N2Foo"
  }
}
object MatcherSwitch3 {
  def foo(node: Node): String = (node.tpe: @switch) match {
    case 4 => "N4Foo"
    case 5 => "N5Foo"
    case 6 => "N6Foo"
  }
}
object MatcherSwitch5 {
  def foo(node: Node): String = (node.tpe: @switch) match {
    case 1 => "N1Foo"
    case 2 => "N2Foo"
    case 3 => "N3Foo"
    case 4 => "N4Foo"
    case 5 => "N5Foo"
  }
}
object MatcherSwitch10 {
  def foo(node: Node): String = (node.tpe: @switch) match {
    case 1 => "N1Foo"
    case 2 => "N2Foo"
    case 3 => "N3Foo"
    case 4 => "N4Foo"
    case 5 => "N5Foo"
    case 6 => "N6Foo"
    case 7 => "N7Foo"
    case 8 => "N8Foo"
    case 9 => "N9Foo"
    case 10 => "N10Foo"
  }
}
