package model.paintmodel;

import java.awt.*;

public interface ISlotHandler {
    void readContent();
    void setContent();
    void paintContent(Graphics2D g);
    void formatContent();
}
