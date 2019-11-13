package jmhtest.visitor

import org.openjdk.jmh.annotations._

// @Warmup(iterations = 20)
// @Measurement(iterations = 100)
@Warmup(iterations = 2)
@Measurement(iterations = 10)
@State(Scope.Benchmark)
class VisitorJmh {
  val Iterations = 1000

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def visitor1: Unit = {
    val iter = infiniteNodeIterator(new N1)
    1.to(Iterations).foreach(_ =>
      iter.next.accept(Visitor1)
    )
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def visitor2a: Unit = {
    val iter = infiniteNodeIterator(new N1, new N2)
    1.to(Iterations).foreach(_ =>
      iter.next.accept(Visitor2)
    )
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def visitor2b: Unit = {
    val iter = infiniteNodeIterator(new N10, new N11)
    1.to(Iterations).foreach(_ =>
      iter.next.accept(Visitor2)
    )
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def visitor3: Unit = {
    val iter = infiniteNodeIterator(new N1, new N2, new N3)
    1.to(Iterations).foreach(_ =>
      iter.next.accept(Visitor3)
    )
  }

  def infiniteNodeIterator(nodes: Node*) = new java.util.Iterator[Node] {
    val nodes: Array[Node] = nodes.toArray
    val nodeCount = nodes.size

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
