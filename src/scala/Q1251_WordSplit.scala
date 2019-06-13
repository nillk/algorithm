package scala

object Q1251_WordSplit {
  def main (args: Array[String]) : Unit = {
    val str = readLine

    val reversed = for (first <- 1 until str.length - 1; second <- first + 1 until str.length) yield {
      str.substring(0, first).reverse + str.substring(first, second).reverse + str.substring(second).reverse
    }

    print(reversed.min)
  }
}
