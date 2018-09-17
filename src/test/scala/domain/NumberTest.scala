package domain

import org.scalatest.{DiagrammedAssertions, FlatSpec}

class NumberTest extends FlatSpec with DiagrammedAssertions {

  "signInversion" should "正の整数を負の整数に変換できる" in {
    assert(Number(5).signInversion === Number(-5))
  }

  it should "負の整数を正の整数に変換できる" in {
    assert(Number(-5).signInversion === Number(5))
  }

  "+" should "足し算を行うことができる" in {
    assert(Number(1) + Number(2) === Number(3))
  }

  it should "負の整数同士の足し算ができる" in {
    assert(Number(-5) + Number(-3) === Number(-8))
  }

  it should "正の整数と負の整数での足し算ができる" in {
    assert(Number(5) + Number(-3) === Number(2))
  }
}