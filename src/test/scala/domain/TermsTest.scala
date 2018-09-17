package domain

import domain.Term._
import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{DiagrammedAssertions, FlatSpec}

class TermsTest extends FlatSpec with MockitoSugar with DiagrammedAssertions {

  "sun" should "合計値を計算することができる" in {
    val term1 = mock[Term]
    val term2 = mock[Term]
    val term3 = mock[Term]

    val term4 = mock[Term]
    when(term1 + term2).thenReturn(term4)

    val expect = mock[Term]
    when(term4 + term3).thenReturn(expect)

    val actual = Terms(term1, term2, term3).sum()

    assert(actual === expect)

    verify(term1) + term2
    verify(term4) + term3
  }

}
