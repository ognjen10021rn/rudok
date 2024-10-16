package model.paintmodel;

import javax.swing.text.StyledDocument;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SlotContent implements Serializable {
    private String content;
    private List<List<Boolean>> fontovi = new ArrayList<>();

    public List<List<Boolean>> getFontovi() {
        return fontovi;
    }

    public void setFontovi(List<List<Boolean>> fontovi) {
        this.fontovi = fontovi;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
