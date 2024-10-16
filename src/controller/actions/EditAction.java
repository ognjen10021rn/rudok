package controller.actions;

import view.gui.MainFrame;
import view.povrsinaview.PresentationView;

import java.awt.event.ActionEvent;

public class EditAction extends AbstractRuDokAction {
    public EditAction(){
        putValue(NAME, "Edit");
        putValue(SHORT_DESCRIPTION, "Edit mode");
        putValue(SMALL_ICON, loadIcon("/images/edit.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((PresentationView)MainFrame.getInstance().getProjectView().getTabovi().getSelectedComponent()).getPres().getStateManager().setEditState();
        ((PresentationView)MainFrame.getInstance().getProjectView().getTabovi().getSelectedComponent()).getPres().getStateManager().getCurrentState().showPanel();
    }
}
