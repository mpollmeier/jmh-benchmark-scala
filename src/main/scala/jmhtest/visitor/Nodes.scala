package jmhtest.visitor

trait Node {
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
  val foo1 = "N1"
  override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N2 extends Node {
  val foo2 = "N2"
  override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N3 extends Node {
  val foo3 = "N3"
  override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N4 extends Node {
  val foo4 = "N4"
  override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N5 extends Node {
  val foo5 = "N5"
  override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N6 extends Node {
  val foo6 = "N6"
  override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N7 extends Node {
  val foo7 = "N7"
  override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N8 extends Node {
  val foo8 = "N8"
  override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N9 extends Node {
  val foo9 = "N9"
  override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N10 extends Node {
  val foo10 = "N10"
  override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N11 extends Node {
  val foo11 = "N11"
  override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N12 extends Node {
  val foo12 = "N12"
  override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N13 extends Node {
  val foo13 = "N13"
  override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N14 extends Node {
  val foo14 = "N14"
  override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N15 extends Node {
  val foo15 = "N15"
  override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N16 extends Node {
  val foo16 = "N16"
  override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N17 extends Node {
  val foo17 = "N17"
  override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N18 extends Node {
  val foo18 = "N18"
  override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N19 extends Node {
  val foo19 = "N19"
  override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}

class N20 extends Node {
  val foo20 = "N20"
  override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
}
