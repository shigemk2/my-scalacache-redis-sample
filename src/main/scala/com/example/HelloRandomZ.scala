package com.example

import com.nicta.rng.{Rng, Size}

object HelloRandomZ {
  def main(args: Array[String]): Unit = {
    case class Person(name: String, age: Option[Int])

    val randomPerson: Rng[Person] =
      for {
        n <- Rng.string(Size(5))
        a <- Rng.int.option
      } yield Person(n, a)
    println(randomPerson)
    println("Hello, world!")
  }
}
