package jmhtest.visitor

import scala.annotation.switch

object MatcherSwitch2 {
  def foo(node: Node): String = (node.tpe: @switch) match {
    case 1 => node.asInstanceOf[N1].foo1
    case 2 => node.asInstanceOf[N2].foo2
  }
}
object MatcherSwitch3 {
  def foo(node: Node): String = (node.tpe: @switch) match {
    case 4 => node.asInstanceOf[N4].foo4
    case 5 => node.asInstanceOf[N5].foo5
    case 6 => node.asInstanceOf[N6].foo6
  }
}
object MatcherSwitch5 {
  def foo(node: Node): String = (node.tpe: @switch) match {
    case 1 => node.asInstanceOf[N1].foo1
    case 2 => node.asInstanceOf[N2].foo2
    case 3 => node.asInstanceOf[N3].foo3
    case 4 => node.asInstanceOf[N4].foo4
    case 5 => node.asInstanceOf[N5].foo5
  }
}
object MatcherSwitch10 {
  def foo(node: Node): String = (node.tpe: @switch) match {
    case 1 => node.asInstanceOf[N1].foo1
    case 2 => node.asInstanceOf[N2].foo2
    case 3 => node.asInstanceOf[N3].foo3
    case 4 => node.asInstanceOf[N4].foo4
    case 5 => node.asInstanceOf[N5].foo5
    case 6 => node.asInstanceOf[N6].foo6
    case 7 => node.asInstanceOf[N7].foo7
    case 8 => node.asInstanceOf[N8].foo8
    case 9 => node.asInstanceOf[N9].foo9
    case 10 => node.asInstanceOf[N10].foo10
  }
}
