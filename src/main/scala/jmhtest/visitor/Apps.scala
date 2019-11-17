package jmhtest.visitor

object Apps {
  val Iterations = 1000000000

  // def n2AcceptCount(iter: java.util.Iterator[Node]): Int =
  //   iter.next match {
  //     case node: N2 => node.acceptCount
  //     case _ => n2AcceptCount(iter)
  //   }
  // def n4AcceptCount(iter: java.util.Iterator[Node]): Int =
  //   iter.next match {
  //     case node: N4 => node.acceptCount
  //     case _ => n4AcceptCount(iter)
  //   }
}
import Apps._

object Visitor2App extends App {
  val start = System.currentTimeMillis
  var i = 0
  while (i < Iterations) {
    BenchmarkAll.iter2.next.accept(Visitor2)
    // if (i % 1000000 == 0) println(i)
    i += 1
  }
  val duration = System.currentTimeMillis - start
  println(s"finished in ${duration}ms")
  // println("N2 accept count: " + n2AcceptCount(BenchmarkAll.iter2))
}

object Visitor3App extends App {
  val start = System.currentTimeMillis
  var i = 0
  while (i < Iterations) {
    BenchmarkAll.iter3.next.accept(Visitor3)
    // if (i % 1000000 == 0) println(i)
    i += 1
  }
  val duration = System.currentTimeMillis - start
  println(s"finished in ${duration}ms")
  // println("N4 accept count: " + n4AcceptCount(BenchmarkAll.iter3))
}

// object MatcherApp extends App {
//   val v = new VisitorVsMatch

//   var i = 0
//   while (i < 10000000) {
//     if (i % 100000 == 0) println(i)
//     v.matcher20
//     i += 1
//   }
// }
