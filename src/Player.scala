object Player extends Enumeration {
  val Cross, Nought, None = Value

  def toString(player: Player.Value): String = player match {
    case Cross => "X"
    case Nought => "O"
    case None => " "
  }
}
