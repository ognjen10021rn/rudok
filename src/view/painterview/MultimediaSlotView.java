package view.painterview;

import model.paintmodel.Slot;
import model.workspace.Presentation;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MultimediaSlotView extends JDialog {
    private Slot slot;
    private JFileChooser jFileChooser;
    private Image img;
    private MyImagePanel imagePanel;
    public MultimediaSlotView(Slot slot){
        this.slot = slot;
        setTitle("Slot view");
        setLayout(new BorderLayout());
        imagePanel = new MyImagePanel();
        jFileChooser = new JFileChooser();
        initialize();
        setSize(600 , 400);
        add(imagePanel, BorderLayout.CENTER);
    }

    private void initialize() {
        JButton btn = new JButton("Promeni sliku");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileNameExtensionFilter fef = new FileNameExtensionFilter("For images", "png", "jpg", "jpeg");
                jFileChooser.addChoosableFileFilter(fef);
                int showOpenImageDialog = jFileChooser.showOpenDialog(null);
                if(showOpenImageDialog == JFileChooser.APPROVE_OPTION){
                    File imageFile = jFileChooser.getSelectedFile();
                    File test = new File(imageFile.getPath());
                    try {
                        img = ImageIO.read(test);
                        slot.setSlotBackground(imageFile.getPath());
                        setImg(img);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    repaint();
                }
            }
        });
        add(btn, BorderLayout.NORTH);
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Image getImg() {
        return img;
    }

    public class MyImagePanel extends JPanel{
        public MyImagePanel(){
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            URL url = getClass().getResource(slot.getSlotBackground());
            File file = new File(url.getPath());
            try {
                img = ImageIO.read(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            setImg(img);

            g.drawImage(getImg(),0,0, img.getWidth(null)/3, img.getHeight(null)/3, null);

        }
    }
}
