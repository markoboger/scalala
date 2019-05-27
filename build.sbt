name          := "scalala"
organization  := "de.htwg"
version       := "0.0.1"
scalaVersion  := "2.12.7"
scalacOptions := Seq("-unchecked", "-feature", "-deprecation", "-encoding", "utf8")

resolvers += Resolver.jcenterRepo

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"

libraryDependencies ++= {
  Seq(
		"com.typesafe.akka" %% "akka-actor" % "2.5.23",
		"com.typesafe.akka" %% "akka-testkit" % "2.5.23" % Test
		)
}
