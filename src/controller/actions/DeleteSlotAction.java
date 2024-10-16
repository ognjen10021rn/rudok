package controller.actions;

import view.gui.MainFrame;
import view.povrsinaview.PresentationView;

import java.awt.event.ActionEvent;

public class DeleteSlotAction extends AbstractRuDokAction {
    public DeleteSlotAction(){
        putValue(NAME, "Delete Slot");
        putValue(SMALL_ICON, loadIcon("/images/deleteSlot.png"));
        putValue(SHORT_DESCRIPTION, "Delete Slot");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ((PresentationView) MainFrame.getInstance().getProjectView().getTabovi().getSelectedComponent()).getPres().getStateManager().setDeleteSlotState();
    }
}
