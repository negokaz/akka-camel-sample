package com.example.akkacamel

import akka.actor.{ActorLogging}
import akka.camel.{Oneway, Producer}


class StdOutProducer extends Producer with Oneway with ActorLogging {
  override def endpointUri = "stream:out"

  override def transformOutgoingMessage(msg: Any) = msg match {
    case msg: String => msg.toUpperCase
    case msg         => msg
  }
}
