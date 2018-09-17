import domain._
import org.scalatest._
import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito._
class ParserTest extends FlatSpec with MockitoSugar with DiagrammedAssertions {

  val target = Parser()

  "項だけを並べた式に変換できる" should "足し算" in {
    val expected = Terms(Term(Number(1)), Term(Number(2)))
    assert(target.parse("1+2") === expected)
  }

  it should "引き算" in {
    val expected = Terms(Term(Number(1)), Term(Number(-2)))
    assert(target.parse("1-2") === expected)
  }
}
