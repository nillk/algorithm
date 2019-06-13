package scala

object Q1000_Sum_Scala {
  def main(args: Array[String]): Unit = {
    val Array(a, b) = readLine().split(" ").take(2).map(_.toInt)
    println(a + b)
  }
}