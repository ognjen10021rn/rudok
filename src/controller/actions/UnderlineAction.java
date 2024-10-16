package controller.actions;

import view.painterview.TextSlotView;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.event.ActionEvent;

public class UnderlineAction extends AbstractRuDokAction {
    private TextSlotView textSlotView;
    private SimpleAttributeSet attr;
    public UnderlineAction(){
        putValue(NAME, "Underline");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        attr = new SimpleAttributeSet();

        StyleConstants.setUnderline(attr, true);
        if(textSlotView.getTextPane().getCharacterAttributes().containsAttributes(attr)){
            StyleConstants.setUnderline(attr, false);
            textSlotView.getTextPane().setCharacterAttributes(attr, false);
        }else{
            textSlotView.getTextPane().setCharacterAttributes(attr, false);
        }
    }

    public void setTextSlotView(TextSlotView textSlotView) {
        this.textSlotView = textSlotView;
    }
}
