package model.stateaction;

import model.paintmodel.Slot;
import model.state.State;
import model.workspace.Slide;
import observer.ChildType;
import view.painterview.SlotView;
import view.povrsinaview.SlideView;

public class MoveRecState extends State {
    private Slot current;
    private Slide s;
    private int distanceX;
    private int distanceY;
    boolean moving = false;
    @Override
    public void mousePressed(Slide slide, SlideView slideView, int x, int y) {
        this.s = slide;
        for(SlotView slotView : slideView.getSlotViewList()){
            if(slotView.elementAt(x, y, slotView.getSlot())){
                this.current = slotView.getSlot();
            }
        }
        if(current != null){
            distanceX = x - current.getX();
            distanceY = y - current.getY();
            moving = true;
        }
    }
    @Override
    public void mouseDragged(int x, int y) {
        if(current != null){
            if(moving){
            current.setX(x - distanceX);
            current.setY(y - distanceY);
            s.notifySubscribers(current, ChildType.PAINT_RECTANGLE);
            }

        }

    }

    @Override
    public void mouseReleased(int x, int y) {
        if(current != null){
            distanceY = 0;
            distanceX = 0;
        }
    }

}
