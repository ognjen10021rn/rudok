package model.stateaction;

import model.state.State;
import model.workspace.Slide;
import view.painterview.SlotView;
import view.povrsinaview.SlideView;

import javax.swing.*;
import java.awt.*;

public class PaintSlotState extends State {

    @Override
    public void mousePressed(Slide slide, SlideView slideView, int x, int y) {
        for(SlotView slotView : slideView.getSlotViewList()){
            if(slotView.elementAt(x, y, slotView.getSlot())){
                Color color = JColorChooser.showDialog(slideView, "Change Color", Color.RED);
                slotView.getSlot().setColor(color);
            }
        }
    }
}
