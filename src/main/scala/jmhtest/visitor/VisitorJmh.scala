// package jmhtest.visitor

// import org.openjdk.jmh.annotations._
// import org.openjdk.jmh.infra.Blackhole

// object VisitorJmh {
//   val iter2 = infiniteNodeIterator(new N1, new N2)
//   val iter3a = infiniteNodeIterator(new N4, new N5, new N6)

//   def infiniteNodeIterator(nodes: Node*) = new java.util.Iterator[Node] {
//     val nodesArr: Array[Node] = nodes.toArray
//     val nodeCount = nodesArr.size

//     var i = 0
//     def hasNext(): Boolean = true
//     def next(): Node = {
//       val node = nodesArr(i)
//       i += 1
//       if (i == nodeCount) i = 0
//       node
//     }
//   }
// }

// // @Warmup(iterations = 20)
// // @Measurement(iterations = 100)
// // @Warmup(iterations = 2)
// // @Measurement(iterations = 10)
// @Warmup(iterations = 2)
// @Measurement(iterations = 5)
// @State(Scope.Benchmark)
// class VisitorJmh {
//   import VisitorJmh._
//   val Iterations = 100000

//   @Benchmark
//   @BenchmarkMode(Array(Mode.Throughput))
//   // @Fork(value = 1)
//   @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockDiagnosticVMOptions", "-XX:+PrintCompilation", "-XX:+PrintInlining", "-XX:CompileThreshold=1000"))
//   def visitor2: Unit = {
//     var i = 0
//     while (i < Iterations) {
//       i += 1
//       iter2.next.accept(Visitor2)
//     }
//   }

//   @Benchmark
//   @BenchmarkMode(Array(Mode.Throughput))
//   // @Fork(value = 1)
//   @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockDiagnosticVMOptions", "-XX:+PrintCompilation", "-XX:+PrintInlining", "-XX:CompileThreshold=1000"))
//   def visitor3a: Unit = {
//     var i = 0
//     while (i < Iterations) {
//       i += 1
//       iter3a.next.accept(Visitor3a)
//     }
//   }

//   // @Benchmark
//   // @BenchmarkMode(Array(Mode.Throughput))
//   // @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockDiagnosticVMOptions", "-XX:+LogCompilation", "-XX:+PrintAssembly" ,"-XX:+PrintInterpreter", "-XX:+PrintNMethods", "-XX:+PrintNativeNMethods", "-XX:+PrintSignatureHandlers", "-XX:+PrintAdapterHandlers", "-XX:+PrintStubCode", "-XX:+PrintCompilation", "-XX:+PrintInlining"))
//   // def visitor2a: Unit = {
//   //   val iter = infiniteNodeIterator(new N10, new N11)
//   //   1.to(Iterations).foreach(_ =>
//   //     iter.next.accept(Visitor2a)
//   //   )
//   // }

//   // @Benchmark
//   // @BenchmarkMode(Array(Mode.Throughput))
//   // @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockDiagnosticVMOptions", "-XX:+LogCompilation", "-XX:+PrintAssembly" ,"-XX:+PrintInterpreter", "-XX:+PrintNMethods", "-XX:+PrintNativeNMethods", "-XX:+PrintSignatureHandlers", "-XX:+PrintAdapterHandlers", "-XX:+PrintStubCode", "-XX:+PrintCompilation", "-XX:+PrintInlining"))
//   // def visitor2b: Unit = {
//   //   val iter = infiniteNodeIterator(new N1, new N11)
//   //   1.to(Iterations).foreach(_ =>
//   //     iter.next.accept(Visitor2a)
//   //   )
//   // }

//   // @Benchmark
//   // @BenchmarkMode(Array(Mode.Throughput))
//   // @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockDiagnosticVMOptions", "-XX:+LogCompilation", "-XX:+PrintAssembly" ,"-XX:+PrintInterpreter", "-XX:+PrintNMethods", "-XX:+PrintNativeNMethods", "-XX:+PrintSignatureHandlers", "-XX:+PrintAdapterHandlers", "-XX:+PrintStubCode", "-XX:+PrintCompilation", "-XX:+PrintInlining"))
//   // def visitor2c: Unit = {
//   //   val iter = infiniteNodeIterator(new N1, new N10, new N11)
//   //   1.to(Iterations).foreach(_ =>
//   //     iter.next.accept(Visitor2a)
//   //   )
//   // }

// }
