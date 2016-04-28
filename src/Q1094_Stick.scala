object Q1094_Stick {
  def main(args : Array[String]) : Unit = {
    var x = readInt
    var stick = 64
    var count = 0
    while (x != 0) {
      while (stick > x) {
        stick /= 2
      }
 
      x -= stick
      count += 1
    }
 
    print(count)
  }
}