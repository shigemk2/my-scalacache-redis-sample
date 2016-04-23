package com.example

import redis.clients.jedis._
import scalacache._
import scalacache.redis.RedisCache

import scalaz.Cord

object Hello {
  def main(args: Array[String]): Unit = {
    val jedis = new Jedis("192.168.99.100", 6379)
    implicit val scalaCache = ScalaCache(RedisCache("192.168.99.100", 6379))
    val k = Cord(new scala.util.Random(new java.security.SecureRandom()).alphanumeric.take(10).mkString)
    val v = new scala.util.Random(new java.security.SecureRandom()).nextInt(10000)
    println(k, v)
    jedis.set(k.toString, v.toString)
    println("Hello, world!")
  }
}
