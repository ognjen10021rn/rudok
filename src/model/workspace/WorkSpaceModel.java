package model.workspace;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class WorkSpaceModel extends DefaultTreeModel {

    public WorkSpaceModel() {
        super(new Workspace());

    }

    public WorkSpaceModel(TreeNode root) {
        super(root);
    }

    public WorkSpaceModel(TreeNode root, boolean asksAllowsChildren) {
        super(root, asksAllowsChildren);
    }

}
