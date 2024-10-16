package view.povrsinaview;

import model.workspace.Project;
import view.gui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PresentationsShareView extends JDialog {
    private Box box;
    private JButton save;
    private String selektovani;

    public PresentationsShareView(){
        box = Box.createVerticalBox();
        setTitle("Share Presentation");
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getProjekti();
        save = new JButton("Save");
        save.addActionListener(MainFrame.getInstance().getManager().getSubmitAction());
        box.add(save);
        add(box);
    }

    private void getProjekti(){
        for(ProjectView pv: MainFrame.getInstance().getListaProjectView()){
            JButton btn = new JButton(pv.getProject().getIme());
            btn.addActionListener(new SharePresentationListener());
            box.add(btn);
        }
    }

    private class SharePresentationListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            selektovani = e.getActionCommand();
            MainFrame.getInstance().getManager().getSubmitAction().setProject(getProject());
        }
    }
    public Project getProject(){
        for(ProjectView pv: MainFrame.getInstance().getListaProjectView()){
            if(selektovani.equals(pv.getProject().getIme())){
                return pv.getProject();
            }
        }
        return null;
    }
    public String getSelektovani() {
        return selektovani;
    }
}
