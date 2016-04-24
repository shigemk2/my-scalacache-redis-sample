package com.example

import redis.clients.jedis._
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}
import scalacache._
import scalacache.redis.RedisCache
import scala.concurrent.ExecutionContext.Implicits.global

object Hello {
  def main(args: Array[String]): Unit = {
    val jedis = new JedisPool("192.168.99.100", 6379)
    implicit val scalaCache = ScalaCache(RedisCache(jedis))
    jedis.getResource.set("key1", "foo")
    import scalacache._
    put("myKey")("myValue")
    val myKey = get("myKey")
    myKey.onComplete({
      case Success(result) => println(result) // Some(myValue)
      case Failure(t) => println(t.getMessage)
    })
    Await.ready(myKey, Duration.Inf)
    val key1 = get("key1")
    key1.onComplete({
      case Success(result) => println(result) // null
      case Failure(t) => println(t.getMessage)
    })
    Await.ready(key1, Duration.Inf)
    val otherKey = get("other-key")
    otherKey.onComplete({
      case Success(result) => println(result) // None
      case Failure(t) => println(t.getMessage)
    })
    Await.ready(otherKey, Duration.Inf)
    println("Hello, world!")
  }
}
