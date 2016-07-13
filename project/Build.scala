/**
 * Copyright (c) 2013 Mark S. Kolich
 * http://mark.koli.ch
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

import sbt._
import sbt.Keys._

import com.earldouglas.xsbtwebplugin._
import PluginKeys._
import WebPlugin._
import WebappPlugin._

import com.typesafe.sbteclipse.plugin.EclipsePlugin._

object Dependencies {
  //val jettyVersion = "9.1.5.v20140505"
  val jettyVersion = "8.1.10.v20130312"
  // Internal dependencies

  private val useScalaVersion = "2.11.8" //"2.11.6"
  private val scalajs ="org.scala-js" % "scalajs-dom_sjs0.6_2.11" % "0.9.0"  % "compile"
  private val lihoyi = "com.lihaoyi" %% "utest" % "0.3.0" % "test"

  private val parboiled = "org.parboiled" %% "parboiled-scala" % "1.1.7" % "compile"
  private val shapeless = "com.chuusai" %% "shapeless" % "1.2.4" % "compile"

  //private val kolichCommon = "com.kolich" % "kolich-common" % "0.1.0" % "compile"

  private val gson = "com.google.code.gson" % "gson" % "2.2.4" % "compile"

  private val compiler = "org.scala-lang" % "scala-compiler" % useScalaVersion  % "compile"
  private val library = "org.scala-lang" % "scala-library" % useScalaVersion  % "compile"
  private val reflect = "org.scala-lang" % "scala-reflect" % useScalaVersion  % "compile"

  // External dependencies`

  private val scalaxml = "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.5"

  // Using Jetty 8 "stable", version 8.1.8.v20121106
  private val jettyWebApp = "org.eclipse.jetty" % "jetty-webapp" % jettyVersion % "container"
  private val jettyPlus = "org.eclipse.jetty" % "jetty-plus" % jettyVersion % "container"
  private val jettyJsp = "org.eclipse.jetty" % "jetty-jsp" % jettyVersion % "container"

  
  private val jspApi = "javax.servlet.jsp" % "jsp-api" % "2.2" % "provided" // Provided by container  
  private val jstl = "javax.servlet" % "jstl" % "1.2" % "compile" // Package with WAR
  private val servlet = "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided" // Provided by container
  
  //private val findbugs = "com.google.code.findbugs" % "jsr305" % "2.0.1" % "compile"
  
  private val logback = "ch.qos.logback" % "logback-core" % "1.1.7" % "compile"
  private val logbackClassic = "ch.qos.logback" % "logback-classic" % "1.1.7" % "compile" // An Slf4j impl
  private val slf4j = "org.slf4j" % "slf4j-api" % "1.7.20" % "compile"
  private val jclOverSlf4j = "org.slf4j" % "jcl-over-slf4j" % "1.6.6" % "compile"
  
  private val slf4s = "org.slf4s" %% "slf4s-api" % "1.7.13" % "compile" // Meh, forcing 2.9.1 version

  private val scalalog = "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"
  private val akkaActor = "com.typesafe.akka" %% "akka-actor" % "2.4.7" % "compile"
  private val akkaSlf4j = "com.typesafe.akka" %% "akka-slf4j" % "2.4.7" % "compile"
  
  private val sprayRouting = "io.spray" %% "spray-routing" % "1.3.3" % "compile"
  private val sprayServlet = "io.spray" %% "spray-servlet" % "1.3.3" % "compile"
  private val sprayJson = "io.spray" %% "spray-json" % "1.3.2" % "compile"
  
  private val scalate = "org.scalatra.scalate" %% "scalate-core" % "1.7.0" % "compile"
  private val scalatexitrum = "tv.cntt" %% "xitrum-scalate" % "2.5"
  private val commonsLang3  = "org.apache.commons" % "commons-lang3" % "3.1" % "compile"
  
  val deps = Seq(jettyWebApp, jettyPlus, jettyJsp, scalalog, slf4s,
    jspApi, jstl, servlet, scalaxml, compiler,
    library, reflect, parboiled,
    logback, logbackClassic, slf4j, jclOverSlf4j,
    akkaActor, akkaSlf4j, shapeless,
    sprayServlet, sprayJson, sprayRouting,
    scalate, scalajs, lihoyi,
    commonsLang3)
}

object Resolvers {

  private val kolichRepo = "Kolich repo" at "http://markkolich.github.com/repo"
  private val sprayRepo = "spray repo" at "http://repo.spray.io"
  private val clouderaRepo = "cloudera-repo-releases" at "https://repository.cloudera.com/artifactory/repo/"

  val depResolvers = Seq(kolichRepo, sprayRepo, clouderaRepo)

}




object SprayServletWebapp extends Build {

  import Dependencies._
  import Resolvers._

  private val aName = "spray-servlet-webapp"
  private val aVer = "1.0"
  private val aOrg = "com.vantiv"

  lazy val sprayServletWebapp: Project = Project(
    aName,
    new File("."),
    settings = Defaults.defaultSettings ++ Seq(resolvers := depResolvers) ++ Seq(
      version := aVer,
      organization := aOrg,
      scalaVersion := "2.11.8",
      scalacOptions ++= Seq("-Ylog-classpath"),
      javacOptions ++= Seq("-source", "1.8"),
      scalaHome := Some(file("/Program Files (x86)/scala/")),
      ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) },
      shellPrompt := { (state: State) => { "%s:%s> ".format(aName, aVer) } },
      // True to export the packaged JAR instead of just the compiled .class files.
      exportJars := true,
      // Disable using the Scala version in output paths and artifacts.
      // When running 'publish' or 'publish-local' SBT would append a
      // _<scala-version> postfix on artifacts. This turns that postfix off.
      crossPaths := false,
      // Not a "Java" project at this time.
      unmanagedSourceDirectories in Compile <<= baseDirectory(new File(_, "src/main/scala"))(Seq(_)),
      unmanagedSourceDirectories in Test <<= baseDirectory(new File(_, "src/test/scala"))(Seq(_)),
      // Tell SBT to include our .scala files when packaging up the source JAR.
      unmanagedSourceDirectories in Compile in packageSrc <<= baseDirectory(new File(_, "src/main/scala"))(Seq(_)),
      // Override the SBT default "target" directory for compiled classes.
      classDirectory in Compile <<= baseDirectory(new File(_, "target/classes")),
      // Add the local 'config' directory to the classpath at runtime,
      // so anything there will ~not~ be packaged with the application deliverables.
      // Things like application configuration .properties files go here in
      // development and so these will not be packaged+shipped with a build.
      // But, they are still available on the classpath during development,
      // like when you run Jetty via the xsbt-web-plugin that looks for some
      // configuration file or .properties file on the classpath.
      unmanagedClasspath in Runtime <+= (baseDirectory) map { bd => Attributed.blank(bd / "config") },
      // Do not bother trying to publish artifact docs (scaladoc, javadoc). Meh.
      publishArtifact in packageDoc := false,
      // Override the global name of the artifact.
      artifactName <<= (name in (Compile, packageBin)) { projectName =>
        (config: ScalaVersion, module: ModuleID, artifact: Artifact) =>
          var newName = projectName
          if (module.revision.nonEmpty) {
            newName += "-" + module.revision
          }
          newName + "." + artifact.extension
      },
      // Override the default 'package' path used by SBT. Places the resulting
      // JAR into a more meaningful location.
      artifactPath in (Compile, packageBin) ~= { defaultPath =>
        file("dist") / defaultPath.getName
      },
      // Override the default 'test:package' path used by SBT. Places the
      // resulting JAR into a more meaningful location.
      artifactPath in (Test, packageBin) ~= { defaultPath =>
        file("dist") / "test" / defaultPath.getName
      },
      libraryDependencies ++= deps,
      retrieveManaged := true) ++
      // xsbt-web-plugin settings
      webSettings ++
      // xsbt-web-plugin overrides
      Seq(
          // Overrides the default context path used for this project.  By
          // default, the context path is "/", but here we're overriding that
          // configuration so the application is available under "/spray"
          // instead.  Note that this maps directly to the "webapp.context"
          // configuration property in our root "application.conf".
          apps in container.Configuration <<= (deployment in DefaultConf) map {
        	  d => Seq("/spray" -> d)
          },
	      warPostProcess in Compile <<= (target) map {
	        // Ensures the src/main/webapp/WEB-INF/work directory is NOT included
	        // in the packaged WAR file.  This is a temporary directory used by
	        // the application and servlet container in development that should
	        // not be shipped with a build.
	        (target) => { () => {
		      val webinf = target / "webapp" / "WEB-INF"
		      IO.delete(webinf / "work") // recursive
	        }}
	      },
	      // Change the location of the packaged WAR file as generated by the
	      // xsbt-web-plugin.
	      artifactPath in (Compile, packageWar) ~= { defaultPath =>
	        file("dist") / defaultPath.getName
	      }
      ) ++
      Seq(EclipseKeys.createSrc := EclipseCreateSrc.Default,
        // Make sure SBT also fetches/loads the "src" (source) JAR's for
        // all declared dependencies.
        EclipseKeys.withSource := true))

	sprayServletWebapp.enablePlugins(ScalaJSPlugin)
}
