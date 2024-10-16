package controller.actions;

import view.gui.MainFrame;
import view.povrsinaview.PresentationView;

import java.awt.event.ActionEvent;

public class RectangleAction extends AbstractRuDokAction {
    public RectangleAction(){
        putValue(NAME, "New Rectangle");
        putValue(SMALL_ICON, loadIcon("/images/newSlot.png"));
        putValue(SHORT_DESCRIPTION, "Draw new rectangle");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((PresentationView)MainFrame.getInstance().getProjectView().getTabovi().getSelectedComponent()).getPres().getStateManager().setPaintState();
    }
}
