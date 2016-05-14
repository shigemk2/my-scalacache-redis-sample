name := """my-redis-sample"""

version := "1.0"

scalaVersion := "2.11.8"

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
  "com.github.cb372" %% "scalacache-redis" % "0.8.1",
  "com.github.etaty" %% "rediscala" % "1.6.0",
  "org.scalaz" %% "scalaz-core" % "7.2.1",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

