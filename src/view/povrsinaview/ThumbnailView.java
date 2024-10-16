package view.povrsinaview;

import model.workspace.Slide;
import observer.ChildType;
import observer.ISubscriber;

import javax.swing.*;
import java.awt.*;

public class ThumbnailView extends JPanel implements ISubscriber {
    private Slide slide;
    private Dimension dim = new Dimension(100, 50);
    public ThumbnailView(Slide slide){
        this.slide = slide;
        this.slide.addSubscriber(this);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(Color.WHITE);
        setMaximumSize(dim);
        setMinimumSize(dim);
        setPreferredSize(dim);
    }

    public Slide getSlide() {
        return slide;
    }

    public void setSlide(Slide slide) {
        this.slide = slide;
    }

    @Override
    public void update(Object notification, ChildType childType) {
        if(notification instanceof JLabel && childType == null){
            add((JLabel)notification);
            this.revalidate();
        }
    }
}
