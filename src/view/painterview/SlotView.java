package view.painterview;

import model.paintmodel.ISlotHandler;
import model.paintmodel.MultiMediaSlotHandler;
import model.paintmodel.Slot;
import model.paintmodel.TextSlotHandler;
import model.state.EnumSlotType;
import observer.ChildType;
import observer.ISubscriber;

import java.awt.*;

public class SlotView implements ISubscriber {
    private Slot slot;
    private ISlotHandler slotHandler;
    public SlotView(Slot slot){
        this.slot = slot;
        if(slot.getType().equals(EnumSlotType.TEXT)){
            slotHandler = new TextSlotHandler(slot);
        }else{
            slotHandler = new MultiMediaSlotHandler(slot, slot.getSlotContent());
        }
        this.slot.addSubscriber(this);
    }

    public void paint(Graphics2D g){
        slotHandler.paintContent(g);

    }

    public boolean elementAt(int x, int y, Slot slot1){
        return (x - slot1.getX() >= 0 && x - slot1.getX() <= slot.getWidth()) && (y - slot1.getY() >= 0 && y - slot1.getY() <= slot.getHeight());
    }

    public ISlotHandler getSlotHandler() {
        return slotHandler;
    }

    public void setSlotHandler(ISlotHandler slotHandler) {
        this.slotHandler = slotHandler;
    }

    public Slot getSlot() {
        return slot;
    }

    @Override
    public void update(Object notification, ChildType childType) {

    }
}
