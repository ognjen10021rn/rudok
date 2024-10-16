package model.stateaction;

import model.paintmodel.Slot;
import model.paintmodel.SlotContent;
import model.state.EnumSlotType;
import model.state.State;
import model.workspace.Slide;
import view.povrsinaview.SlideView;

import java.awt.*;

public class AddSlotState extends State {

    private Slot s;
    private EnumSlotType type = EnumSlotType.MULTIMEDIA;
    private SlotContent slotContent;


    @Override
    public void mousePressed(Slide slide, SlideView slideView, int x, int y) {
        s = new Slot(x, y, 100, 200, Color.RED, new BasicStroke(), type);
        slide.addSlots(s);
    }

    public void setS(Slot s) {
        this.s = s;
    }

    public void setType(EnumSlotType type) {
        this.type = type;
        //s.setType(type);
    }

    public EnumSlotType getType() {
        return type;
    }

    public void setSlotContent(SlotContent slotContent) {
        this.slotContent = slotContent;
    }
}
