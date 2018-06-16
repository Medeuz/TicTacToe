lazy val root = (project in file("."))
  .settings(
    name         := "hello",
    organization := "ru.medeuz.TicTacToe",
    scalaVersion := "2.12.6",
    version      := "0.1.0-SNAPSHOT"
  )