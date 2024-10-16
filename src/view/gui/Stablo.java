package view.gui;

import model.workspace.WorkSpaceModel;
import view.treeview.WorkSpaceTree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import java.awt.*;

public class Stablo extends JScrollPane {
    private WorkSpaceTree tree = new WorkSpaceTree();
    private WorkSpaceModel model = new WorkSpaceModel();
    public Stablo(){

        tree.setModel(model);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setViewportView(tree);

    }

    public WorkSpaceTree getTree() {
        return tree;
    }

    public WorkSpaceModel getModel() {
        return model;
    }
}
