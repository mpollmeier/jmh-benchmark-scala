package jmhtest.visitor

import org.openjdk.jmh.annotations._

object VisitorApp extends App {
  val v = new VisitorVsMatch

  var i = 0
  while (i < 10000000) {
    if (i % 100000 == 0) println(i)
    v.visitor20
    i += 1
  }
}

object MatcherApp extends App {
  val v = new VisitorVsMatch

  var i = 0
  while (i < 10000000) {
    if (i % 100000 == 0) println(i)
    v.matcher20
    i += 1
  }
}

/**
*/
@Warmup(iterations = 20)
@Measurement(iterations = 100)
// @Warmup(iterations = 2)
// @Measurement(iterations = 10)
@State(Scope.Benchmark)
class VisitorVsMatch {
  import Nodes._
  val Iterations = 1000

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def matcher2: Unit = {
    val iter = infiniteNodeIterator(2)
    1.to(Iterations).foreach(_ =>
      Matcher2.foo(iter.next)
    )
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def visitor2: Unit = {
    val iter = infiniteNodeIterator(2)
    1.to(Iterations).foreach(_ =>
      iter.next.accept(Visitor2)
    )
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def matcher3: Unit = {
    val iter = infiniteNodeIterator(3)
    1.to(Iterations).foreach(_ =>
      Matcher3.foo(iter.next)
    )
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def visitor3: Unit = {
    val iter = infiniteNodeIterator(3)
    1.to(Iterations).foreach(_ =>
      iter.next.accept(Visitor3)
    )
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def matcher5: Unit = {
    val iter = infiniteNodeIterator(5)
    1.to(Iterations).foreach(_ =>
      Matcher5.foo(iter.next)
    )
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def visitor5: Unit = {
    val iter = infiniteNodeIterator(5)
    1.to(Iterations).foreach(_ =>
      iter.next.accept(Visitor5)
    )
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def matcher10: Unit = {
    val iter = infiniteNodeIterator(10)
    1.to(Iterations).foreach(_ =>
      Matcher10.foo(iter.next)
    )
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def visitor10: Unit = {
    val iter = infiniteNodeIterator(10)
    1.to(Iterations).foreach(_ =>
      iter.next.accept(Visitor10)
    )
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def matcher20: Unit = {
    val iter = infiniteNodeIterator(20)
    1.to(Iterations).foreach(_ =>
      Matcher20.foo(iter.next)
    )
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def visitor20: Unit = {
    val iter = infiniteNodeIterator(20)
    1.to(Iterations).foreach(_ =>
      iter.next.accept(Visitor20)
    )
  }

  def infiniteNodeIterator(nodeCount: Int) = new java.util.Iterator[Node] {
    val nodes: Array[Node] = Array(
      new N1,
      new N2,
      new N3,
      new N4,
      new N5,
      new N6,
      new N7,
      new N8,
      new N9,
      new N10,
      new N11,
      new N12,
      new N13,
      new N14,
      new N15,
      new N16,
      new N17,
      new N18,
      new N19,
      new N20
    )
    var i = 0
    def hasNext(): Boolean = true
    def next(): Node = {
      val node = nodes(i)
      i += 1
      if (i == nodeCount) i = 0
      node
    }
  }

}

object Nodes {
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

  object Visitor2 extends NodeVisitor[String] {
    override def visit(n: N1): String = n.foo1
    override def visit(n: N2): String = n.foo2
  }
  object Visitor3 extends NodeVisitor[String] {
    override def visit(n: N1): String = n.foo1
    override def visit(n: N2): String = n.foo2
    override def visit(n: N3): String = n.foo3
  }
  object Visitor3Java extends NodeVisitorJava[String] {
    override def visit(n: N1): String = n.foo1
    override def visit(n: N2): String = n.foo2
    override def visit(n: N3): String = n.foo3

    override def visit(n: N4): String = ???

    override def visit(n: N5): String = ???

    override def visit(n: N6): String = ???

    override def visit(n: N7): String = ???

    override def visit(n: N8): String = ???

    override def visit(n: N9): String = ???

    override def visit(n: N10): String = ???

    override def visit(n: N11): String = ???

    override def visit(n: N12): String = ???

    override def visit(n: N13): String = ???

    override def visit(n: N14): String = ???

    override def visit(n: N15): String = ???

    override def visit(n: N16): String = ???

    override def visit(n: N17): String = ???

    override def visit(n: N18): String = ???

    override def visit(n: N19): String = ???

    override def visit(n: N20): String = ???
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
}
