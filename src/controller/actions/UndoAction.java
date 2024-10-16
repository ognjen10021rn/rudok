package controller.actions;

import view.gui.MainFrame;

import java.awt.event.ActionEvent;

public class UndoAction extends AbstractRuDokAction {
    public UndoAction(){
        putValue(NAME, "Undo action");
        putValue(SMALL_ICON, loadIcon("/images/undo.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getCommandManager().undoCommand();
    }
}
