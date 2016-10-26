name          := "scalala"
organization  := "de.htwg"
version       := "0.0.1"
scalaVersion  := "2.11.8"
scalacOptions := Seq("-unchecked", "-feature", "-deprecation", "-encoding", "utf8")

resolvers += Resolver.jcenterRepo

libraryDependencies ++= {
  val scalaTestV       = "3.0.0-M15"
  val scalaMockV       = "3.2.2"
  Seq(
    "org.scalatest" %% "scalatest"                   % scalaTestV       % "test",
    "org.scalamock" %% "scalamock-scalatest-support" % scalaMockV       % "test",
    "com.typesafe.akka" %% "akka-actor" % "2.4.11",
	"com.typesafe.akka" %% "akka-agent" % "2.4.11",
	"com.typesafe.akka" %% "akka-camel" % "2.4.11",
	"com.typesafe.akka" %% "akka-cluster" % "2.4.11",
	"com.typesafe.akka" %% "akka-cluster-metrics" % "2.4.11",
	"com.typesafe.akka" %% "akka-cluster-sharding" % "2.4.11",
	"com.typesafe.akka" %% "akka-cluster-tools" % "2.4.11",
	"com.typesafe.akka" %% "akka-contrib" % "2.4.11",
	"com.typesafe.akka" %% "akka-http-core" % "2.4.11",
	"com.typesafe.akka" %% "akka-http-testkit" % "2.4.11",
	"com.typesafe.akka" %% "akka-multi-node-testkit" % "2.4.11",
	"com.typesafe.akka" %% "akka-osgi" % "2.4.11",
	"com.typesafe.akka" %% "akka-persistence" % "2.4.11",
	"com.typesafe.akka" %% "akka-persistence-tck" % "2.4.11",
	"com.typesafe.akka" %% "akka-remote" % "2.4.11",
	"com.typesafe.akka" %% "akka-slf4j" % "2.4.11",
	"com.typesafe.akka" %% "akka-stream" % "2.4.11",
	"com.typesafe.akka" %% "akka-stream-testkit" % "2.4.11",
	"com.typesafe.akka" %% "akka-testkit" % "2.4.11",
	"com.typesafe.akka" %% "akka-distributed-data-experimental" % "2.4.11",
	"com.typesafe.akka" %% "akka-typed-experimental" % "2.4.11",
	"com.typesafe.akka" %% "akka-http-experimental" % "2.4.11",
	"com.typesafe.akka" %% "akka-http-jackson-experimental" % "2.4.11",
	"com.typesafe.akka" %% "akka-http-spray-json-experimental" % "2.4.11",
	"com.typesafe.akka" %% "akka-http-xml-experimental" % "2.4.11",
	"com.typesafe.akka" %% "akka-persistence-query-experimental" % "2.4.11"
  )
}
