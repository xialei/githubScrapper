resolvers ++= Seq(
  Resolver.sonatypeRepo("snapshots")
)

name := "githubScrapper"

version := "0.0.1"

scalaVersion := "2.11.5"

mainClass in(Compile, run) := Some("com.aug3.githubScrapper.api.WebServer")

ivyScala := ivyScala.value map {
  _.copy(overrideScalaVersion = true)
}

libraryDependencies ++= Seq(
  "com.github.finagle" %% "finch-core" % "0.8.0",
  "com.github.finagle" %% "finch-argonaut" % "0.8.0",
  "com.twitter" % "finagle-redis_2.11" % "6.29.0",

  "net.databinder" % "dispatch-jsoup_2.11" % "0.8.10",
  "net.databinder.dispatch" % "dispatch-lift-json_2.11" % "0.11.3",
  //  "net.liftweb" %% "lift-json" % "2.6+",
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.3",
  "org.json4s" %% "json4s-native" % "3.3.0",

  "com.github.nscala-time" %% "nscala-time" % "2.2.0",
  "com.beachape.metascraper" % "metascraper_2.11" % "0.2.8",
  "com.ning" % "async-http-client" % "1.9.3",

  "com.typesafe" % "config" % "1.2.1",
  "com.typesafe.akka" %% "akka-actor" % "2.4.0",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)
