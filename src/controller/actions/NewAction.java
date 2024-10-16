package controller.actions;
import controller.commands.AddTreeCommand;
import model.workspace.*;
import model.factory.AbstractNodeFactory;
import model.factory.NodeFactory;
import model.workspace.runode.RuNode;
import view.gui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class NewAction extends AbstractRuDokAction {
    private static int i = 1;
    public NewAction(){
        putValue(SMALL_ICON, loadIcon("/images/newFile.png"));
        putValue(NAME,"New");
        putValue(SHORT_DESCRIPTION, "Make new node");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object node = MainFrame.getInstance().getStablo().getTree().getLastSelectedPathComponent();
        if(node == null){
            return;
        }
        AbstractNodeFactory factory = new NodeFactory().returnNodeFactory(node);
        MyTreeNode parent = new MyTreeNode(factory.nodeForTree(node));
        RuNode node1 = factory.createNode(node);
        //parent.add(node1);
        MainFrame.getInstance().getCommandManager().addCommand(new AddTreeCommand(node1, parent.getIndex(node1), node1.getIme(), parent));


        MainFrame.getInstance().getStablo().getTree().expandPath(MainFrame.getInstance().getStablo().getTree().getLeadSelectionPath());
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getStablo().getTree());
    }


}
