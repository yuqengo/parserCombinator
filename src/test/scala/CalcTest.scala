import Parser.Parser
import domain.Term.Term
import domain._
import org.mockito.Mockito._
import org.scalatest._
import org.scalatest.mockito.MockitoSugar

class CalcTest extends FlatSpec with MockitoSugar with DiagrammedAssertions {

  private val parser = mock[Parser]
  private val target = Calc(parser)

  "calculation" should "整数2つの足し算ができる" in {
    val input = "1+2"
    val terms1 = mock[Terms]
    val expected = mock[Term]

    when(parser.parse(input)).thenReturn(terms1)
    when(terms1.sum()).thenReturn(expected)

    val actual = target.calculation(input)

    assert(actual == expected)

    verify(parser).parse(input)
    verify(terms1).sum()
  }
  it should "負の値が含まれている整数3つの足し算" in {
    val input = "1-2+3"
    val terms1 = mock[Terms]
    val expected = mock[Term]

    when(parser.parse(input)).thenReturn(terms1)
    when(terms1.sum()).thenReturn(expected)

    val actual = target.calculation(input)

    assert(actual == expected)

    verify(parser).parse(input)
    verify(terms1).sum()
  }
}
