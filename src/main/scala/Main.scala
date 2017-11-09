object Main extends App {
  val ages = Seq(42, 75, 29, 64)
  println(s"The oldest person is ${ages.max}")

  val desk = new Desk
  desk.makeTurn(desk.State.Cross, 1, 2)
  println(desk.toString)
}
