package com.example

import redis.clients.jedis._

import scalacache._
import scalacache.redis.RedisCache
import scalaz.Cord

object SetRedis {
  def main(args: Array[String]): Unit = {
    val jedis = new Jedis("192.168.99.100", 6379)
    for (i <- 1 to 100000) {
      val v = new scala.util.Random(new java.security.SecureRandom()).nextInt(10000)
      println(i, v)
      jedis.set(i.toString, v.toString)
    }
    println("Hello, world!")
  }
}
