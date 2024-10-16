package model.workspace.runode;

import observer.IPublisher;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class RuNodeComposit extends RuNode{

    private List<RuNode> children = new ArrayList<>();

    public RuNodeComposit() {
    }


    public List<RuNode> getChildren() {
        return children;
    }

    public void setChildren(List<RuNode> children) {
        this.children = children;
    }

    public int childrenCount(){
        return children.size();
    }

}
