package view.povrsinaview;

import model.paintmodel.Slot;
import model.workspace.Slide;
import view.gui.MainFrame;
import view.painterview.SlotView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SlideShowPane extends JPanel {
    private PresentationView presentationView;
    private Dimension dim = new Dimension(500, 300);
    private CardLayout layout;
    private List<Slot> slotovi = new ArrayList<>();
    private List<SlideView> slajdovi = new ArrayList<>();
    private JButton sledeci = new JButton(">");
    private JButton prethodni = new JButton("<");
    private JPanel panel = new JPanel();
    private JToolBar toolBar = new JToolBar(SwingConstants.HORIZONTAL);

    public SlideShowPane(){
        toolBar.setFloatable(false);
        layout = new CardLayout();
        panel.setLayout(layout);
        panel.setPreferredSize(dim);
        panel.setMinimumSize(dim);
        panel.setMaximumSize(dim);
        toolBar.add(MainFrame.getInstance().getManager().getEditAction());
        add(toolBar, BorderLayout.NORTH);
        add(prethodni);
        initialize();
        add(panel);
        add(sledeci);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Slot sv2 : slotovi){
            SlotView sv = new SlotView(sv2);
            sv.paint((Graphics2D) g);
        }
    }

    public void addSlajdShowSlajdovi(Slide slide){
        SlideView sv = new SlideView(slide);
        slotovi.addAll(slide.getSlots());
        panel.add(sv);

    }

    private void initialize(){
        sledeci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.next(panel);
            }
        });
        prethodni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.previous(panel);
            }
        });
    }



    public void setPresentation(PresentationView presentation) {
        this.presentationView = presentation;
    }

    public PresentationView PresentationView() {
        return presentationView;
    }
}
