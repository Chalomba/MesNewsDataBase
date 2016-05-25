name := """MesNewsDatabase"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final",
  "org.jadira.usertype" % "usertype.jodatime" % "2.0.1",
  "org.postgresql" % "postgresql" % "9.4-1201-jdbc41",
  evolutions
)

herokuAppName in Compile := "mesnews"
PlayKeys.externalizeResources := false