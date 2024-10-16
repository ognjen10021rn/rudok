package model.paintmodel;

import view.gui.MainFrame;
import view.povrsinaview.PresentationView;

import javax.swing.text.AttributeSet;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextSlotHandler implements ISlotHandler{
    private Slot slot;
    private AttributedString astr;
    public TextSlotHandler(Slot slot){
        this.slot = slot;
    }
    @Override
    public void readContent() {
    }

    @Override
    public void setContent() {

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
            astr = new AttributedString(slot.getTextSlot());
            List<List<Boolean>> lista = slot.getSlotContent().getFontovi();
            int i;
            for(i = 0; i < slot.getSlotContent().getFontovi().size(); i++){
                astr.addAttribute(TextAttribute.SIZE, 20, i, i+1);
                if(lista.get(i).get(0)){
                    astr.addAttribute(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD, i, i+1);
                }
                if(lista.get(i).get(1)){
                    astr.addAttribute(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE, i, i+1);
                }
                if(lista.get(i).get(2)){
                    astr.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON, i, i+1);
                }
            }
            g.drawString(astr.getIterator(), slot.getX(), slot.getY());
        }
    }

    @Override
    public void formatContent() {

    }
}
