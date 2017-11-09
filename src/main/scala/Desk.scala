class Desk {

  object State extends Enumeration {
    type State = Value
    val Cross, Nought, None = Value
  }

  import State._

  var desk: Array[Array[State]] = Array(
    Array(None, None, None),
    Array(None, None, None),
    Array(None, None, None)
  )

  def makeTurn(state: State, i: Int, j: Int): Unit = {
    desk(i)(j) = state
  }

  def isPlayerWon(state: State): Boolean = {

    def checkVertical(i: Int, state: State): Boolean = {
      if (i >= desk.length) return false
      if (!desk(i).forall(currentState => currentState == state))
        checkVertical(i + 1, state)
      else true
    }

    def checkHorizontal(j: Int, state: State): Boolean = {
      if (j >= desk(0).length) return false
      if (!desk.forall(row => row(j) == state))
        checkHorizontal(j + 1, state)
      else true
    }

    def checkCross(state: State): Boolean = {
      val fromRightToLeft = desk.forall(row => row(row.length - desk.indexOf(row)) == state)
      val fromLeftToRight = desk.forall(row => row(desk.indexOf(row)) == state)
      fromLeftToRight || fromRightToLeft
    }

    checkVertical(0, state) || checkHorizontal(0, state) || checkCross(state)
  }

  override def toString: String = {
    def rowToString(row: Array[State]): String = {
      row.foldLeft("|") { (accumulator, state) =>
        state match {
          case State.Cross => accumulator.concat(" X |")
          case State.Nought => accumulator.concat(" O |")
          case State.None => accumulator.concat("   |")
        }
      }
    }

    desk.foldLeft("") { (accumulator, row) => accumulator.concat(rowToString(row) + "\n")}
  }


}
