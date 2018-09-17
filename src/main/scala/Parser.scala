import domain.Sign.{Minus, Plus}
import domain.Term.Term
import domain._

import scala.util.parsing.combinator.RegexParsers

object Parser {
  def apply(): Parser = new Parser()

  class Parser extends RegexParsers {

    def parse(input: String): Terms = parseAll(expr, input).get

    private def expr: Parser[Terms] = {
      number ~ rep(term) ^^ {
        case number ~ terms => Terms(Term(number) :: terms)
      }
    }

    private def term: Parser[Term] = (plus | minus) ~ number ^^ { case sign ~ num =>
      sign match {
        case Plus => Term(num)
        case Minus => Term(num.signInversion)
      }
    }
    private def number: Parser[Number] = """[0-9]+""".r ^^ { a => Number(a.toInt) }
    private def plus: Parser[Sign] = """\+""".r ^^ { _ => Plus }
    private def minus: Parser[Sign] = """\-""".r ^^ { _ => Minus }
  }
}

