package com.example.akkacamel

import akka.actor.{ActorSystem, Props}
import akka.camel.CamelExtension

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.concurrent.duration._

object ApplicationMain extends App {

  val system = ActorSystem()
  val camel = CamelExtension(system)

  val stdOutProducer = system.actorOf(Props[StdOutProducer])

  camel.activationFutureFor(stdOutProducer)(
    timeout = 10 seconds, executor = system.dispatcher
  )

  val stdInConsumer = system.actorOf(Props(classOf[StdInConsumer], stdOutProducer))

  camel.activationFutureFor(stdInConsumer)(
    timeout = 10 seconds, executor = system.dispatcher
  )

  Await.result(system.whenTerminated, Duration.Inf)
}