package controller.actions;

import model.workspace.Presentation;
import view.gui.MainFrame;
import view.povrsinaview.PresentationsShareView;

import java.awt.event.ActionEvent;

public class PresentationShareAction extends AbstractRuDokAction {
    public PresentationShareAction(){
        putValue(NAME, "Share Presentation");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = MainFrame.getInstance().getStablo().getTree().getLastSelectedPathComponent();
        if(o instanceof Presentation){
            PresentationsShareView pv = new PresentationsShareView();
            MainFrame.getInstance().getManager().getSubmitAction().setPresentation((Presentation) o);
            pv.setVisible(true);
        }

    }
}
