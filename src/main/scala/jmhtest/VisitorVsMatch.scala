package jmhtest.visitor

import java.util.concurrent.TimeUnit
import org.openjdk.jmh.annotations._

/**
*/
// @Warmup(iterations = 20)
// @Measurement(iterations = 100)
@Warmup(iterations = 2)
@Measurement(iterations = 10)
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
      NodeFooMatcher2.foo(iter.next)
    )
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def visitor2: Unit = {
    val iter = infiniteNodeIterator(2)
    1.to(Iterations).foreach(_ =>
      iter.next.accept(NodeFooVisitor2)
    )
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def matcher3: Unit = {
    val iter = infiniteNodeIterator(3)
    1.to(Iterations).foreach(_ =>
      NodeFooMatcher3.foo(iter.next)
    )
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def visitor3: Unit = {
    val iter = infiniteNodeIterator(3)
    1.to(Iterations).foreach(_ =>
      iter.next.accept(NodeFooVisitor3)
    )
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def matcher5: Unit = {
    val iter = infiniteNodeIterator(5)
    1.to(Iterations).foreach(_ =>
      NodeFooMatcher5.foo(iter.next)
    )
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def visitor5: Unit = {
    val iter = infiniteNodeIterator(5)
    1.to(Iterations).foreach(_ =>
      iter.next.accept(NodeFooVisitor5)
    )
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def matcher10: Unit = {
    val iter = infiniteNodeIterator(10)
    1.to(Iterations).foreach(_ =>
      NodeFooMatcher10.foo(iter.next)
    )
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def visitor10: Unit = {
    val iter = infiniteNodeIterator(10)
    1.to(Iterations).foreach(_ =>
      iter.next.accept(NodeFooVisitor10)
    )
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def matcher20: Unit = {
    val iter = infiniteNodeIterator(20)
    1.to(Iterations).foreach(_ =>
      NodeFooMatcher20.foo(iter.next)
    )
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def visitor20: Unit = {
    val iter = infiniteNodeIterator(20)
    1.to(Iterations).foreach(_ =>
      iter.next.accept(NodeFooVisitor20)
    )
  }

  def infiniteNodeIterator(nodeCount: Int) = new java.util.Iterator[Node] {
    val nodes: List[Node] = List(
      new SampleNode1,
      new SampleNode2,
      new SampleNode3,
      new SampleNode4,
      new SampleNode5,
      new SampleNode6,
      new SampleNode7,
      new SampleNode8,
      new SampleNode9,
      new SampleNode10,
      new SampleNode11,
      new SampleNode12,
      new SampleNode13,
      new SampleNode14,
      new SampleNode15,
      new SampleNode16,
      new SampleNode17,
      new SampleNode18,
      new SampleNode19,
      new SampleNode20
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
    def visit(n: SampleNode1): T = ???
    def visit(n: SampleNode2): T = ???
    def visit(n: SampleNode3): T = ???
    def visit(n: SampleNode4): T = ???
    def visit(n: SampleNode5): T = ???
    def visit(n: SampleNode6): T = ???
    def visit(n: SampleNode7): T = ???
    def visit(n: SampleNode8): T = ???
    def visit(n: SampleNode9): T = ???
    def visit(n: SampleNode10): T = ???
    def visit(n: SampleNode11): T = ???
    def visit(n: SampleNode12): T = ???
    def visit(n: SampleNode13): T = ???
    def visit(n: SampleNode14): T = ???
    def visit(n: SampleNode15): T = ???
    def visit(n: SampleNode16): T = ???
    def visit(n: SampleNode17): T = ???
    def visit(n: SampleNode18): T = ???
    def visit(n: SampleNode19): T = ???
    def visit(n: SampleNode20): T = ???
  }

  class SampleNode1 extends Node {
    val foo1 = "SampleNode1"
    override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
  }

  class SampleNode2 extends Node {
    val foo2 = "SampleNode2"
    override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
  }

  class SampleNode3 extends Node {
    val foo3 = "SampleNode3"
    override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
  }

  class SampleNode4 extends Node {
    val foo4 = "SampleNode4"
    override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
  }

  class SampleNode5 extends Node {
    val foo5 = "SampleNode5"
    override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
  }

  class SampleNode6 extends Node {
    val foo6 = "SampleNode6"
    override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
  }

  class SampleNode7 extends Node {
    val foo7 = "SampleNode7"
    override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
  }

  class SampleNode8 extends Node {
    val foo8 = "SampleNode8"
    override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
  }

  class SampleNode9 extends Node {
    val foo9 = "SampleNode9"
    override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
  }

  class SampleNode10 extends Node {
    val foo10 = "SampleNode10"
    override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
  }

  class SampleNode11 extends Node {
    val foo11 = "SampleNode11"
    override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
  }

  class SampleNode12 extends Node {
    val foo12 = "SampleNode12"
    override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
  }

  class SampleNode13 extends Node {
    val foo13 = "SampleNode13"
    override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
  }

  class SampleNode14 extends Node {
    val foo14 = "SampleNode14"
    override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
  }

  class SampleNode15 extends Node {
    val foo15 = "SampleNode15"
    override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
  }

  class SampleNode16 extends Node {
    val foo16 = "SampleNode16"
    override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
  }

  class SampleNode17 extends Node {
    val foo17 = "SampleNode17"
    override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
  }

  class SampleNode18 extends Node {
    val foo18 = "SampleNode18"
    override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
  }

  class SampleNode19 extends Node {
    val foo19 = "SampleNode19"
    override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
  }

  class SampleNode20 extends Node {
    val foo20 = "SampleNode20"
    override def accept[T](visitor: NodeVisitor[T]): T = visitor.visit(this)
  }

  object NodeFooMatcher2 {
    def foo(node: Node): String = node match {
      case node: SampleNode1 => node.foo1
      case node: SampleNode2 => node.foo2
    }
  }
  object NodeFooMatcher3 {
    def foo(node: Node): String = node match {
      case node: SampleNode1 => node.foo1
      case node: SampleNode2 => node.foo2
      case node: SampleNode3 => node.foo3
    }
  }
  object NodeFooMatcher5 {
    def foo(node: Node): String = node match {
      case node: SampleNode1 => node.foo1
      case node: SampleNode2 => node.foo2
      case node: SampleNode3 => node.foo3
      case node: SampleNode4 => node.foo4
      case node: SampleNode5 => node.foo5
    }
  }
  object NodeFooMatcher10 {
    def foo(node: Node): String = node match {
      case node: SampleNode1 => node.foo1
      case node: SampleNode2 => node.foo2
      case node: SampleNode3 => node.foo3
      case node: SampleNode4 => node.foo4
      case node: SampleNode5 => node.foo5
      case node: SampleNode6 => node.foo6
      case node: SampleNode7 => node.foo7
      case node: SampleNode8 => node.foo8
      case node: SampleNode9 => node.foo9
      case node: SampleNode10 => node.foo10
    }
  }
  object NodeFooMatcher20 {
    def foo(node: Node): String = node match {
      case node: SampleNode1 => node.foo1
      case node: SampleNode2 => node.foo2
      case node: SampleNode3 => node.foo3
      case node: SampleNode4 => node.foo4
      case node: SampleNode5 => node.foo5
      case node: SampleNode6 => node.foo6
      case node: SampleNode7 => node.foo7
      case node: SampleNode8 => node.foo8
      case node: SampleNode9 => node.foo9
      case node: SampleNode10 => node.foo10
      case node: SampleNode11 => node.foo11
      case node: SampleNode12 => node.foo12
      case node: SampleNode13 => node.foo13
      case node: SampleNode14 => node.foo14
      case node: SampleNode15 => node.foo15
      case node: SampleNode16 => node.foo16
      case node: SampleNode17 => node.foo17
      case node: SampleNode18 => node.foo18
      case node: SampleNode19 => node.foo19
      case node: SampleNode20 => node.foo20
    }
  }

  object NodeFooVisitor2 extends NodeVisitor[String] {
    override def visit(n: SampleNode1): String = n.foo1
    override def visit(n: SampleNode2): String = n.foo2
  }
  object NodeFooVisitor3 extends NodeVisitor[String] {
    override def visit(n: SampleNode1): String = n.foo1
    override def visit(n: SampleNode2): String = n.foo2
    override def visit(n: SampleNode3): String = n.foo3
  }
  object NodeFooVisitor5 extends NodeVisitor[String] {
    override def visit(n: SampleNode1): String = n.foo1
    override def visit(n: SampleNode2): String = n.foo2
    override def visit(n: SampleNode3): String = n.foo3
    override def visit(n: SampleNode4): String = n.foo4
    override def visit(n: SampleNode5): String = n.foo5
  }
  object NodeFooVisitor10 extends NodeVisitor[String] {
    override def visit(n: SampleNode1): String = n.foo1
    override def visit(n: SampleNode2): String = n.foo2
    override def visit(n: SampleNode3): String = n.foo3
    override def visit(n: SampleNode4): String = n.foo4
    override def visit(n: SampleNode5): String = n.foo5
    override def visit(n: SampleNode6): String = n.foo6
    override def visit(n: SampleNode7): String = n.foo7
    override def visit(n: SampleNode8): String = n.foo8
    override def visit(n: SampleNode9): String = n.foo9
    override def visit(n: SampleNode10): String = n.foo10
  }
  object NodeFooVisitor20 extends NodeVisitor[String] {
    override def visit(n: SampleNode1): String = n.foo1
    override def visit(n: SampleNode2): String = n.foo2
    override def visit(n: SampleNode3): String = n.foo3
    override def visit(n: SampleNode4): String = n.foo4
    override def visit(n: SampleNode5): String = n.foo5
    override def visit(n: SampleNode6): String = n.foo6
    override def visit(n: SampleNode7): String = n.foo7
    override def visit(n: SampleNode8): String = n.foo8
    override def visit(n: SampleNode9): String = n.foo9
    override def visit(n: SampleNode10): String = n.foo10
    override def visit(n: SampleNode11): String = n.foo11
    override def visit(n: SampleNode12): String = n.foo12
    override def visit(n: SampleNode13): String = n.foo13
    override def visit(n: SampleNode14): String = n.foo14
    override def visit(n: SampleNode15): String = n.foo15
    override def visit(n: SampleNode16): String = n.foo16
    override def visit(n: SampleNode17): String = n.foo17
    override def visit(n: SampleNode18): String = n.foo18
    override def visit(n: SampleNode19): String = n.foo19
    override def visit(n: SampleNode20): String = n.foo20
  }
}
