package scala

object Q1057_Tournament {
  def main(args : Array[String]) : Unit = {
    var Array(n, a, b) = readLine.split(" ").map(_.toInt)
    var count = 0
    while (a != b) {
      a = next(a)
      b = next(b)
      count += 1
    }
    println(count)
  }

  def next(x: Double): Int = Math.ceil(x / 2).toInt
}
