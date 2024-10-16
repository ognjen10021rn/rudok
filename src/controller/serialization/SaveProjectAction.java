package controller.serialization;

import controller.actions.AbstractRuDokAction;
import model.workspace.Project;
import view.gui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class SaveProjectAction extends AbstractRuDokAction {
    public SaveProjectAction(){
        putValue(NAME, "Save Project");
        putValue(SHORT_DESCRIPTION, "Save Project");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new ProjectFileFilter());
        Project p = (Project) MainFrame.getInstance().getStablo().getTree().getLastSelectedPathComponent();
        File projectFile = p.getFile();
        if(p.getFile() == null){
            if(jFileChooser.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
                projectFile = jFileChooser.getSelectedFile();
            }
            else {
                return;
            }
        }

        ObjectOutputStream os;
        try {
            os = new ObjectOutputStream(new FileOutputStream(projectFile));
            os.writeObject(p);
            p.setFile(projectFile);
            p.setChanged(false);
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
