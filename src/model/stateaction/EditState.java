package model.stateaction;

import model.state.State;
import view.gui.MainFrame;

public class EditState extends State{

    @Override
    public void showPanel() {
        MainFrame.getInstance().setContentPane(MainFrame.getInstance().getEditPane());
        MainFrame.getInstance().revalidate();
    }

}
