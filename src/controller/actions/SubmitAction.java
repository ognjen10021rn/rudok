package controller.actions;

import model.workspace.MyTreeNode;
import model.workspace.Presentation;
import model.workspace.Project;
import view.gui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SubmitAction extends AbstractRuDokAction {

    private Presentation presentation;
    private Project selected;
    private Project parentNode;
    @Override
    public void actionPerformed(ActionEvent e) {
        MyTreeNode node = new MyTreeNode(presentation);
        Presentation newNode =(Presentation) node.cloneNode();
        node.setNode(selected);
        node.add(newNode);
        presentation.addSharedProjects(selected);
        selected.addSharedPres(newNode);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getStablo().getTree());
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public Project getProject() {
        return selected;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    public void setProject(Project project) {
        this.selected = project;
    }
}
