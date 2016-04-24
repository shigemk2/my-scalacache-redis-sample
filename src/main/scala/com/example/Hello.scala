package com.example

import org.joda.time.format.DateTimeFormat
import redis.clients.jedis._
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.concurrent.duration._
import scalacache._
import scalacache.redis.RedisCache

object Hello {
  def main(args: Array[String]): Unit = {
    val jedis = new Jedis("192.168.99.100", 6379)
    implicit val scalaCache = ScalaCache(RedisCache("192.168.99.100", 6379))
    jedis.set("key1", "123")
    println(scalaCache.cache.get("key1"))
    scalaCache.cache.put("key1", 123, Option(Duration.apply(60, MINUTES)))
    println(scalaCache.cache.get("key1"))
    println("Hello, world!")
  }
}
