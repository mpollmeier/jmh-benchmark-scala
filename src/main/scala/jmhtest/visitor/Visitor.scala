package jmhtest.visitor

import org.openjdk.jmh.annotations._

object Visitor1 extends NodeVisitor[String] {
  override def visit(n: N1): String = n.foo1
}
object Visitor2 extends NodeVisitor[String] {
  override def visit(n: N1): String = n.foo1
  override def visit(n: N2): String = n.foo2
}
object Visitor3 extends NodeVisitor[String] {
  override def visit(n: N1): String = n.foo1
  override def visit(n: N2): String = n.foo2
  override def visit(n: N3): String = n.foo3
}
object Visitor5 extends NodeVisitor[String] {
  override def visit(n: N1): String = n.foo1
  override def visit(n: N2): String = n.foo2
  override def visit(n: N3): String = n.foo3
  override def visit(n: N4): String = n.foo4
  override def visit(n: N5): String = n.foo5
}
object Visitor10 extends NodeVisitor[String] {
  override def visit(n: N1): String = n.foo1
  override def visit(n: N2): String = n.foo2
  override def visit(n: N3): String = n.foo3
  override def visit(n: N4): String = n.foo4
  override def visit(n: N5): String = n.foo5
  override def visit(n: N6): String = n.foo6
  override def visit(n: N7): String = n.foo7
  override def visit(n: N8): String = n.foo8
  override def visit(n: N9): String = n.foo9
  override def visit(n: N10): String = n.foo10
}
object Visitor20 extends NodeVisitor[String] {
  override def visit(n: N1): String = n.foo1
  override def visit(n: N2): String = n.foo2
  override def visit(n: N3): String = n.foo3
  override def visit(n: N4): String = n.foo4
  override def visit(n: N5): String = n.foo5
  override def visit(n: N6): String = n.foo6
  override def visit(n: N7): String = n.foo7
  override def visit(n: N8): String = n.foo8
  override def visit(n: N9): String = n.foo9
  override def visit(n: N10): String = n.foo10
  override def visit(n: N11): String = n.foo11
  override def visit(n: N12): String = n.foo12
  override def visit(n: N13): String = n.foo13
  override def visit(n: N14): String = n.foo14
  override def visit(n: N15): String = n.foo15
  override def visit(n: N16): String = n.foo16
  override def visit(n: N17): String = n.foo17
  override def visit(n: N18): String = n.foo18
  override def visit(n: N19): String = n.foo19
  override def visit(n: N20): String = n.foo20
}
