import scala.io._

object Main extends App {
  var (state, player) = TicTacToe.init()
  while (TicTacToe.isPlayerWon(state) == Player.None) {
    println(s"Player - $player Enter your turn I in desk matrix")
    val i = StdIn.readInt()
    println(s"Player - $player Enter your turn J in desk matrix")
    val j = StdIn.readInt()

    val (curState, curPlayer) = TicTacToe.makeTurn(state, player, i, j)
    state = curState; player = curPlayer
    println(TicTacToe.toString(state))
  }

  println(s"Player - $player won!")
}