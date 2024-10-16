package controller.serialization;

import controller.actions.AbstractRuDokAction;
import model.workspace.Presentation;
import view.gui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class SavePresentationAction extends AbstractRuDokAction {
    public SavePresentationAction(){
        putValue(NAME, "Save Presentation");
        putValue(SHORT_DESCRIPTION, "Save Presentation");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new PresentationFileFilter());
        Presentation pres = (Presentation) MainFrame.getInstance().getStablo().getTree().getLastSelectedPathComponent();
        File presFile = pres.getFile();
        if(pres.getFile() == null){
            if(jFileChooser.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
                presFile = jFileChooser.getSelectedFile();
            }
            else {
                return;
            }
        }

        ObjectOutputStream os;
        try {
            os = new ObjectOutputStream(new FileOutputStream(presFile));
            os.writeObject(pres);
            pres.setFile(presFile);
            //pres.setChanged(false);
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
