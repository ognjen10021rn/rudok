package controller.actions;

import model.workspace.Presentation;
import view.gui.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class AddImageAction extends AbstractRuDokAction {

    public AddImageAction(){
        putValue(SMALL_ICON, loadIcon("/images/addImage.png"));
        putValue(NAME, "Add Image");
        putValue(SHORT_DESCRIPTION, "Add a image to slide");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = MainFrame.getInstance().getStablo().getTree().getLastSelectedPathComponent();
        if(o instanceof Presentation){
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter fef = new FileNameExtensionFilter("For images", "png", "jpg", "jpeg");
            fileChooser.addChoosableFileFilter(fef);
            int showOpenImageDialog = fileChooser.showOpenDialog(null);
            if(showOpenImageDialog == JFileChooser.APPROVE_OPTION){
                File imageFile = fileChooser.getSelectedFile();
                String path = imageFile.getPath();
                try {
                    Image img1 = ImageIO.read(imageFile);
                    ((Presentation)o).setSlideBackground(img1);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }
}
