name := "Chairman"

version := "0.1.0-SNAPSHOT"

organization := "com.postneo"

scalaVersion := "2.9.0-1"

scalacOptions ++= Seq("-deprecation", "-unchecked")

resolvers ++= Seq(
  "Sonatype"    at  "http://nexus.scala-tools.org/content/repositories/public",
  "Scala Tools" at  "http://scala-tools.org/repo-snapshots/",
   "JBoss" 	at  "http://repository.jboss.org/nexus/content/groups/public/",
   "Akka"       at  "http://akka.io/repository/",
   "Guice"      at "http://guiceyfruit.googlecode.com/svn/repo/releases/"
)

libraryDependencies ++= Seq(
  "com.reportgrid" % "blueeyes_2.9.0-1" % "0.4.4" % "compile"
)
