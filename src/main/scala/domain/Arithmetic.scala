package domain

import domain.Sign.{Minus, Plus}
import domain.Term._

case class Number(value: Int) extends AnyVal {
  def +(number: Number) = Number(this.value + number.value)
  def signInversion = Number(-value)
}

object Term {
  def apply(number: Number, sign: Sign = Plus): Term = sign match {
    case Plus => Term(number)
    case Minus => Term(number.signInversion)
  }
  case class Term(number: Number) {
    def +(term: Term): Term = Term(this.number + term.number)
    override def toString: String = String.valueOf(number.value)
  }
}

object Terms {
  def apply(terms: Term*)(implicit dummyImplicit: DummyImplicit): Terms = this (terms)
}

case class Terms(override val list: Seq[Term]) extends FCC[Term] {
  def sum(): Term = list.reduce(_ + _)
}
