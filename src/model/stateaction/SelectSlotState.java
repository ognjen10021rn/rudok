package model.stateaction;

import model.state.EnumSlotType;
import model.state.State;
import model.workspace.Slide;
import view.painterview.MultimediaSlotView;
import view.painterview.SlotView;
import view.painterview.TextSlotView;
import view.povrsinaview.SlideView;

public class SelectSlotState extends State {
    private TextSlotView textSlotView;
    private MultimediaSlotView multimediaSlotView;

    @Override
    public void mouseClicked(Slide slide, SlideView slideView, int x, int y) {
        for(SlotView sv : slideView.getSlotViewList()){
            if(sv.elementAt(x, y, sv.getSlot())){
                if(sv.getSlot().getType().equals(EnumSlotType.TEXT)){
                    textSlotView = new TextSlotView(sv.getSlot());
                    textSlotView.setVisible(true);
                }
                if(sv.getSlot().getType().equals(EnumSlotType.MULTIMEDIA)){
                    multimediaSlotView = new MultimediaSlotView(sv.getSlot());
                    multimediaSlotView.setVisible(true);
                }
            }
        }
    }

    public TextSlotView getTextSlotView() {
        return textSlotView;
    }

    public MultimediaSlotView getMultimediaSlotView() {
        return multimediaSlotView;
    }
}
