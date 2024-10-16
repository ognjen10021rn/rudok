package controller.serialization;

import controller.actions.AbstractRuDokAction;
import model.workspace.MyTreeNode;
import model.workspace.Presentation;
import model.workspace.Project;
import view.gui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OpenPresentationAction extends AbstractRuDokAction {

    public OpenPresentationAction() {
        putValue(NAME, "Open Presentation");
        putValue(SHORT_DESCRIPTION, "Open Presentation");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new PresentationFileFilter());
        if(jFileChooser.showOpenDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
            try {
                ObjectInputStream os = new ObjectInputStream(new FileInputStream(jFileChooser.getSelectedFile()));
                Presentation pres = null;
                try{
                    pres = (Presentation) os.readObject();
                }catch (ClassNotFoundException ex){
                    ex.printStackTrace();
                }
                MyTreeNode node = new MyTreeNode((Project)MainFrame.getInstance().getStablo().getTree().getLastSelectedPathComponent());
                node.add(pres);
                //PresentationView pv = new PresentationView(pres);
                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getStablo().getTree());

            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
