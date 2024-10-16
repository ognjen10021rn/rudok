package controller.actions;

import javax.swing.*;
import java.net.URL;

public abstract class AbstractRuDokAction extends AbstractAction {
    public Icon loadIcon(String image){
        Icon icon = null;
        URL url = getClass().getResource(image);
        if(url != null){
            icon = new ImageIcon(url);
        }else{
            System.out.println("Nije pronadjen resurs: " + image);
        }
        return icon;
    }
}
