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
    val jedis = new JedisPool("192.168.99.100", 6379)
    implicit val scalaCache = ScalaCache(RedisCache(jedis))
    jedis.getResource.set("key1", "foo")
    // scalaCache.cache.put("key1", "foo", None)
    Thread.sleep(5000)
    println(scalaCache.cache.get("key1"))
    // println(jedis.getResource.get("key1"))
    println("Hello, world!")
  }
}
