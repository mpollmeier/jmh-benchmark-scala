// package jmhtest

// import java.util.concurrent.TimeUnit
// import org.openjdk.jmh.annotations._
// import java.{lang => jl, util => ju}
// import scala.collection.AbstractIterator

// @OutputTimeUnit(TimeUnit.SECONDS)
// @Warmup(iterations = 50)
// @Measurement(iterations = 1000)
// @State(Scope.Benchmark)
// /**
//   Benchmark                                 Mode   Cnt     Score   Error  Units
//   TestBenchmark.onlyJIteratorWrapper       thrpt  1000  1020.563 ± 0.471  ops/s
//   TestBenchmark.stdLib                     thrpt  1000   751.433 ± 5.457  ops/s
//   TestBenchmark.wrappedOrJIteratorWrapper  thrpt  1000   764.483 ± 0.996  ops/s
// */
// class TestBenchmark {
//   import TestBenchmark._

//   @Benchmark
//   @BenchmarkMode(Array(Mode.Throughput))
//   @Fork(value = 1)
//   def stdLib: Int = {
//     var i = 0
//     while(i < Iterations) {
//       Converters.FromStdLib.asScala(jiter)
//       i += 1
//     } 
//     i
//   }

//   @Benchmark
//   @BenchmarkMode(Array(Mode.Throughput))
//   @Fork(value = 1)
//   def onlyJIteratorWrapper: Int = {
//     var i = 0
//     while(i < Iterations) {
//       Converters.OnlyJIteratorWrapper.asScala(jiter)
//       i += 1
//     } 
//     i
//   }

//   @Benchmark
//   @BenchmarkMode(Array(Mode.Throughput))
//   @Fork(value = 1)
//   def wrappedOrJIteratorWrapper: Int = {
//     var i = 0
//     while(i < Iterations) {
//       Converters.WrappedOrJIteratorWrapper.asScala(jiter)
//       i += 1
//     } 
//     i
//   }

// }

// object TestBenchmark {
//   val Iterations = 1000 * 1000

//   val jiter = new ju.Iterator[Int] {
//     def hasNext(): Boolean = true
//     def next(): Int = 0
//   }
// }

// object Converters {

//   // copied from stdlib `AsScalaConverters.scala`
//   object FromStdLib {
//     def asScala[A](i: ju.Iterator[A]): Iterator[A] = i match {
//       case null                     => null
//       case IteratorWrapper(wrapped) => wrapped
//       case _                        => JIteratorWrapper(i)
//     }
//   }

//   object OnlyJIteratorWrapper {
//     def asScala[A](i: ju.Iterator[A]): Iterator[A] = JIteratorWrapper(i)
//   }

//   object WrappedOrJIteratorWrapper {
//     def asScala[A](i: ju.Iterator[A]): Iterator[A] = i match {
//       case IteratorWrapper(wrapped) => wrapped
//       case _                        => JIteratorWrapper(i)
//     }
//   }
// }

// // copied from stdlib `JavaCollectionWrappers.scala`
//   case class IteratorWrapper[A](underlying: Iterator[A]) extends ju.Iterator[A] with ju.Enumeration[A] with Serializable {
//     def hasNext = underlying.hasNext
//     def next() = underlying.next()
//     def hasMoreElements = underlying.hasNext
//     def nextElement() = underlying.next()
//     override def remove() = throw new UnsupportedOperationException
//   }

//   case class JIteratorWrapper[A](underlying: ju.Iterator[A]) extends AbstractIterator[A] with Iterator[A] with Serializable {
//     def hasNext = underlying.hasNext
//     def next() = underlying.next
//   }
