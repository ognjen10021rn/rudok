package controller.actions;

import view.gui.MainFrame;
import view.povrsinaview.PresentationView;

import java.awt.event.ActionEvent;

public class SelectSlotAction extends AbstractRuDokAction {
    public SelectSlotAction(){
        putValue(NAME, "Select slot");
        putValue(SMALL_ICON, loadIcon("/images/selectSlot.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((PresentationView) MainFrame.getInstance().getProjectView().getTabovi().getSelectedComponent()).getPres().getStateManager().setSelectSlotState();
    }
}
