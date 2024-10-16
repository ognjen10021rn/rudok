package controller.actions;

import model.state.EnumSlotType;
import view.gui.MainFrame;
import view.povrsinaview.PresentationView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeSlotAction extends AbstractRuDokAction {
    public ChangeSlotAction(){
        putValue(NAME, "Change Slot");
        putValue(SMALL_ICON, loadIcon("/images/typeSlot.png"));
    }
    private void initializeDialog(){
        JDialog dialog = new JDialog();
        dialog.setTitle("Odaberite tip slota");
        JButton btnText = new JButton("Set Text");
        JButton btnMultiMedial = new JButton("Set Multimedial");
        dialog.setSize(200, 300);
        dialog.setLayout(new GridLayout(2, 2));
        dialog.add(btnText);
        dialog.setLocationRelativeTo(MainFrame.getInstance());
        dialog.add(btnMultiMedial);
        dialog.setVisible(true);
        btnText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((PresentationView) MainFrame.getInstance().getProjectView().getTabovi().getSelectedComponent()).getPres().
                        getStateManager().getAddSlotState().setType(EnumSlotType.TEXT);
                dialog.dispose();
            }
        });

        btnMultiMedial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((PresentationView) MainFrame.getInstance().getProjectView().getTabovi().getSelectedComponent()).getPres().
                        getStateManager().getAddSlotState().setType(EnumSlotType.MULTIMEDIA);
                dialog.dispose();
            }
        });
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        initializeDialog();
    }
}
