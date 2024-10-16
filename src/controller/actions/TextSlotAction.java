package controller.actions;

import view.gui.MainFrame;
import view.povrsinaview.PresentationView;

import java.awt.event.ActionEvent;

public class TextSlotAction extends AbstractRuDokAction {

    public TextSlotAction(){
        putValue(NAME, "Text Slot");
        putValue(SMALL_ICON, loadIcon("/images/typeSlot.png"));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ((PresentationView) MainFrame.getInstance().getProjectView().getTabovi().getSelectedComponent()).getPres().getStateManager().setTextSlotState();
    }
}
