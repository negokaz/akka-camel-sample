name := """akka-camel-sample"""

version := "1.0"

scalaVersion := "2.12.0"

val akkaVersion = "2.4.14"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  // Camel
  "com.typesafe.akka" %% "akka-camel" % akkaVersion,
  "org.apache.camel" % "camel-stream" % "2.18.0",
  // Logging
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "ch.qos.logback" % "logback-classic" % "1.1.3"
)
