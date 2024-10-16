package controller.actions;

import view.gui.MainFrame;
import view.povrsinaview.PresentationView;

import java.awt.event.ActionEvent;

public class ImageSlotAction extends AbstractRuDokAction {

    public ImageSlotAction(){
        putValue(NAME, "Add image slot");
        putValue(SMALL_ICON, loadIcon("/images/imageSlot.png"));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ((PresentationView) MainFrame.getInstance().getProjectView().getTabovi().getSelectedComponent()).getPres().getStateManager().setImageSlotState();
    }
}
