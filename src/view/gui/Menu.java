package view.gui;

import javax.swing.*;

public class Menu extends JMenuBar {
    public Menu(){
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");
        fileMenu.add(MainFrame.getInstance().getManager().getNewAction());
        fileMenu.add(MainFrame.getInstance().getManager().getAddImageAction());
        helpMenu.add(MainFrame.getInstance().getManager().getInfo());

        this.add(fileMenu);
        this.add(helpMenu);
    }
}
