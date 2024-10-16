package view.treeview;

import controller.commands.ChangeNameCommand;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Slide;
import view.gui.MainFrame;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class TreeEditor extends DefaultTreeCellEditor implements ActionListener {
    private Object component = null;
    private JTextField text = null;

    public TreeEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
        super(arg0, arg1);
    }

    @Override
    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
        component = value;
        text = new JTextField(value.toString());
        text.addActionListener(this);

        return text;
    }

    @Override
    public boolean isCellEditable(EventObject event) {
        if(event instanceof  MouseEvent){
            if(((MouseEvent) event).getClickCount() == 3){
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(component instanceof Project){
           MainFrame.getInstance().getCommandManager().addCommand(new ChangeNameCommand((Project)component, e.getActionCommand(), (((Project) component).getIme())));
        }
        if(component instanceof Slide){
            MainFrame.getInstance().getCommandManager().addCommand(new ChangeNameCommand((Slide)component, e.getActionCommand(), (((Slide) component).getIme())));
        }
        if(component instanceof Presentation){
            MainFrame.getInstance().getCommandManager().addCommand(new ChangeNameCommand((Presentation)component, e.getActionCommand(), (((Presentation) component).getIme())));
        }
        MainFrame.getInstance().getStablo().getTree().expandPath(MainFrame.getInstance().getStablo().getTree().getLeadSelectionPath());
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getStablo().getTree());
    }
}
