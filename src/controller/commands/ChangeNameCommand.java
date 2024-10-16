package controller.commands;

import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.runode.RuNode;
import view.gui.MainFrame;

import javax.swing.*;

public class ChangeNameCommand extends AbstractCommand{
    private RuNode node;
    private String ime;
    private String prosloIme;
    public ChangeNameCommand(RuNode node, String ime, String prosloIme){
        this.node = node;
        this.ime = ime;
        this.prosloIme = prosloIme;
    }

    @Override
    public void doCommand() {
        if(node instanceof Presentation){
            Presentation pres = (Presentation) node;
                for(Project p : pres.getSharedProjects()){
                    for(Presentation prez : p.getSharedPres()){
                        if(prez.getIme().equals(pres.getIme())){
                            prez.setIme(ime);
                    }
                }
            }
        }
        node.setIme(ime);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getStablo().getTree());
    }

    @Override
    public void undoCommand() {
        if(node instanceof Presentation){
            Presentation pres = (Presentation) node;
            for(Project p : pres.getSharedProjects()){
                for(Presentation prez : p.getSharedPres()){
                    if(prez.getIme().equals(pres.getIme())){
                        prez.setIme(prosloIme);
                    }
                }
            }
        }
        node.setIme(prosloIme);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getStablo().getTree());
    }

    public RuNode getNode() {
        return node;
    }
}
