package controller.actions;

import view.gui.MainFrame;
import view.povrsinaview.PresentationView;

import java.awt.event.ActionEvent;

public class SlideShowAction extends AbstractRuDokAction {
    public SlideShowAction(){
        putValue(NAME, "Slideshow");
        putValue(SMALL_ICON, loadIcon("/images/slideshow.png"));
        putValue(SHORT_DESCRIPTION, "Slideshow state");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((PresentationView)MainFrame.getInstance().getProjectView().getTabovi().getSelectedComponent()).getPres().getStateManager().setSlideShowState();
        ((PresentationView)MainFrame.getInstance().getProjectView().getTabovi().getSelectedComponent()).getPres().getStateManager().getCurrentState().showPanel();
    }
}
