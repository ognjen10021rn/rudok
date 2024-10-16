package controller.actions;

import view.gui.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class InfoAction extends AbstractRuDokAction {
    private JDialog dialog;

    public InfoAction(){
        putValue(SMALL_ICON, loadIcon("/images/info.png"));
        putValue(NAME, "Info");
        putValue(SHORT_DESCRIPTION, "Info");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(dialog == null){
            dialog = napraviModul(MainFrame.getInstance(), dialog);
        }
        dialog.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                dialog = null;
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

    }

    private JDialog napraviModul(JFrame frame, JDialog dialog) {
        dialog = new JDialog(frame);
        JLabel lblIme = new JLabel("Ognjen Stojanovic 100/21 RN");
        dialog.setTitle("Informacije o studentu");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        dialog.setSize((int) dim.getWidth() / 4, (int) dim.getHeight() / 4);
        dialog.add(lblIme);
        dialog.setVisible(true);

        return dialog;
    }

}
