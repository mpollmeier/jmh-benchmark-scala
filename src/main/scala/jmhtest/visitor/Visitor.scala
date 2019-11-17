package jmhtest.visitor

import org.openjdk.jmh.annotations._

object Visitor1 extends NodeVisitor[String] {
  final override def visit(n: N1): String = "N1Foo"
}
object Visitor2 extends NodeVisitor[String] {
  final override def visit(n: N1): String = "N1Foo"
  final override def visit(n: N2): String = "N2Foo"
}
object Visitor2a extends NodeVisitor[String] {
  final override def visit(n: N1): String = "N1Foo"
  final override def visit(n: N2): String = "N2Foo"
  final override def visit(n: N10): String = "N10Foo"
  final override def visit(n: N11): String = "N11Foo"
}
// object Visitor3 extends NodeVisitor[String] {
//   final override def visit(n: N1): String = "N1Foo"
//   final override def visit(n: N2): String = "N2Foo"
//   final override def visit(n: N3): String = "N3Foo"
// }
object Visitor3 extends NodeVisitor[String] {
  final override def visit(n: N4): String = "N4Foo"
  final override def visit(n: N5): String = "N5Foo"
  final override def visit(n: N6): String = "N6Foo"
}
object Visitor5 extends NodeVisitor[String] {
  final override def visit(n: N1): String = "N1Foo"
  final override def visit(n: N2): String = "N2Foo"
  final override def visit(n: N3): String = "N3Foo"
  final override def visit(n: N4): String = "N4Foo"
  final override def visit(n: N5): String = "N5Foo"
}
object Visitor10 extends NodeVisitor[String] {
  final override def visit(n: N1): String = "N1Foo"
  final override def visit(n: N2): String = "N2Foo"
  final override def visit(n: N3): String = "N3Foo"
  final override def visit(n: N4): String = "N4Foo"
  final override def visit(n: N5): String = "N5Foo"
  final override def visit(n: N6): String = "N6Foo"
  final override def visit(n: N7): String = "N7Foo"
  final override def visit(n: N8): String = "N8Foo"
  final override def visit(n: N9): String = "N9Foo"
  final override def visit(n: N10): String = "N10Foo"
}
object Visitor20 extends NodeVisitor[String] {
  final override def visit(n: N1): String = "N1Foo"
  final override def visit(n: N2): String = "N2Foo"
  final override def visit(n: N3): String = "N3Foo"
  final override def visit(n: N4): String = "N4Foo"
  final override def visit(n: N5): String = "N5Foo"
  final override def visit(n: N6): String = "N6Foo"
  final override def visit(n: N7): String = "N7Foo"
  final override def visit(n: N8): String = "N8Foo"
  final override def visit(n: N9): String = "N9Foo"
  final override def visit(n: N10): String = "N10Foo"
  final override def visit(n: N11): String = "N11Foo"
  final override def visit(n: N12): String = "N12Foo"
  final override def visit(n: N13): String = "N13Foo"
  final override def visit(n: N14): String = "N14Foo"
  final override def visit(n: N15): String = "N15Foo"
  final override def visit(n: N16): String = "N16Foo"
  final override def visit(n: N17): String = "N17Foo"
  final override def visit(n: N18): String = "N18Foo"
  final override def visit(n: N19): String = "N19Foo"
  final override def visit(n: N20): String = "N20Foo"
}
