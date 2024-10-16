package model.workspace;

import model.workspace.runode.RuNode;
import model.workspace.runode.RuNodeComposit;
import observer.ChildType;
import observer.ISubscriber;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Workspace extends RuNodeComposit{
    private List<Project> projekti = new ArrayList<>();
    private String ime;
    public Workspace(){

    }

    @Override
    public String toString() {
        return "Workspace";
    }

    public void addProject(Project projekat){
        projekti.add(projekat);

    }

    public void removeProjekat(Project projekat){
        projekti.remove(projekat);
    }
    public List<Project> getProjekti() {
        return projekti;
    }


}
