package nsnp

import javafx.embed.swing.JFXPanel
import javax.swing.{ Action, JToolBar }
import org.netbeans.core.spi.multiview.{ CloseOperationState, MultiViewElement, MultiViewElementCallback }
import org.openide.awt.UndoRedo
import org.openide.util.Lookup
import scalafx.Includes._
import scalafx.application.Platform
import scalafx.scene.Scene
import scalafx.scene.control._

class ScalaFileVisualizer(lkp: Lookup) extends MultiViewElement {
  val obj = lkp.lookup(classOf[ScalaClassDataObject])
  assert(obj != null)
  val toolbar = new JToolBar()
  val component = new JFXPanel()
  val desugaredTextArea = new TextArea { editable = false }
  val astTextArea = new TextArea { editable = false }
  var multiViewCallback: MultiViewElementCallback = _
  Platform runLater {
    Platform.implicitExit = false
    component setScene new Scene {
      root = new TabPane {
        this += new Tab {
          text = "Desugared"
          closable = false
          content = desugaredTextArea
        }
        this += new Tab {
          text = "AST"
          closable = false
          content = astTextArea
        }
      }
    }.delegate
  }

  def canCloseElement() = CloseOperationState.STATE_OK

  def componentActivated(): Unit = {}
  def componentClosed(): Unit = {}
  def componentDeactivated(): Unit = {}
  def componentHidden(): Unit = {}
  def componentOpened(): Unit = {}
  def componentShowing(): Unit = {}

  def getActions(): Array[Action] = Array()
  def getLookup() = lkp
  def getToolbarRepresentation() = toolbar
  def getUndoRedo() = UndoRedo.NONE
  def getVisualRepresentation() = component
  def setMultiViewCallback(cb: MultiViewElementCallback): Unit = multiViewCallback = cb
}
