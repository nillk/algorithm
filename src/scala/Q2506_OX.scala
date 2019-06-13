object Q2506_OX {
  def main (args: Array[String]) {
    val n = readByte
    val scores = readLine.replace(" ", "").split("0").map(n => ((n.size * (n.size + 1)) / 2))
    print(scores.sum)
  }
}
