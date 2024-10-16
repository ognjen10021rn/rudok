package model.paintmodel;

import controller.serialization.SerializableStroke;
import model.state.EnumSlotType;
import observer.ChildType;
import observer.IPublisher;
import observer.ISubscriber;

import javax.swing.text.Position;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class Slot implements IPublisher, Serializable {
    private int x, y, height, width;
    private transient List<ISubscriber> subscribers;
    private Color color;
    private String slotBackground;
    private String textSlot = "TEXT";
    private SlotContent slotContent;
    private Stroke stroke;
    private EnumSlotType type;

    public Slot(int x, int y, int height, int width, Color color, Stroke stroke, EnumSlotType type) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.color = color;
        setStroke(stroke);
        this.type = type;
        this.textSlot = getTextSlot();
        slotContent = new SlotContent();
        if(type.equals(EnumSlotType.MULTIMEDIA)){
            slotContent.setContent("/images/defaultBackground.png");
        }else{
            slotContent.setContent(type.toString());
        }
        this.slotBackground = "/images/defaultBackground.png";
    }

    public void setTextSlot(String textSlot) {

        this.textSlot = textSlot;
    }


    public String getTextSlot() {
        return textSlot;
    }

    public SlotContent getSlotContent() {
        return slotContent;
    }

    public void setSlotBackground(String slotBackground) {
        this.slotBackground = slotBackground;
    }

    public String getSlotBackground() {
        return slotBackground;
    }

    public EnumSlotType getType() {
        return type;
    }

    public void setType(EnumSlotType type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Color getColor() {
        return color;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = new SerializableStroke(stroke);
    }

    @Override
    public void addSubscriber(ISubscriber subscriber) {
        if(subscriber == null)
            return;
        if(this.subscribers == null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(subscriber))
            return;
        this.subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(ISubscriber subscriber) {
        if(subscriber == null || this.subscribers == null || !this.subscribers.contains(subscriber))
            return;
        this.subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(Object notification, ChildType childType) {
        if(notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for(ISubscriber listener : subscribers){
            listener.update(notification, childType);
        }
    }
}
