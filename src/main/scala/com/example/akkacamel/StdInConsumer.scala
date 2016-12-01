package com.example.akkacamel

import akka.actor.{ActorLogging, ActorRef}
import akka.camel.{CamelMessage, Consumer}

class StdInConsumer(stdOutProducer: ActorRef) extends Consumer with ActorLogging {

  override def endpointUri = "stream:in"

  override def receive = {

    case msg: CamelMessage =>
      stdOutProducer ! s"Hello, ${msg.body}!"
  }
}
