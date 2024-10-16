package controller.commands;

import model.workspace.MyTreeNode;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.runode.RuNode;
import view.gui.MainFrame;

import javax.swing.*;

public class RemoveTreeCommand extends AbstractCommand{
    private RuNode child;
    private MyTreeNode parent;
    private int index;
    private int indexShared;
    private MyTreeNode sharedChild;

    public RemoveTreeCommand(RuNode child, MyTreeNode parent, int index){
        this.child = child;
        this.parent = parent;
        this.index = index;
    }

    @Override
    public void doCommand() {
        if(child instanceof Presentation){
            Presentation pres = (Presentation) child;
            for(Project p : pres.getSharedProjects()){
                System.out.println(pres.getSharedProjects());
                for(Presentation prez : p.getSharedPres()){
                    if(prez.getIme().equals(pres.getIme())){
                        sharedChild = new MyTreeNode((Project)prez.getParent());
                        sharedChild.remove(prez);
                        indexShared = prez.getIndex()-1;
                    }
                }
            }
        }
        parent.remove(child);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getStablo().getTree());
    }

    @Override
    public void undoCommand() {
        if(child instanceof Presentation){
            Presentation pres = (Presentation) child;
            for(Project p : pres.getSharedProjects()){
                System.out.println(pres.getSharedProjects());
                for(Presentation prez : p.getSharedPres()){
                    if(prez.getIme().equals(pres.getIme())){
                        sharedChild.insert(prez, indexShared);
                    }
                }
            }
        }
        parent.insert(child, index);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getStablo().getTree());
    }
}
