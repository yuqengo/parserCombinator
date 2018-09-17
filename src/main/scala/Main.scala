object Main {
  def main(args: Array[String]): Unit = {

    val calc = Calc(Parser())

    println(calc.calculation("1+2"))
    println(calc.calculation("1-2+6-3"))

  }

}
