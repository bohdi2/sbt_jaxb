name := """jaxb"""

version := "1.0"

scalaVersion := "2.11.7"

val gitHeadCommitSha = taskKey[String] {"Blag blag"}

val makeVersionProperties = taskKey[Seq[File]] {"Makes a version.properties file."}


gitHeadCommitSha := Process("git rev-parse HEAD").lines.head

makeVersionProperties := {
  val propsFile = new File((resourceManaged in Compile).value, 
                           "version.properties")
  val content = "version=%s" format (gitHeadCommitSha.value)
  IO.write(propsFile, content)
  Seq(propsFile)
}

resourceGenerators in Compile <+= makeVersionProperties

unmanagedResourceDirectories in Compile := Seq(baseDirectory.value / "server/xsd")

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"
