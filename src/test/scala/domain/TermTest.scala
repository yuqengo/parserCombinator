package domain

import domain.Sign.Minus
import org.scalatest.{DiagrammedAssertions, FlatSpec}

class TermTest extends FlatSpec with DiagrammedAssertions {

  //TODO value classをmock化する方法がわからないから実実装でテスト
  "+" should "足し算をすることができる" in {
    val num1 = Number(1)
    val num2 = Number(2)
    assert(Term(num1) + Term(num2) === Term(Number(3)))
  }

  it should "負の値同士の足し算をすることができる" in {
    val num1 = Number(1)
    val num2 = Number(2)
    assert(Term(num1, Minus) + Term(num2, Minus) === Term(Number(-3)))
  }
}