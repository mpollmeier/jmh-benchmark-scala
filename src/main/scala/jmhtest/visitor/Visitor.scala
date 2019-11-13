package jmhtest.visitor

import org.openjdk.jmh.annotations._

object Visitor1 extends NodeVisitor[String] {
  final override def visit(n: N1): String = n.foo1
}
object Visitor2 extends NodeVisitor[String] {
  final override def visit(n: N1): String = n.foo1
  final override def visit(n: N2): String = n.foo2
}
object Visitor2a extends NodeVisitor[String] {
  final override def visit(n: N1): String = n.foo1
  final override def visit(n: N2): String = n.foo2
  final override def visit(n: N10): String = n.foo10
  final override def visit(n: N11): String = n.foo11
}
object Visitor3 extends NodeVisitor[String] {
  final override def visit(n: N4): String = n.foo4
  final override def visit(n: N5): String = n.foo5
  final override def visit(n: N6): String = n.foo6
}
object Visitor5 extends NodeVisitor[String] {
  final override def visit(n: N1): String = n.foo1
  final override def visit(n: N2): String = n.foo2
  final override def visit(n: N3): String = n.foo3
  final override def visit(n: N4): String = n.foo4
  final override def visit(n: N5): String = n.foo5
}
object Visitor10 extends NodeVisitor[String] {
  final override def visit(n: N1): String = n.foo1
  final override def visit(n: N2): String = n.foo2
  final override def visit(n: N3): String = n.foo3
  final override def visit(n: N4): String = n.foo4
  final override def visit(n: N5): String = n.foo5
  final override def visit(n: N6): String = n.foo6
  final override def visit(n: N7): String = n.foo7
  final override def visit(n: N8): String = n.foo8
  final override def visit(n: N9): String = n.foo9
  final override def visit(n: N10): String = n.foo10
}
object Visitor20 extends NodeVisitor[String] {
  final override def visit(n: N1): String = n.foo1
  final override def visit(n: N2): String = n.foo2
  final override def visit(n: N3): String = n.foo3
  final override def visit(n: N4): String = n.foo4
  final override def visit(n: N5): String = n.foo5
  final override def visit(n: N6): String = n.foo6
  final override def visit(n: N7): String = n.foo7
  final override def visit(n: N8): String = n.foo8
  final override def visit(n: N9): String = n.foo9
  final override def visit(n: N10): String = n.foo10
  final override def visit(n: N11): String = n.foo11
  final override def visit(n: N12): String = n.foo12
  final override def visit(n: N13): String = n.foo13
  final override def visit(n: N14): String = n.foo14
  final override def visit(n: N15): String = n.foo15
  final override def visit(n: N16): String = n.foo16
  final override def visit(n: N17): String = n.foo17
  final override def visit(n: N18): String = n.foo18
  final override def visit(n: N19): String = n.foo19
  final override def visit(n: N20): String = n.foo20
}
