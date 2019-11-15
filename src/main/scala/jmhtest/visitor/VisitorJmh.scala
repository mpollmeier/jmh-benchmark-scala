package jmhtest.visitor

import org.openjdk.jmh.annotations._
import org.openjdk.jmh.infra.Blackhole

object VisitorJmh {
  val iter2 = infiniteNodeIterator(new N1, new N2)
  val iter3 = infiniteNodeIterator(new N4, new N5, new N6)

  def infiniteNodeIterator(nodes: Node*) = new java.util.Iterator[Node] {
    val nodesArr: Array[Node] = nodes.toArray
    val nodeCount = nodesArr.size

    var i = 0
    def hasNext(): Boolean = true
    def next(): Node = {
      val node = nodesArr(i)
      i += 1
      if (i == nodeCount) i = 0
      node
    }
  }

}

// @Warmup(iterations = 20)
// @Measurement(iterations = 100)
// @Warmup(iterations = 2)
// @Measurement(iterations = 10)
@Warmup(iterations = 1)
@Measurement(iterations = 5)
@State(Scope.Benchmark)
class VisitorJmh {
  import VisitorJmh._
  val Iterations = 1000000

  // blackhole a la http://hg.openjdk.java.net/code-tools/jmh/file/c8f9f5b85cd9/jmh-samples/src/main/java/org/openjdk/jmh/samples/JMHSample_28_BlackholeHelpers.java
  trait Worker {
    def work(): Unit
  }
  var workerBaseline: Worker = null
  var workerWrong: Worker = null
  var workerRight: Worker = null
  var blackhole: Blackhole = null

  @Setup
  def setup(blackhole: Blackhole): Unit = {
    this.blackhole = blackhole
    workerBaseline = new Worker {
      final override def work(): Unit = {
        // do nothing
      }
    }
    workerWrong = new Worker {
      val x = 0d
      final override def work(): Unit = {
        Math.log(x)
      }
    }
    workerRight = new Worker {
      val x = 0d
      final override def work(): Unit = {
        blackhole.consume(Math.log(x))
      }
    }
    println("setup called! xxxxxxxxxx")
  }


  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  // @Fork(value = 1)
  @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockDiagnosticVMOptions", "-XX:+PrintCompilation", "-XX:+PrintInlining", "-XX:CompileThreshold=1000"))
  def visitor2: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      iter2.next.accept(Visitor2)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  // @Fork(value = 1)
  @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockDiagnosticVMOptions", "-XX:+PrintCompilation", "-XX:+PrintInlining", "-XX:CompileThreshold=1000"))
  def visitor2WithBlackhole: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      blackhole.consume(iter2.next.accept(Visitor2))
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  // @Fork(value = 1)
  @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockDiagnosticVMOptions", "-XX:+PrintCompilation", "-XX:+PrintInlining", "-XX:CompileThreshold=1000"))
  def visitor3: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      iter3.next.accept(Visitor3)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  // @Fork(value = 1)
  @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockDiagnosticVMOptions", "-XX:+PrintCompilation", "-XX:+PrintInlining", "-XX:CompileThreshold=1000"))
  def visitor3WithBlackhole: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      blackhole.consume(iter3.next.accept(Visitor3))
    }
  }


  // @Benchmark
  // @BenchmarkMode(Array(Mode.Throughput))
  // @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockDiagnosticVMOptions", "-XX:+LogCompilation", "-XX:+PrintAssembly" ,"-XX:+PrintInterpreter", "-XX:+PrintNMethods", "-XX:+PrintNativeNMethods", "-XX:+PrintSignatureHandlers", "-XX:+PrintAdapterHandlers", "-XX:+PrintStubCode", "-XX:+PrintCompilation", "-XX:+PrintInlining"))
  // def visitor2a: Unit = {
  //   val iter = infiniteNodeIterator(new N10, new N11)
  //   1.to(Iterations).foreach(_ =>
  //     iter.next.accept(Visitor2a)
  //   )
  // }

  // @Benchmark
  // @BenchmarkMode(Array(Mode.Throughput))
  // @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockDiagnosticVMOptions", "-XX:+LogCompilation", "-XX:+PrintAssembly" ,"-XX:+PrintInterpreter", "-XX:+PrintNMethods", "-XX:+PrintNativeNMethods", "-XX:+PrintSignatureHandlers", "-XX:+PrintAdapterHandlers", "-XX:+PrintStubCode", "-XX:+PrintCompilation", "-XX:+PrintInlining"))
  // def visitor2b: Unit = {
  //   val iter = infiniteNodeIterator(new N1, new N11)
  //   1.to(Iterations).foreach(_ =>
  //     iter.next.accept(Visitor2a)
  //   )
  // }

  // @Benchmark
  // @BenchmarkMode(Array(Mode.Throughput))
  // @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockDiagnosticVMOptions", "-XX:+LogCompilation", "-XX:+PrintAssembly" ,"-XX:+PrintInterpreter", "-XX:+PrintNMethods", "-XX:+PrintNativeNMethods", "-XX:+PrintSignatureHandlers", "-XX:+PrintAdapterHandlers", "-XX:+PrintStubCode", "-XX:+PrintCompilation", "-XX:+PrintInlining"))
  // def visitor2c: Unit = {
  //   val iter = infiniteNodeIterator(new N1, new N10, new N11)
  //   1.to(Iterations).foreach(_ =>
  //     iter.next.accept(Visitor2a)
  //   )
  // }

}
