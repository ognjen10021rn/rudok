package view;

import javax.swing.*;

public class Toolbar extends JToolBar {
    public Toolbar(){
        super(SwingConstants.HORIZONTAL);
        setFloatable(false);
        add(MainFrame.getInstance().getManager().getNewProjectAction());
        add(MainFrame.getInstance().getManager().getDeleteAction());
        add(MainFrame.getInstance().getManager().getAddImageAction());
        add(MainFrame.getInstance().getManager().getInfo());
        add(MainFrame.getInstance().getManager().getUndoAction());
        add(MainFrame.getInstance().getManager().getRedoAction());
    }
}
