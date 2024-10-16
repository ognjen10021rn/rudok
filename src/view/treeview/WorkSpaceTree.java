package view.treeview;
import controller.treecontroller.TreeController;
import controller.treecontroller.TreeMouseController;
import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;


public class WorkSpaceTree extends JTree {
    public WorkSpaceTree(){
        addTreeSelectionListener(new TreeController());
        setCellEditor(new TreeEditor(this, new DefaultTreeCellRenderer()));
        setCellRenderer(new TreeCellRenderer());
        setEditable(true);
        this.addMouseListener(new TreeMouseController());
    }
}
