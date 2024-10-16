package controller.commands;

import model.workspace.MyTreeNode;
import model.workspace.runode.RuNode;
import view.gui.MainFrame;

import javax.swing.*;

public class AddTreeCommand extends AbstractCommand{
    private RuNode node;
    private int index;
    private String ime;
    private MyTreeNode myTreeNode;

    public AddTreeCommand(RuNode node, int index, String ime, MyTreeNode myTreeNode) {
        this.node = node;
        this.index = index;
        this.ime = ime;
        this.myTreeNode = myTreeNode;
    }

    public AddTreeCommand(String ime){
        this.ime = ime;
    }

    @Override
    public void doCommand() {
        myTreeNode.add(node);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getStablo().getTree());
    }

    @Override
    public void undoCommand() {
        myTreeNode.remove(node);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getStablo().getTree());
    }

    public void setNode(RuNode node) {
        this.node = node;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setMyTreeNode(MyTreeNode myTreeNode) {
        this.myTreeNode = myTreeNode;
    }
}
