package controller.actions;

import view.gui.MainFrame;
import view.povrsinaview.PresentationView;

import java.awt.event.ActionEvent;

public class ChangeSlotColorAction extends AbstractRuDokAction {

    public ChangeSlotColorAction(){
        putValue(NAME, "Change Slot Color");
        putValue(SHORT_DESCRIPTION, "Change Slot Color");
        putValue(SMALL_ICON, loadIcon("/images/paintSlot.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((PresentationView) MainFrame.getInstance().getProjectView().getTabovi().getSelectedComponent()).getPres().getStateManager().setPaintSlotState();
    }
}
