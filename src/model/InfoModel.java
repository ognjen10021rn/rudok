package model;

import javax.swing.*;
import java.awt.*;


public class InfoModel{

    public InfoModel() {
    }

    public JDialog napraviModul(JFrame frame, JDialog dialog) {
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
