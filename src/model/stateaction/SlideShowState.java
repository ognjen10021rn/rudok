package model.stateaction;

import model.state.State;
import view.gui.MainFrame;
import view.povrsinaview.PresentationView;

public class SlideShowState extends State {

    @Override
    public void showPanel() {
        MainFrame.getInstance().setContentPane(((PresentationView) MainFrame.getInstance().getProjectView().getTabovi().getSelectedComponent()).getSlideShowPane());
        MainFrame.getInstance().revalidate();
    }

}
