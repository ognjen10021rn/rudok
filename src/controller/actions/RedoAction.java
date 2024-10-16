package controller.actions;

import view.gui.MainFrame;

import java.awt.event.ActionEvent;

public class RedoAction extends AbstractRuDokAction {
    public RedoAction(){
        putValue(NAME, "Redo action");
        putValue(SMALL_ICON, loadIcon("/images/redo.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getCommandManager().doCommand();
    }
}
