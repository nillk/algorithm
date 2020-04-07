object Q2010_ElectricalOutlets {
  def main(args: Array[String]) : Unit = {
    val n = readInt
    val availablePlug = for (i <- 1 to n) yield {
      readInt
    }
    println(availablePlug.sum - n + 1)
  }
}
