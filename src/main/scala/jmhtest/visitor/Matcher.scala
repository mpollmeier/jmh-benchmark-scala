package jmhtest.visitor

object Matcher2 {
  def foo(node: Node): String = node match {
    case node: N1 => "N1Foo"
    case node: N2 => "N2Foo"
  }
}
object Matcher3 {
  def foo(node: Node): String = node match {
    case node: N1 => "N1Foo"
    case node: N2 => "N2Foo"
    case node: N3 => "N3Foo"
  }
}
object Matcher5 {
  def foo(node: Node): String = node match {
    case node: N1 => "N1Foo"
    case node: N2 => "N2Foo"
    case node: N3 => "N3Foo"
    case node: N4 => "N4Foo"
    case node: N5 => "N5Foo"
  }
}
object Matcher10 {
  def foo(node: Node): String = node match {
    case node: N1 => "N1Foo"
    case node: N2 => "N2Foo"
    case node: N3 => "N3Foo"
    case node: N4 => "N4Foo"
    case node: N5 => "N5Foo"
    case node: N6 => "N6Foo"
    case node: N7 => "N7Foo"
    case node: N8 => "N8Foo"
    case node: N9 => "N9Foo"
    case node: N10 => "N10Foo"
  }
}
object Matcher20 {
  def foo(node: Node): String = node match {
    case node: N1 => "N1Foo"
    case node: N2 => "N2Foo"
    case node: N3 => "N3Foo"
    case node: N4 => "N4Foo"
    case node: N5 => "N5Foo"
    case node: N6 => "N6Foo"
    case node: N7 => "N7Foo"
    case node: N8 => "N8Foo"
    case node: N9 => "N9Foo"
    case node: N10 => "N10Foo"
    case node: N11 => "N11Foo"
    case node: N12 => "N12Foo"
    case node: N13 => "N13Foo"
    case node: N14 => "N14Foo"
    case node: N15 => "N15Foo"
    case node: N16 => "N16Foo"
    case node: N17 => "N17Foo"
    case node: N18 => "N18Foo"
    case node: N19 => "N19Foo"
    case node: N20 => "N20Foo"
  }
}
