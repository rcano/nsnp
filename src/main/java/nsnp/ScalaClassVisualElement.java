package nsnp;

import javafx.embed.swing.JFXPanel;
import javax.swing.Action;
import javax.swing.JToolBar;
import org.netbeans.core.spi.multiview.CloseOperationState;
import org.netbeans.core.spi.multiview.MultiViewElement;
import org.netbeans.core.spi.multiview.MultiViewElementCallback;
import org.openide.awt.UndoRedo;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

@MultiViewElement.Registration(
        displayName = "#LBL_ScalaClass_VISUAL",
        iconBase = "nsnp/scala-file-icon-16x16.png",
        mimeType = "text/x-scala",
        persistenceType = TopComponent.PERSISTENCE_NEVER,
        preferredID = "ScalaClassVisual",
        position = 2000
)
@Messages("LBL_ScalaClass_VISUAL=Visual")
public final class ScalaClassVisualElement implements MultiViewElement {

  private final ScalaFileVisualizer visualizer;

  public ScalaClassVisualElement(Lookup lkp) {
    visualizer = new ScalaFileVisualizer(lkp);
  }

  @Override
  public void setMultiViewCallback(MultiViewElementCallback cb) {
    visualizer.setMultiViewCallback(cb);
  }

  @Override
  public JFXPanel getVisualRepresentation() {
    return visualizer.getVisualRepresentation();
  }

  @Override
  public UndoRedo getUndoRedo() {
    return visualizer.getUndoRedo();
  }

  @Override
  public JToolBar getToolbarRepresentation() {
    return visualizer.getToolbarRepresentation();
  }

  @Override
  public Lookup getLookup() {
    return visualizer.getLookup();
  }

  @Override
  public Action[] getActions() {
    return (Action[]) (Object) visualizer.getActions();
  }

  @Override
  public void componentShowing() {
    visualizer.componentShowing();
  }

  @Override
  public void componentOpened() {
    visualizer.componentOpened();
  }

  @Override
  public void componentHidden() {
    visualizer.componentHidden();
  }

  @Override
  public void componentDeactivated() {
    visualizer.componentDeactivated();
  }

  @Override
  public void componentClosed() {
    visualizer.componentClosed();
  }

  @Override
  public void componentActivated() {
    visualizer.componentActivated();
  }

  @Override
  public CloseOperationState canCloseElement() {
    return visualizer.canCloseElement();
  }

}
