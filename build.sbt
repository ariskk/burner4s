import Dependencies._

lazy val scala212 = "2.12.10"
lazy val scala213 = "2.13.3"
lazy val supportedScalaVersions = List(scala212, scala213)

ThisBuild / scalaVersion     := "2.13.3"
ThisBuild / version          := "0.1.0"
ThisBuild / organization     := "com.ariskk"
ThisBuild / organizationName := "ariskk"

lazy val root = (project in file("."))
  .settings(
    name := "burner4s",
    libraryDependencies += scalaTest % Test,
    crossScalaVersions := supportedScalaVersions
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
