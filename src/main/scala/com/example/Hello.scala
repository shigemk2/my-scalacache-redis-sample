package com.example

import com.github.jedis.lock.JedisLock
import redis.clients.jedis.Jedis

object Hello {
  def main(args: Array[String]): Unit = {
    val jedis = new Jedis("localhost")
    val lock = new JedisLock(jedis, "lockname", 10000, 30000)
    lock.acquire()
    try {
      // do some stuff
    }
    finally {
      lock.release()
    }
    println("Hello, world!")
  }
}
