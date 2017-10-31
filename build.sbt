val kontextfreiVersion = "0.6.0"
val spark                = "org.apache.spark"    %% "spark-core"                        % "2.2.0"
val scalatest            = "org.scalatest"       %% "scalatest"                         % "3.0.4" % "test,it"
val scalacheck           = "org.scalacheck"      %% "scalacheck"                        % "1.13.4" % "test,it"
val kontextfreiCore      = "com.danielwestheide" %% "kontextfrei-core-spark-2.2.0"      % kontextfreiVersion
val kontextfreiScalaTest = "com.danielwestheide" %% "kontextfrei-scalatest-spark-2.2.0" % kontextfreiVersion % "test,it"

scalaVersion := "2.11.8"

lazy val ItTest = config("it") extend Test

scalacOptions ++= Seq("-feature", "-language:higherKinds", "-language:implicitConversions")

resolvers += "dwestheide" at "https://dl.bintray.com/dwestheide/maven"
libraryDependencies ++= Seq(kontextfreiCore, kontextfreiScalaTest, spark)

configs(ItTest)
inConfig(ItTest)(Defaults.testSettings)

parallelExecution in ItTest := false

test in assembly := {}
mainClass in assembly := Some("com.danielwestheide.kontextfrei.wordcount.Main")
assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)
