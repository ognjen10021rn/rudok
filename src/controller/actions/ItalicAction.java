package controller.actions;

import view.painterview.TextSlotView;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.event.ActionEvent;

public class ItalicAction extends AbstractRuDokAction {
    private TextSlotView textSlotView;
    private SimpleAttributeSet attr;
    public ItalicAction(){
        putValue(NAME, "Italic");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        attr = new SimpleAttributeSet();

        StyleConstants.setItalic(attr, true);
        if(textSlotView.getTextPane().getCharacterAttributes().containsAttributes(attr)){
            StyleConstants.setItalic(attr, false);
            textSlotView.getTextPane().setCharacterAttributes(attr, false);
        }else{
            textSlotView.getTextPane().setCharacterAttributes(attr, false);
        }

    }

    public void setTextSlotView(TextSlotView textSlotView) {
        this.textSlotView = textSlotView;
    }

}
