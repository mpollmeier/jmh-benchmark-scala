package jmhtest.visitor

import org.openjdk.jmh.annotations._

// @Warmup(iterations = 20)
// @Measurement(iterations = 100)
// @Warmup(iterations = 2)
// @Measurement(iterations = 10)
// @State(Scope.Benchmark)
// class VisitorVsMatch {
//   val Iterations = 1000

  // @Benchmark
  // @BenchmarkMode(Array(Mode.Throughput))
  // @Fork(value = 1)
  // def matcher2: Unit = {
  //   val iter = infiniteNodeIterator(2)
  //   1.to(Iterations).foreach(_ =>
  //     Matcher2.foo(iter.next)
  //   )
  // }

//   @Benchmark
//   @BenchmarkMode(Array(Mode.Throughput))
//   @Fork(value = 1)
//   def visitor1: Unit = {
//     val iter = infiniteNodeIterator(1)
//     1.to(Iterations).foreach(_ =>
//       iter.next.accept(Visitor1)
//     )
//   }

//   @Benchmark
//   @BenchmarkMode(Array(Mode.Throughput))
//   @Fork(value = 1)
//   def visitor2: Unit = {
//     val iter = infiniteNodeIterator(2)
//     1.to(Iterations).foreach(_ =>
//       iter.next.accept(Visitor2)
//     )
//   }

//   // @Benchmark
//   // @BenchmarkMode(Array(Mode.Throughput))
//   // @Fork(value = 1)
//   // def matcher3: Unit = {
//   //   val iter = infiniteNodeIterator(3)
//   //   1.to(Iterations).foreach(_ =>
//   //     Matcher3.foo(iter.next)
//   //   )
//   // }

//   @Benchmark
//   @BenchmarkMode(Array(Mode.Throughput))
//   @Fork(value = 1)
//   def visitor3: Unit = {
//     val iter = infiniteNodeIterator(3)
//     1.to(Iterations).foreach(_ =>
//       iter.next.accept(Visitor3)
//     )
//   }

//   // @Benchmark
//   // @BenchmarkMode(Array(Mode.Throughput))
//   // @Fork(value = 1)
//   // def matcher5: Unit = {
//   //   val iter = infiniteNodeIterator(5)
//   //   1.to(Iterations).foreach(_ =>
//   //     Matcher5.foo(iter.next)
//   //   )
//   // }

//   // @Benchmark
//   // @BenchmarkMode(Array(Mode.Throughput))
//   // @Fork(value = 1)
//   // def visitor5: Unit = {
//   //   val iter = infiniteNodeIterator(5)
//   //   1.to(Iterations).foreach(_ =>
//   //     iter.next.accept(Visitor5)
//   //   )
//   // }

//   // @Benchmark
//   // @BenchmarkMode(Array(Mode.Throughput))
//   // @Fork(value = 1)
//   // def matcher10: Unit = {
//   //   val iter = infiniteNodeIterator(10)
//   //   1.to(Iterations).foreach(_ =>
//   //     Matcher10.foo(iter.next)
//   //   )
//   // }

//   // @Benchmark
//   // @BenchmarkMode(Array(Mode.Throughput))
//   // @Fork(value = 1)
//   // def visitor10: Unit = {
//   //   val iter = infiniteNodeIterator(10)
//   //   1.to(Iterations).foreach(_ =>
//   //     iter.next.accept(Visitor10)
//   //   )
//   // }

//   // @Benchmark
//   // @BenchmarkMode(Array(Mode.Throughput))
//   // @Fork(value = 1)
//   // def matcher20: Unit = {
//   //   val iter = infiniteNodeIterator(20)
//   //   1.to(Iterations).foreach(_ =>
//   //     Matcher20.foo(iter.next)
//   //   )
//   // }

//   // @Benchmark
//   // @BenchmarkMode(Array(Mode.Throughput))
//   // @Fork(value = 1)
//   // def visitor20: Unit = {
//   //   val iter = infiniteNodeIterator(20)
//   //   1.to(Iterations).foreach(_ =>
//   //     iter.next.accept(Visitor20)
//   //   )
//   // }

//   def infiniteNodeIterator(nodeCount: Int) = new java.util.Iterator[Node] {
//     val nodes: Array[Node] = Array(
//       new N1,
//       new N2,
//       new N3,
//       new N4,
//       new N5,
//       new N6,
//       new N7,
//       new N8,
//       new N9,
//       new N10,
//       new N11,
//       new N12,
//       new N13,
//       new N14,
//       new N15,
//       new N16,
//       new N17,
//       new N18,
//       new N19,
//       new N20
//     )
//     var i = 0
//     def hasNext(): Boolean = true
//     def next(): Node = {
//       val node = nodes(i)
//       i += 1
//       if (i == nodeCount) i = 0
//       node
//     }
//   }
// }

