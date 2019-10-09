package jmhtest
import java.util.concurrent.TimeUnit
import org.openjdk.jmh.annotations._

@OutputTimeUnit(TimeUnit.SECONDS)
@Warmup(iterations = 30)
@Measurement(iterations = 30)
@State(Scope.Benchmark)
class TestBenchmark {
  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput, Mode.AverageTime))
  @Fork(value = 1)
  def iterator(): Int =
    Iterator.from(1)
      .takeWhile(_ < 1000)
      .filter(_ % 2 == 0)
      .count(_.toString.length == 4)
}
