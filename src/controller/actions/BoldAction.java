package controller.actions;

import view.painterview.TextSlotView;

import javax.swing.text.*;
import java.awt.event.ActionEvent;

public class BoldAction extends AbstractRuDokAction {
    private TextSlotView textSlotView;
    private SimpleAttributeSet attr;
    private String str;

    public BoldAction(){
        putValue(NAME, "Bold");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        attr = new SimpleAttributeSet();
        str = textSlotView.getSlot().getType().toString();

        StyleConstants.setBold(attr, true);
        if(textSlotView.getTextPane().getCharacterAttributes().containsAttributes(attr)){
            StyleConstants.setBold(attr, false);
            textSlotView.getTextPane().setCharacterAttributes(attr, false);
        }else{
            textSlotView.getTextPane().setCharacterAttributes(attr, false);
        }
    }

    public void setTextSlotView(TextSlotView textSlotView) {
        this.textSlotView = textSlotView;
    }
}
