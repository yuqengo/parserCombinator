name := "parserCombinator"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
// https://mvnrepository.com/artifact/org.mockito/mockito-core
libraryDependencies += "org.mockito" % "mockito-core" % "2.22.0" % Test
// matchでcaseが足りない時にコンパイルエラーにする
scalacOptions ++= Seq("-Xfatal-warnings")