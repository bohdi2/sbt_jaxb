name := """jaxb"""

version := "1.0"

scalaVersion := "2.11.7"

unmanagedResourceDirectories in Compile := Seq(baseDirectory.value / "server/xsd")

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"
