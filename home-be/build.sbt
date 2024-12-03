import scala.sys.process.Process

name := """home-be"""
organization := "com.momo.family.home"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    Compile / unmanagedSourceDirectories ++= Seq(
      baseDirectory.value / "app",
      baseDirectory.value / "src" / "main" / "scala",
      baseDirectory.value / "src" / "main" / "jooq"
    ),
    Compile / unmanagedResourceDirectories ++= Seq(
      baseDirectory.value / "conf",
      baseDirectory.value / "src" / "main" / "resources"
    )
  )

scalaVersion := "2.13.15"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test

// Database and Connection Pool
libraryDependencies ++= Seq(
  "org.postgresql" % "postgresql" % Common.postgresVersion,
  "com.zaxxer" % "HikariCP" % Common.hikariCPVersion,
  "com.typesafe.play" %% "play-jdbc" % Common.playJdbcVersion
)

// Jooq
libraryDependencies ++= Seq(
  "org.jooq" % "jooq" % Common.jooqVersion,
  "org.jooq" % "jooq-meta" % Common.jooqVersion,
  "org.jooq" % "jooq-codegen" % Common.jooqVersion
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.momo.family.home.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.momo.family.home.binders._"

// Task to run JOOQ code generation
lazy val jooqCodegen = taskKey[Unit]("Run JOOQ code generation")
jooqCodegen := {
  val codegenConfig = baseDirectory.value / "jooq-codegen.xml"
  val cp = (Compile / dependencyClasspath).value.files.mkString(":")

  val command = Seq("java", "-classpath", cp, "org.jooq.codegen.GenerationTool", codegenConfig.getAbsolutePath)

  val exitCode = Process(command).!

  if (exitCode != 0) {
    sys.error("JOOQ Codegen failed!")
  } else {
    println("JOOQ Codegen completed successfully!")
  }
}
