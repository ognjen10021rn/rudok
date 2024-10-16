package controller.treecontroller;

import model.workspace.Project;
import view.gui.MainFrame;
import view.povrsinaview.ProjectView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TreeMouseController implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){
            Object node = MainFrame.getInstance().getStablo().getTree().getLastSelectedPathComponent();
            if(node instanceof Project){
                if(MainFrame.getInstance().getProjectView() != null){
                    MainFrame.getInstance().getProjectView().setVisible(false);
                }
                for(ProjectView pv : MainFrame.getInstance().getListaProjectView()){
                    if(pv.getProject().equals(node) && !pv.isVisible()){
                        MainFrame.getInstance().setProjectView(pv);
                        pv.setVisible(true);
                    }
                }
            }

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
