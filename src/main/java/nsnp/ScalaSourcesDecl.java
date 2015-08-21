package nsnp;

import javax.swing.event.ChangeListener;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.SourceGroup;
import org.netbeans.api.project.Sources;
import org.netbeans.spi.project.ProjectServiceProvider;
import org.netbeans.spi.project.SourceGroupModifierImplementation;

@ProjectServiceProvider(service = {Sources.class, SourceGroupModifierImplementation.class}, projectType = "org-netbeans-modules-maven")
public class ScalaSourcesDecl implements Sources, SourceGroupModifierImplementation {

  private final ScalaSourcesImpl scalaSourcesImpl;

  public ScalaSourcesDecl(Project project) {
    scalaSourcesImpl = new ScalaSourcesImpl(project);
  }

//    @Override public SourceGroup[] getSourceGroups(String type) {
//        System.out.println(scala.Console$.MODULE$.RED() + "Checking type " + type + scala.Console$.MODULE$.RESET());
//        if (TYPE_SCALA.equals(type)) {
//            List<SourceGroup> groups = new ArrayList<SourceGroup>();
//            maybeAddGroup(groups, false);
//            maybeAddGroup(groups, true);
//            return groups.toArray(new SourceGroup[groups.size()]);
//        } else {
//            return new SourceGroup[0];
//        }
//    }
//
//    @NbBundle.Messages({
//        "SG_ScalaSources=Scala Packages",
//        "SG_Test_ScalaSources=Scala Test Packages"
//    })
//    private void maybeAddGroup(List<SourceGroup> groups, boolean test) {
//        //XXX we should consult the maven project configuration as well
//        FileObject root = project.getProjectDirectory().getFileObject("src/" + (test ? "test" : "main") + "/scala");
//        if (root != null) {
//            groups.add(GenericSources.group(project, root, test ? NAME_SCALATESTSOURCE : NAME_SCALASOURCE, test ?
//                    "Scala test sources" : "Scala sources", null, null));
//        }
//    }
//
//    @Override public void addChangeListener(ChangeListener listener) {
//        // XXX listen to creation/deletion of roots
//    }
//
//    @Override public void removeChangeListener(ChangeListener listener) {}
//
//    @Override public SourceGroup createSourceGroup(String type, String hint) {
//        System.out.println(scala.Console$.MODULE$.RED() + "Creating sourceGroup " + type + " " + hint + type + scala.Console$.MODULE$.RESET());
//        // XXX this looks weird, cannot tell where something is created..
//        if (!canCreateSourceGroup(type, hint)) {
//            return null;
//        }
//        List<SourceGroup> groups = new ArrayList<SourceGroup>();
//        maybeAddGroup(groups, JavaProjectConstants.SOURCES_HINT_TEST.equals(hint));
//        return groups.isEmpty() ? null : groups.get(0);
//    }
//
//    @Override public boolean canCreateSourceGroup(String type, String hint) {
//        System.out.println(scala.Console$.MODULE$.RED() + "Checking canCreateSourceGroup " + type + " " + hint + scala.Console$.MODULE$.RESET());
//        return TYPE_SCALA.equals(type) && (JavaProjectConstants.SOURCES_HINT_MAIN.equals(hint) || JavaProjectConstants.SOURCES_HINT_TEST.equals(hint));
//    }

  @Override
  public SourceGroup createSourceGroup(String tpe, String hint) {
    return scalaSourcesImpl.createSourceGroup(tpe, hint);
  }

  @Override
  public boolean canCreateSourceGroup(String tpe, String hint) {
    return scalaSourcesImpl.canCreateSourceGroup(tpe, hint);
  }

  @Override
  public void removeChangeListener(ChangeListener l) {
    scalaSourcesImpl.removeChangeListener(l);
  }

  @Override
  public void addChangeListener(ChangeListener l) {
    scalaSourcesImpl.addChangeListener(l);
  }

  @Override
  public SourceGroup[] getSourceGroups(String tpe) {
    return scalaSourcesImpl.getSourceGroups(tpe);
  }
}
