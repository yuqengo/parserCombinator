package domain

sealed trait Sign

object Sign {
  case object Plus extends Sign
  case object Minus extends Sign
}
