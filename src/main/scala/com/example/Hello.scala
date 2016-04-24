package com.example

import org.joda.time.format.DateTimeFormat
import redis.clients.jedis._
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scalacache._
import scalacache.redis.RedisCache
import scala.concurrent.ExecutionContext.Implicits.global

object Hello {
  def main(args: Array[String]): Unit = {
    val jedis = new Jedis("192.168.99.100", 6379)
    implicit val scalaCache = ScalaCache(RedisCache("192.168.99.100", 6379))
    // val startGet = new DateTime()
    // println(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(startGet))
    // for(i <- 1 to 100000) {
    //   jedis.get(i.toString)
    // }
    // val endGet = new DateTime()
    // println(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(endGet))
    val result = Await.result({
      scalacache.put("key1")("123", Option(Duration.Inf)).map { (Unit) =>
        scalacache.get("key1".getBytes("utf-8"))
      }
    }, Duration.Inf)
    println(result)
    scalacache.put("1")(123, None)
    println(scalacache.get("1"))

    // val endCacheGet = new DateTime()
    // println(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(endCacheGet))
    println("Hello, world!")
  }
}
