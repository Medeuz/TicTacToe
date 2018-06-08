object TicTacToe {

  type State = List[List[Player.Value]]

  def init(): (State, Player.Value) = (
    List(
      List(Player.None, Player.None, Player.None),
      List(Player.None, Player.None, Player.None),
      List(Player.None, Player.None, Player.None)),
    Player.None
  )

  def makeTurn(gameState: State, state: Player.Value, i: Int, j: Int): (State, Player.Value) = (
    gameState.zipWithIndex.map { case (row, index) => if (index == i) row.zipWithIndex.map { case (elem, index) => if (index == j) state else elem } else row },
    state match {
      case Player.None => Player.Cross
      case Player.Nought => Player.Cross
      case Player.Cross => Player.Nought
    }
  )

  def isPlayerWon(gameState: State): Player.Value = {
    def checkVertical(i: Int, state: Player.Value): Boolean = {
      if (i >= gameState.length) return false
      if (!gameState(i).forall(currentState => currentState == state))
        checkVertical(i + 1, state)
      else true
    }

    def checkHorizontal(j: Int, state: Player.Value): Boolean = {
      if (j >= gameState.head.length) return false
      if (!gameState.forall(row => row(j) == state))
        checkHorizontal(j + 1, state)
      else true
    }

    def checkCross(state: Player.Value): Boolean = {
      val fromRightToLeft = gameState.forall(row => row(row.length - 1 - gameState.indexOf(row)) == state)
      val fromLeftToRight = gameState.forall(row => row(gameState.indexOf(row)) == state)
      fromLeftToRight || fromRightToLeft
    }

    if (checkVertical(0, Player.Cross) || checkHorizontal(0, Player.Cross) || checkCross(Player.Cross)) Player.Cross
    else if (checkVertical(0, Player.Nought) || checkHorizontal(0, Player.Nought) || checkCross(Player.Nought)) Player.Nought
    else Player.None
  }

  def toString(gameState: State): String = {
    def rowToString(row: List[Player.Value]): String = {
      row.foldLeft("|") { (accumulator, state) => accumulator + Player.toString(state) + "|" }
    }

    gameState.foldLeft("") { (accumulator, row) => accumulator.concat(rowToString(row) + "\n")}
  }

}
