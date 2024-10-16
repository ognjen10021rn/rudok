package controller.actions;

import view.gui.MainFrame;
import view.povrsinaview.PresentationView;

import java.awt.event.ActionEvent;

public class MoveAction extends AbstractRuDokAction {
    public MoveAction(){
        putValue(NAME, "Move Slot");
        putValue(SMALL_ICON, loadIcon("/images/moveSlot.png"));
        putValue(SHORT_DESCRIPTION, "Move Slot");
    }
    @Override
    public void actionPerformed(ActionEvent e) {((PresentationView) MainFrame.getInstance().getProjectView().getTabovi().getSelectedComponent()).getPres().getStateManager().setMoveRecState();

    }
}
