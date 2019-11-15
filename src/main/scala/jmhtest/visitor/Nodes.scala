package jmhtest.visitor

trait Node {
  def tpe: Int
  def accept[T](visitor: NodeVisitor[T]): T = ???
}

trait NodeVisitor[T] {
  def visit(n: N1): T = ???
  def visit(n: N2): T = ???
  def visit(n: N3): T = ???
  def visit(n: N4): T = ???
  def visit(n: N5): T = ???
  def visit(n: N6): T = ???
  def visit(n: N7): T = ???
  def visit(n: N8): T = ???
  def visit(n: N9): T = ???
  def visit(n: N10): T = ???
  def visit(n: N11): T = ???
  def visit(n: N12): T = ???
  def visit(n: N13): T = ???
  def visit(n: N14): T = ???
  def visit(n: N15): T = ???
  def visit(n: N16): T = ???
  def visit(n: N17): T = ???
  def visit(n: N18): T = ???
  def visit(n: N19): T = ???
  def visit(n: N20): T = ???
}

class N1 extends Node {
  override final def tpe = 1
  val foo1 = "N1"
  final override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N2 extends Node {
  override final def tpe = 2
  val foo2 = "N2"
  final override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N3 extends Node {
  override final def tpe = 3
  val foo3 = "N3"
  final override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N4 extends Node {
  override final def tpe = 4
  val foo4 = "N4"
  final override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N5 extends Node {
  override final def tpe = 5
  val foo5 = "N5"
  final override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N6 extends Node {
  override final def tpe = 6
  val foo6 = "N6"
  final override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N7 extends Node {
  override final def tpe = 7
  val foo7 = "N7"
  final override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N8 extends Node {
  override final def tpe = 8
  val foo8 = "N8"
  final override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N9 extends Node {
  override final def tpe = 9
  val foo9 = "N9"
  final override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N10 extends Node {
  override final def tpe = 10
  val foo10 = "N10"
  final override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N11 extends Node {
  override final def tpe = 11
  val foo11 = "N11"
  final override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N12 extends Node {
  override final def tpe = 12
  val foo12 = "N12"
  final override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N13 extends Node {
  override final def tpe = 13
  val foo13 = "N13"
  final override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N14 extends Node {
  override final def tpe = 14
  val foo14 = "N14"
  final override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N15 extends Node {
  override final def tpe = 15
  val foo15 = "N15"
  final override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N16 extends Node {
  override final def tpe = 16
  val foo16 = "N16"
  final override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N17 extends Node {
  override final def tpe = 17
  val foo17 = "N17"
  final override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N18 extends Node {
  override final def tpe = 18
  val foo18 = "N18"
  final override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N19 extends Node {
  override final def tpe = 19
  val foo19 = "N19"
  final override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N20 extends Node {
  override final def tpe = 20
  val foo20 = "N20"
  final override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}
