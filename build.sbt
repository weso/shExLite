name := "shExLite"

version := "0.1"

lazy val scala212 = "2.12.10"
lazy val scala213 = "2.13.1"
scalaVersion in ThisBuild := scala213
crossScalaVersions := Seq(scala212, scala213)
scalacOptions ++= Seq("-encoding", "UTF-8")

Compile / scalaSource := baseDirectory.value / "src/compiler"
Compile / unmanagedSourceDirectories += baseDirectory.value / "src/lib"
Compile / unmanagedSourceDirectories += baseDirectory.value / "src/cli"

Test / unmanagedSourceDirectories += baseDirectory.value / "test/benchmark"
Test / unmanagedSourceDirectories += baseDirectory.value / "test/unit"

parallelExecution in Test := false

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging"   % "3.9.2"
libraryDependencies += "ch.qos.logback"              % "logback-classic" % "1.2.3"

libraryDependencies += "org.antlr"      % "antlr4"    % "4.9.2"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.1" % "test"

libraryDependencies ++= Seq(
  "org.backuity.clist" %% "clist-core"   % "3.5.1",
  "org.backuity.clist" %% "clist-macros" % "3.5.1" % "provided"
)

libraryDependencies += "org.wvlet.airframe" %% "airframe-log" % "20.9.0"
libraryDependencies += "io.cucumber" % "cucumber-core" % "2.4.0"
libraryDependencies += "io.cucumber" %% "cucumber-scala" % "6.1.1" % Test
libraryDependencies += "io.cucumber" % "cucumber-junit" % "6.7.0" % Test

coverageExcludedPackages := "compiler.es.weso.shexlc.parse.generated.*"
