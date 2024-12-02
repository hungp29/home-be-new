import com.typesafe.config.ConfigFactory
import scala.sys.process.Process

name := """home-be"""
organization := "com.momo.family.home"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala, FlywayPlugin)
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
//  .settings(
//    flywayUrl := flywayDbConfig.getString("flyway.url"),
//    flywayUser := flywayDbConfig.getString("flyway.user"),
//    flywayPassword := flywayDbConfig.getString("flyway.password"),
//    flywaySchemas := Seq(flywayDbConfig.getString("flyway.schema"))
//  )

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

// Flyway
libraryDependencies += "org.flywaydb" % "flyway-core" % Common.flywaydbVersion

//libraryDependencies ++= Seq(
//  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.14.3",
//  "com.fasterxml.jackson.core" % "jackson-databind" % "2.14.3"
//)

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

//flywayUrl := "jdbc:postgresql://localhost:5432/home-pg-new"
//flywayUser := "postgres"
//flywayPassword := "123456"
//flywayLocations += "org.flywaydb.sample.migration"
//flywaySchemas := Seq("general")

// Task to run Flyway migrations
//lazy val databaseConfig = {
//  val config = ConfigFactory.parseFile(new java.io.File("conf/application.conf"))
//  val db = config.getConfig("flyway")
//  Map(
//    "flyway.url" -> db.getString("url"),
//    "flyway.user" -> db.getString("user"),
//    "flyway.password" -> db.getString("password"),
//    "flyway.schemas" -> db.getStringList("schemas")
//  )
//}

lazy val flywayDbConfig = {
  val config = ConfigFactory.parseFile(new java.io.File("conf/application.conf"))
  val flyway = config.getConfig("flyway")

  println(flyway)

  flyway
}
//
//root.settings(
//  flywayUrl := flywayDbConfig.getString("flyway.url"),
//  flywayUser := flywayDbConfig.getString("flyway.user"),
//  flywayPassword := flywayDbConfig.getString("flyway.password")
////  flywaySchemas := Seq(databaseConfig("flyway.schemas"))
//)
