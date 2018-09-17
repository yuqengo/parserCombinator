import Parser.Parser
import domain.Term.Term

trait Calc {
  def calculation(input: String): Term
}
class CalcImpl(parser: Parser) extends Calc {
  override def calculation(input: String): Term = parser.parse(input).sum()
}
object Calc {
  def apply(parser: Parser): Calc = new CalcImpl(parser)
}
