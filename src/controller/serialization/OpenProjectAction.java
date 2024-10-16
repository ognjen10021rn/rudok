package controller.serialization;

import controller.actions.AbstractRuDokAction;
import model.workspace.*;
import view.gui.MainFrame;
import view.povrsinaview.PresentationView;
import view.povrsinaview.ProjectView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OpenProjectAction extends AbstractRuDokAction {
    public OpenProjectAction() {
        putValue(NAME, "Open Project");
        putValue(SHORT_DESCRIPTION, "Open Project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new ProjectFileFilter());
        if(jFileChooser.showOpenDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
            try {
                ObjectInputStream os = new ObjectInputStream(new FileInputStream(jFileChooser.getSelectedFile()));
                Project p = null;
                try{
                    p = (Project) os.readObject();
                }catch (ClassNotFoundException ex){
                    ex.printStackTrace();
                }
                MyTreeNode node = new MyTreeNode((Workspace)MainFrame.getInstance().getStablo().getModel().getRoot());
                node.add(p);
                ProjectView pv = new ProjectView(p);
                MainFrame.getInstance().addProjectView(pv);
                for(Presentation pres : p.getPrezentacije()){
                    PresentationView pv2 = new PresentationView(pres);
                    pv.addPrezentacija(pv2);
                    pv.getTabovi().insertTab(pv2.getPres().getIme(), null,pv2, null, pres.getIndex() - 1);

                }
                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getStablo().getTree());

            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
