package model.workspace;

import model.workspace.runode.RuNode;
import model.workspace.runode.RuNodeComposit;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class MyTreeNode extends DefaultMutableTreeNode {

    private RuNode node;
    public MyTreeNode(RuNode node){
        this.node = node;
    }
    public MyTreeNode(){

    }
    public void setNode(RuNode node) {
        this.node = node;
    }

    public RuNode getNode() {
        return node;
    }

    @Override
    public String toString() {
        return "Workspace";
    }

    @Override
    public void insert(MutableTreeNode child, int index) {
        if(child instanceof Project){
            ((Workspace)node).addProject((Project) child);
            node.insert(child, index);
            child.setParent(node);
        }
        if(child instanceof Presentation){
            ((Project)node).addPrezentacija((Presentation) child);
            node.insert(child, index);
            child.setParent(node);
        }
        if(child instanceof Slide){
            ((Presentation)node).addSlajd((Slide) child);
            node.insert(child, index);
            child.setParent(node);
        }
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void remove(MutableTreeNode child) {
        if(child instanceof Project){
            ((Workspace)node).removeProjekat((Project) child);
            child.removeFromParent();
        }
        if(child instanceof Presentation){
            ((Project)node).removePrezentacija((Presentation) child);
            child.removeFromParent();
        }
        if(child instanceof Slide){
            ((Presentation)node).removeSlajd((Slide) child);
            child.removeFromParent();
        }
    }
    public RuNode cloneNode(){
        if(node instanceof Presentation){
            Presentation pres = (Presentation) node.clone();
            for(Slide slajd : ((Presentation)node).getSlajdovi()){
                Slide slide = (Slide) slajd.clone();
                pres.add(slide);
            }

            return pres;
        }
        return null;
    }


    @Override
    public void removeFromParent() {
        RuNode node1 = (RuNode) getParent();
        node1.remove(node);
    }

    @Override
    public void setParent(MutableTreeNode newParent) {
        node.setParent(newParent);
    }


    @Override
    public TreeNode getChildAt(int childIndex) {
        if(node instanceof Workspace){
            return ((Workspace)node).getProjekti().get(childIndex);
        }
        if(node instanceof Project){
            return ((Project)node).getPrezentacije().get(childIndex);
        }

        if(node instanceof Presentation){
            return ((Presentation)node).getSlajdovi().get(childIndex);
        }
        return null;
    }

    @Override
    public int getChildCount() {
        if(node instanceof Workspace){
            return ((Workspace) node).getProjekti().size();
        }
        if(node instanceof Project){
            return ((Project) node).getPrezentacije().size();
        }
        if(node instanceof Presentation){
            return ((Presentation) node).getSlajdovi().size();
        }
        return 0;
    }

    @Override
    public TreeNode getParent() {
        return node.getParent();
    }

    @Override
    public int getIndex(TreeNode child) {
        if(node instanceof Workspace){
            return (((Workspace) node).getProjekti().indexOf((Project) child));
        }
        if(node instanceof Project){
            return (((Project) node).getPrezentacije().indexOf((Presentation) child));
        }
        if(node instanceof Presentation){
            return (((Presentation) node).getSlajdovi().indexOf((Slide) child));
        }
        return 0;
    }



    @Override
    public boolean getAllowsChildren() {
        if(node instanceof RuNodeComposit){
            return true;
        }
        return false;
    }

    @Override
    public boolean isLeaf() {
        if(node instanceof RuNodeComposit){
            return false;
        }
        return true;
    }

    @Override
    public void add(MutableTreeNode newChild) {
        if(newChild instanceof Project){
            ((Workspace)node).addProject((Project) newChild);
            node.add(newChild);
            newChild.setParent(node);
        }
        if(newChild instanceof Presentation){
            ((Project)node).addPrezentacija((Presentation) newChild);
            node.add(newChild);
            newChild.setParent(node);
        }
        if(newChild instanceof Slide){
            ((Presentation)node).addSlajd((Slide) newChild);
            node.add(newChild);
            newChild.setParent(node);
        }
    }
    public List<? extends RuNode> getChildren(){
        if(node instanceof Workspace){
            return ((Workspace)node).getProjekti();
        }
        if(node instanceof Project){
            return ((Project)node).getPrezentacije();
        }
        if(node instanceof Presentation){
            return ((Presentation)node).getSlajdovi();
        }
        return null;
    }

    @Override
    public Enumeration children() {
        if(node instanceof Workspace){
                return (Enumeration<TreeNode>)((Workspace)node).getProjekti();
        }
        if(node instanceof Project){
            return (Enumeration<TreeNode>)((Project)node).getPrezentacije();
        }
        if(node instanceof Presentation){
            return (Enumeration<TreeNode>)((Presentation)node).getSlajdovi();
        }
        return null;
    }
}
