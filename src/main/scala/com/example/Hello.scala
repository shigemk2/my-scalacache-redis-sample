package com.example

import com.github.jedis.lock.JedisLock
import redis.clients.jedis.Jedis
import com.nicta.rng.{Rng, Size}
import scala.util.Random

import scalaz.Cord
import scalaz.syntax.monad._

object Hello {
  def main(args: Array[String]): Unit = {
    val jedis = new Jedis("192.168.99.101")
    val lock = new JedisLock(jedis, "lockname", 10000, 30000)
    lock.acquire()
    try {
      val k = Cord(new scala.util.Random(new java.security.SecureRandom()).alphanumeric.take(10).mkString)
      val v = new scala.util.Random(new java.security.SecureRandom()).nextInt(10000)
      println(k, v)
      jedis.set(k.toString, v.toString)
    }
    finally {
      lock.release()
    }
    println("Hello, world!")
  }
}
