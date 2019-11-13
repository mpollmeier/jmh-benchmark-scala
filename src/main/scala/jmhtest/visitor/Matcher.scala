package jmhtest.visitor

object Matcher2 {
  def foo(node: Node): String = node match {
    case node: N1 => node.foo1
    case node: N2 => node.foo2
  }
}
object Matcher3 {
  def foo(node: Node): String = node match {
    case node: N1 => node.foo1
    case node: N2 => node.foo2
    case node: N3 => node.foo3
  }
}
object Matcher5 {
  def foo(node: Node): String = node match {
    case node: N1 => node.foo1
    case node: N2 => node.foo2
    case node: N3 => node.foo3
    case node: N4 => node.foo4
    case node: N5 => node.foo5
  }
}
object Matcher10 {
  def foo(node: Node): String = node match {
    case node: N1 => node.foo1
    case node: N2 => node.foo2
    case node: N3 => node.foo3
    case node: N4 => node.foo4
    case node: N5 => node.foo5
    case node: N6 => node.foo6
    case node: N7 => node.foo7
    case node: N8 => node.foo8
    case node: N9 => node.foo9
    case node: N10 => node.foo10
  }
}
object Matcher20 {
  def foo(node: Node): String = node match {
    case node: N1 => node.foo1
    case node: N2 => node.foo2
    case node: N3 => node.foo3
    case node: N4 => node.foo4
    case node: N5 => node.foo5
    case node: N6 => node.foo6
    case node: N7 => node.foo7
    case node: N8 => node.foo8
    case node: N9 => node.foo9
    case node: N10 => node.foo10
    case node: N11 => node.foo11
    case node: N12 => node.foo12
    case node: N13 => node.foo13
    case node: N14 => node.foo14
    case node: N15 => node.foo15
    case node: N16 => node.foo16
    case node: N17 => node.foo17
    case node: N18 => node.foo18
    case node: N19 => node.foo19
    case node: N20 => node.foo20
  }
}
