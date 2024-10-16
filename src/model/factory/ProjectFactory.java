package model.factory;

import model.workspace.Project;
import model.workspace.runode.RuNode;
import view.gui.MainFrame;
import view.povrsinaview.ProjectView;

public class ProjectFactory extends AbstractNodeFactory{
    private static int i = 1;
    @Override
    public RuNode createNode(Object o) {
        Project p = new Project("Projekat "+ i++);
        ProjectView pv = new ProjectView(p);
        MainFrame.getInstance().addProjectView(pv);
        return p;
    }
}
