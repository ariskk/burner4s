import Dependencies._

lazy val scala212 = "2.12.13"
lazy val scala213 = "2.13.4"
lazy val scala3 = "3.0.0"
lazy val supportedScalaVersions = List(scala212, scala213, scala3)

lazy val root = (project in file("."))
  .settings(
    commonSettings,
    publishingSettings
  )

lazy val commonSettings = Seq(
  name := "burner4s",
  libraryDependencies += scalaTest % Test,
  crossScalaVersions := supportedScalaVersions,
  scalaVersion := scala3,
  scalacOptions ++= Seq(
    "-deprecation"
  )
)

import ReleaseTransformations._

lazy val publishingSettings = Seq(
  organization := "com.ariskk",
  organizationName := "ariskk",
  organizationHomepage := Some(url("http://ariskk.com/")),
  scmInfo := Some(
    ScmInfo(
      url("https://github.com/ariskk/burner4s"),
      "scm:git@github.com:ariskk/burner4s.git"
    )
  ),
  developers := List(
    Developer(
      id    = "ariskk",
      name  = "Aris Koliopoulos",
      email = "aris@ariskk.com",
      url   = url("http://ariskk.com")
    )
  ),
  description := "Burner email look up tool",
  licenses := List("MIT" -> new URL("http://opensource.org/licenses/MIT")),
  homepage := Some(url("https://github.com/ariskk/burner4s")),
  pomIncludeRepository := { _ => false },
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
    else Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  publishMavenStyle := true,
  releaseProcess := Seq[ReleaseStep](
    inquireVersions,
    runClean,
    runTest,
    setReleaseVersion,
    commitReleaseVersion,
    tagRelease,
    publishArtifacts,
    setNextVersion,
    commitNextVersion,
    ReleaseStep(action = Command.process("sonatypeReleaseAll", _)),
    pushChanges
  )
)
