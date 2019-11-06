// package jmhtest

// import java.util.concurrent.TimeUnit
// import org.openjdk.jmh.annotations._

// @Warmup(iterations = 20)
// @Measurement(iterations = 100)
// @State(Scope.Benchmark)
// /**
// Benchmark                  Mode  Cnt         Score       Error  Units
// */
// class RegexMatch {
//   @Benchmark
//   @BenchmarkMode(Array(Mode.Throughput))
//   @Fork(value = 1)
//   def stringCompare: Unit = {
//     val iter = infiniteStringIterator 
//     var matches = 0
//     val string = "abc999"
//     0.to(20000).foreach { i =>
//       if (iter.next.equals(string)) matches += 1
//     }
//     assert(matches == 20)
//   }

//   @Benchmark
//   @BenchmarkMode(Array(Mode.Throughput))
//   @Fork(value = 1)
//   def regexCompare: Unit = {
//     val iter = infiniteStringIterator 
//     var matches = 0
//     val string = "abc999"
//     val pattern = java.util.regex.Pattern.compile(string)
//     0.to(20000).foreach { i =>
//       if (pattern.matcher(iter.next).matches) matches += 1
//     }
//     assert(matches == 20)
//   }

//   def infiniteStringIterator = new java.util.Iterator[String] {
//     var i = 0
//     def hasNext() = true
//     def next() = {
//       val res = "abc" + i
//       i += 1
//       if (i == 1000) i = 0
//       res
//     }
//   }

// }
