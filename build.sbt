name := """my-redis-sample"""

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
  "com.github.jedis-lock" % "jedis-lock" % "1.0.0",
  "com.nicta" %% "rng" % "1.3.0",
  "org.scalaz" %% "scalaz-core" % "7.2.1",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

