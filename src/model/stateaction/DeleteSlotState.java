package model.stateaction;

import model.paintmodel.Slot;
import model.state.State;
import model.workspace.Slide;
import view.painterview.SlotView;
import view.povrsinaview.SlideView;

public class DeleteSlotState extends State {
    @Override
    public void mousePressed(Slide slide, SlideView slideView, int x, int y) {
        for(SlotView slotView : slideView.getSlotViewList()){
            if(slotView.elementAt(x, y, slotView.getSlot())){
                slide.removeSlots(slotView.getSlot());
                slideView.removeSlotView(slotView);
                return;
            }
        }
    }
}
