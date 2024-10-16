package view.painterview;

import model.paintmodel.Slot;
import view.gui.MainFrame;

import javax.management.Attribute;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TextSlotView extends JDialog {
    private Slot slot;
    private JToolBar toolBar;
    private JTextPane textPane;
    private String slotText;
    private JButton btnSave;
    public TextSlotView(Slot slot){
        this.slot = slot;
        setLayout(new BorderLayout());
        toolBar = new JToolBar(SwingConstants.HORIZONTAL);
        toolBar.setFloatable(false);
        toolBar.add(MainFrame.getInstance().getManager().getBoldAction());
        MainFrame.getInstance().getManager().getBoldAction().setTextSlotView(this);
        toolBar.add(MainFrame.getInstance().getManager().getItalicAction());
        MainFrame.getInstance().getManager().getItalicAction().setTextSlotView(this);
        toolBar.add(MainFrame.getInstance().getManager().getUnderlineAction());
        MainFrame.getInstance().getManager().getUnderlineAction().setTextSlotView(this);
        textPane = new JTextPane();
        textPane.setText(slot.getTextSlot());
        loadTextPaneText();

        setTitle("Text slot");
        setLocationRelativeTo(MainFrame.getInstance());
        setSize(new Dimension(400, 400));
        setVisible(true);
        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slot.setTextSlot(textPane.getText());
                makeString();
            }
        });
        add(toolBar, BorderLayout.NORTH);
        add(textPane, BorderLayout.CENTER);
        add(btnSave, BorderLayout.SOUTH);
    }

    private void loadTextPaneText(){
        if(slot.getSlotContent().getFontovi().isEmpty()){
            return;
        }
        SimpleAttributeSet attr = new SimpleAttributeSet();
        List<List<Boolean>> fontovi = slot.getSlotContent().getFontovi();
        StyledDocument styledDocument = textPane.getStyledDocument();
        for(int i = 0; i < slot.getSlotContent().getFontovi().size(); i++){

            if(fontovi.get(i).get(0)){
                StyleConstants.setBold(attr, true);
                styledDocument.setCharacterAttributes(i, i+1, attr, false);
            }
            if(fontovi.get(i).get(1)){
                StyleConstants.setItalic(attr, true);
                styledDocument.setCharacterAttributes(i, i+1, attr, false);
            }
            if(fontovi.get(i).get(2)){
                StyleConstants.setUnderline(attr, true);
                styledDocument.setCharacterAttributes(i, i+1, attr, false);
            }
        }
        textPane.setStyledDocument(styledDocument);

    }
    private void makeString(){
        AttributeSet set;
        List<Boolean> fontovi;
        slot.getSlotContent().getFontovi().clear();
        for(int i = 0; i < textPane.getText().length(); i++){
            set = textPane.getStyledDocument().getCharacterElement(i).getAttributes();
            // *?_T_?*
            fontovi = new ArrayList<>();

            if(StyleConstants.isBold(set)){
                fontovi.add(true);
            }else{
                fontovi.add(false);
            }
            if(StyleConstants.isItalic(set)){
                fontovi.add(true);
            } else{
                fontovi.add(false);
            }
            if(StyleConstants.isUnderline(set)){
                fontovi.add(true);
            }else{
                fontovi.add(false);
            }
            slot.getSlotContent().getFontovi().add(fontovi);

        }

    }

    private boolean indexOutOfBounds(int k, int br, int len){
        if((k-br < 0 || k+br > len)){
            return false;
        }
        return true;
    }
    public void setSlotText(String slotText) {
        this.slotText = slotText;
    }

    public String getSlotText() {
        return slotText;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public JToolBar getToolBar() {
        return toolBar;
    }

    public void setToolBar(JToolBar toolBar) {
        this.toolBar = toolBar;
    }

    public JTextPane getTextPane() {
        return textPane;
    }

    public void setTextPane(JTextPane textPane) {
        this.textPane = textPane;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(JButton btnSave) {
        this.btnSave = btnSave;
    }
}
