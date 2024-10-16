package controller.actions;

import controller.commands.RemoveTreeCommand;
import model.workspace.*;
import view.gui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DeleteAction extends AbstractRuDokAction {
    public DeleteAction(){
        putValue(SMALL_ICON, loadIcon("/images/delete.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob = MainFrame.getInstance().getStablo().getTree().getLastSelectedPathComponent();
        if(ob instanceof Project){
            Project p = (Project)ob;
            MyTreeNode node = new MyTreeNode((Workspace)p.getParent());
            MainFrame.getInstance().getCommandManager().addCommand(new RemoveTreeCommand(p, node, node.getIndex(p)));
        }
        if(ob instanceof Presentation){
            Presentation pres = (Presentation) ob;
            MyTreeNode node = new MyTreeNode((Project)pres.getParent());
            MainFrame.getInstance().getCommandManager().addCommand(new RemoveTreeCommand(pres, node, node.getIndex(pres)));
        }
        if(ob instanceof Slide){
            Slide slide = (Slide) ob;
            MyTreeNode node = new MyTreeNode((Presentation)slide.getParent());
            MainFrame.getInstance().getCommandManager().addCommand(new RemoveTreeCommand(slide, node, node.getIndex(slide)));
        }


        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getStablo().getTree());
    }
}
