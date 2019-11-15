package jmhtest.visitor

import org.openjdk.jmh.annotations._
import scala.annotation.switch

object VisitorVsMatchswitch {
  val iter2 = infiniteNodeIterator(new N1, new N2)
  val iter3 = infiniteNodeIterator(new N4, new N5, new N6)
  val iter5 = infiniteNodeIterator(new N1, new N2, new N3, new N4, new N5)
  val iter10 = infiniteNodeIterator(new N1, new N2, new N3, new N4, new N5, new N6, new N7, new N8, new N9, new N10)

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

  object MatcherSwitch2 {
    def foo(node: Node): String = (node.tpe: @switch) match {
      case 1 => node.asInstanceOf[N1].foo1
      case 2 => node.asInstanceOf[N2].foo2
    }
  }
  object MatcherSwitch3 {
    def foo(node: Node): String = (node.tpe: @switch) match {
      case 4 => node.asInstanceOf[N4].foo4
      case 5 => node.asInstanceOf[N5].foo5
      case 6 => node.asInstanceOf[N6].foo6
    }
  }
  object MatcherSwitch5 {
    def foo(node: Node): String = (node.tpe: @switch) match {
      case 1 => node.asInstanceOf[N1].foo1
      case 2 => node.asInstanceOf[N2].foo2
      case 3 => node.asInstanceOf[N3].foo3
      case 4 => node.asInstanceOf[N4].foo4
      case 5 => node.asInstanceOf[N5].foo5
    }
  }
  object MatcherSwitch10 {
    def foo(node: Node): String = (node.tpe: @switch) match {
      case 1 => node.asInstanceOf[N1].foo1
      case 2 => node.asInstanceOf[N2].foo2
      case 3 => node.asInstanceOf[N3].foo3
      case 4 => node.asInstanceOf[N4].foo4
      case 5 => node.asInstanceOf[N5].foo5
      case 6 => node.asInstanceOf[N6].foo6
      case 7 => node.asInstanceOf[N7].foo7
      case 8 => node.asInstanceOf[N8].foo8
      case 9 => node.asInstanceOf[N9].foo9
      case 10 => node.asInstanceOf[N10].foo10
    }
  }
}

// @Warmup(iterations = 2)
// @Measurement(iterations = 10)
@Warmup(iterations = 20)
@Measurement(iterations = 100)
@State(Scope.Benchmark)
class VisitorVsMatchswitch {
  import VisitorVsMatchswitch._
  val Iterations = 1000

  // @Fork(value = 1)
  // @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockDiagnosticVMOptions", "-XX:+PrintCompilation", "-XX:+PrintInlining", "-XX:CompileThreshold=1000"))
  // @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockDiagnosticVMOptions", "-XX:+PrintCompilation", "-XX:+PrintInlining", "-XX:CompileThreshold=1000", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseJVMCICompiler"))

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def visitor02: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      iter2.next.accept(Visitor2)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockExperimentalVMOptions", "-XX:+UseJVMCICompiler"))
  def visitor02Graal: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      iter2.next.accept(Visitor2)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def visitor03: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      iter3.next.accept(Visitor3)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockExperimentalVMOptions", "-XX:+UseJVMCICompiler"))
  def visitor03Graal: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      iter3.next.accept(Visitor3)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def visitor05: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      iter5.next.accept(Visitor5)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockExperimentalVMOptions", "-XX:+UseJVMCICompiler"))
  def visitor05Graal: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      iter5.next.accept(Visitor5)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def visitor10: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      iter10.next.accept(Visitor10)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockExperimentalVMOptions", "-XX:+UseJVMCICompiler"))
  def visitor10Graal: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      iter10.next.accept(Visitor10)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def matcherSwitch02: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      MatcherSwitch2.foo(iter2.next)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockExperimentalVMOptions", "-XX:+UseJVMCICompiler"))
  def matcherSwitch02Graal: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      MatcherSwitch2.foo(iter2.next)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def matcherSwitch03: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      MatcherSwitch3.foo(iter3.next)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockExperimentalVMOptions", "-XX:+UseJVMCICompiler"))
  def matcherSwitch03Graal: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      MatcherSwitch3.foo(iter3.next)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def matcherSwitch05: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      MatcherSwitch5.foo(iter5.next)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockExperimentalVMOptions", "-XX:+UseJVMCICompiler"))
  def matcherSwitch05Graal: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      MatcherSwitch5.foo(iter5.next)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def matcherSwitch10: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      MatcherSwitch10.foo(iter10.next)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockExperimentalVMOptions", "-XX:+UseJVMCICompiler"))
  def matcherSwitch10Graal: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      MatcherSwitch10.foo(iter10.next)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def matcher02: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      Matcher2.foo(iter2.next)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockExperimentalVMOptions", "-XX:+UseJVMCICompiler"))
  def matcher02Graal: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      Matcher2.foo(iter2.next)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def matcher03: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      Matcher3.foo(iter3.next)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockExperimentalVMOptions", "-XX:+UseJVMCICompiler"))
  def matcher03Graal: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      Matcher3.foo(iter3.next)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def matcher05: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      Matcher5.foo(iter5.next)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockExperimentalVMOptions", "-XX:+UseJVMCICompiler"))
  def matcher05Graal: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      Matcher5.foo(iter5.next)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1)
  def matcher10: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      Matcher10.foo(iter10.next)
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @Fork(value = 1, jvmArgsAppend = Array("-XX:+UnlockExperimentalVMOptions", "-XX:+UseJVMCICompiler"))
  def matcher10Graal: Unit = {
    var i = 0
    while (i < Iterations) {
      i += 1
      Matcher10.foo(iter10.next)
    }
  }

}
