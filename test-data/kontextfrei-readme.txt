What is this?

This library enables you to write the business logic of your Spark application without depending on RDDs and the SparkContext.

Motivation

Why you would want to do that? Because firing up a SparkContext and running your unit tests in a local Spark cluster is really slow. kontextfrei frees you from this hard dependency on a SparkContext, ultimately leading to a much faster feedback cycle during development.

Documentation

Please visit the kontextfrei website to learn more about how to use this library.

For an example that showcases how the library can be used, please have a look at kontextfrei-example.

Usage

The library is split up into two modules:

kontextfrei-core: You definitely need this to use the library
kontextfrei-scalatest: Some optional goodies to make testing your application logic easier and remove some boilerplate; this comes with a transitive dependency on ScalaTest and ScalaCheck.
kontextfrei assumes that the Spark dependency is provided by your application, so have to explicitly add a dependency to Spark.

Currently, kontextfrei binary releases are built against Spark 1.4.1, Spark 2.0.0, and Spark 2.1.0 , each of them both for Scala 2.11 and Scala 2.10.

Adding a dependency on the the current version of kontextfrei-core and kontextfrei-scalatest to your build.sbt looks like this:

Spark 1.4.1

resolvers += "dwestheide" at "https://dl.bintray.com/dwestheide/maven"
libraryDependencies += "com.danielwestheide" %% "kontextfrei-core-spark-1.4.1" % "0.5.0"
libraryDependencies += "com.danielwestheide" %% "kontextfrei-scalatest-spark-1.4.1" % "0.5.0"
libraryDependencies += "org.apache.spark" %% "spark-core" % "1.4.1" % "provided"
Spark 2.0

resolvers += "dwestheide" at "https://dl.bintray.com/dwestheide/maven"
libraryDependencies += "com.danielwestheide" %% "kontextfrei-core-spark-2.0.0" % "0.5.0"
libraryDependencies += "com.danielwestheide" %% "kontextfrei-scalatest-spark-2.0.0" % "0.5.0"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.0.0" % "provided"
Spark 2.1.0

resolvers += "dwestheide" at "https://dl.bintray.com/dwestheide/maven"
libraryDependencies += "com.danielwestheide" %% "kontextfrei-core-spark-2.1.0" % "0.5.0"
libraryDependencies += "com.danielwestheide" %% "kontextfrei-scalatest-spark-2.1.0" % "0.5.0"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.1.0" % "provided"
As you can see, you need the specify the Spark version against which the library is supposed to be built as part of the artifact name.

Status

This library is in an early stage and is not feature-complete: only a subset of the operations available on RDDs is supported so far

Contributions welcome

Any kind of contribution is welcome. Please see the Contribution Guidelines.