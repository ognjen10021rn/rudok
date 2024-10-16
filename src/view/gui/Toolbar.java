package view.gui;

import javax.swing.*;
import java.awt.*;

public class Toolbar extends JToolBar {
    public Toolbar(){
        super(SwingConstants.HORIZONTAL);
        setFloatable(false);
        add(MainFrame.getInstance().getManager().getNewAction());
        add(MainFrame.getInstance().getManager().getDeleteAction());
        add(MainFrame.getInstance().getManager().getAddImageAction());
        add(MainFrame.getInstance().getManager().getInfo());
        addSeparator(new Dimension(20, 0));
        add(MainFrame.getInstance().getManager().getUndoAction());
        add(MainFrame.getInstance().getManager().getRedoAction());
        addSeparator(new Dimension(20, 0));
        add(MainFrame.getInstance().getManager().getSaveProjectAction());
        add(MainFrame.getInstance().getManager().getOpenProjectAction());
        addSeparator(new Dimension(20, 0));
        add(MainFrame.getInstance().getManager().getSavePresentationAction());
        add(MainFrame.getInstance().getManager().getOpenPresentationAction());
    }
}
