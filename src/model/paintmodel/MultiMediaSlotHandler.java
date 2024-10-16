package model.paintmodel;

import model.state.State;
import view.gui.MainFrame;
import view.povrsinaview.PresentationView;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MultiMediaSlotHandler implements ISlotHandler{
    private SlotContent slotContent;
    private String path;
    private Slot slot;
    private Image img;
    private State state;
    public MultiMediaSlotHandler(Slot slot, SlotContent slotContent){
        this.slot = slot;
        this.slotContent = slotContent;
    }
    @Override
    public void readContent() {
        path = slotContent.getContent();
        URL url = getClass().getResource(path);
        if(url != null){
            img = new ImageIcon(url).getImage();
        }
    }

    @Override
    public void setContent() {
        slotContent.setContent(slot.getType().toString());
    }

    @Override
    public void paintContent(Graphics2D g) {

        if(!((PresentationView) MainFrame.getInstance().getProjectView().getTabovi().getSelectedComponent()).getPres().getStateManager().getCurrentState().equals(((PresentationView) MainFrame.getInstance().getProjectView().getTabovi().getSelectedComponent()).getPres().getStateManager().getSlideShowState())){
            g.setPaint(slot.getColor());
            g.setStroke(slot.getStroke());
            g.drawRect(slot.getX(), slot.getY(), slot.getWidth(), slot.getHeight());
            g.drawString(slot.getType().toString(), slot.getX() + slot.getWidth()/4, slot.getY() + slot.getHeight()/2);
        }else{
            readContent();
            g.drawImage(img, slot.getX(), slot.getY(), slot.getWidth(), slot.getHeight(), null);
        }
    }

    @Override
    public void formatContent() {

    }
}
