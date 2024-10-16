package view.treeview;

import model.workspace.*;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class TreeCellRenderer extends DefaultTreeCellRenderer {

    public TreeCellRenderer(){

    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        if(value instanceof Workspace){
            URL url = getClass().getResource("/images/tree.png");
            Icon icon = null;
            if(url != null){
                icon = new ImageIcon(url);
            }
            setIcon(icon);
        }

        if(value instanceof Project){
            URL url = getClass().getResource("/images/project.png");
            Icon icon = null;
            if(url != null){
                icon = new ImageIcon(url);
            }
            setIcon(icon);
        }
        if(value instanceof Presentation){
            URL url = getClass().getResource("/images/presentation.png");
            Icon icon = null;
            if(url != null){
                icon = new ImageIcon(url);
            }
            setIcon(icon);
        }
        if(value instanceof Slide){
            URL url = getClass().getResource("/images/slide.png");
            Icon icon = null;
            if(url != null){
                icon = new ImageIcon(url);
            }
            setIcon(icon);
        }
        return this;
    }
}
