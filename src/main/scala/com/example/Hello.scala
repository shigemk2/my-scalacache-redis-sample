package com.example

import com.github.jedis.lock.JedisLock
import redis.clients.jedis.Jedis
import com.nicta.rng.{Rng, Size}
import scalaz.syntax.monad._

object Hello {
  def main(args: Array[String]): Unit = {
    // val jedis = new Jedis("192.168.99.100")
    // val lock = new JedisLock(jedis, "lockname", 10000, 30000)
    // lock.acquire()
    // try {
    //   val rngInt: Rng[Int] = Rng.int
    //   val rngStr: Rng[String] = Rng.string(Size(10))
    //   val kv: Rng[(Int, String)] = for {
    //     k <- rngInt
    //     v <- rngStr
    //   } yield (k, v)
    //   // do some stuff
    //   kv.iterateUntil {
    //     case (k, v) => k < 10
    //   }.map {
    //     case (k, v) => {
    //       println(k)
    //       println(v)
    //       jedis.set(k.toString, v)
    //     }
    //   }
    // }
    // finally {
    //   lock.release()
    // }
    val rngInt: Rng[String] = Rng.string(Size(10))
    val rngStr: Rng[String] = Rng.string(Size(10))
    val kv: Rng[(String, String)] = for {
      k <- rngInt
      v <- rngStr
    } yield (k, v)
    kv.iterateUntil {
      case (k, v) => k.length < 5
    }.map {
      case (k, v) => {
        println(k)
        println(v)
      }
    }
    println("Hello, world!")
  }
}
