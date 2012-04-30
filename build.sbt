name := "emrscala"
    
version := "0.0.1-SNAPSHOT"
    
scalaVersion := "2.9.1"

resolvers += "Scala Tools Snapshots" at "http://scala-tools.org/repo-releases/"

libraryDependencies ++= Seq(
  "org.apache.hadoop" % "hadoop-core" % "0.20.205.0"
)

seq(ProguardPlugin.proguardSettings :_*)

proguardOptions += keepMain("MainTest")