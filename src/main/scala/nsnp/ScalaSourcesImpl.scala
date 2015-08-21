package nsnp

import javax.swing.event.ChangeListener
import org.netbeans.api.project.{ Project, SourceGroup, Sources }
import org.netbeans.spi.project.SourceGroupModifierImplementation
import org.netbeans.spi.project.support.GenericSources

class ScalaSourcesImpl(project: Project) extends Sources with SourceGroupModifierImplementation {
  val NAME_SCALASOURCE = "91ScalaSourceRoot";
  val NAME_SCALATESTSOURCE = "92ScalaTestSourceRoot";

  private var once = 0
  override def getSourceGroups(tpe: String): Array[SourceGroup] = {
    println(Console.BLUE + s"being queried about $tpe" + Console.RESET)
    //    val res: Array[SourceGroup] = if (tpe == Sources.TYPE_GENERIC && once <= 3) {
    //      println("processing once " + once)
    once += 1
    val srcScala = (project.getProjectDirectory.getFileObject("src/main/scala"), NAME_SCALASOURCE, "Scala Source Packages")
    val testScala = (project.getProjectDirectory.getFileObject("src/test/scala"), NAME_SCALATESTSOURCE, "Scala Test Packages")
    Array(srcScala, testScala).filter(t => t._1 != null).map(t =>
      GenericSources.group(project, t._1, t._2, t._3, null, null))
    //    } else {
    //      println("elsing")
    //      Array.empty
    //    }
    //    println(Console.RED + s"returning ${res.mkString(", ")}" + Console.RESET)
    //    res
  }

  override def addChangeListener(l: ChangeListener): Unit = {}
  override def removeChangeListener(l: ChangeListener): Unit = {}

  override def canCreateSourceGroup(tpe: String, hint: String): Boolean = {
    println(Console.RED + s"Can create source group $tpe  $hint" + Console.RESET)
    false
  }
  override def createSourceGroup(tpe: String, hint: String): SourceGroup = null
}
