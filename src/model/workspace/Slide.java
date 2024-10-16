package model.workspace;

import model.paintmodel.Slot;
import model.workspace.runode.RuNode;
import model.workspace.runode.RuNodeComposit;
import observer.ChildType;
import observer.IPublisher;
import observer.ISubscriber;

import javax.swing.*;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Slide extends RuNode implements IPublisher {
    private String ime;
    private Image img;
    private int index;
    private List<Slot> slots = new ArrayList<>();

    public Slide(String ime) {
        this.ime = ime;
        this.index = Integer.parseInt(ime.substring(ime.lastIndexOf(" ") + 1));
    }

    public Slide(){

    }

    @Override
    public String toString() {
        return getIme();
    }

    public void setIme(String ime) {
        this.ime = ime;
        notifySubscribers(this, ChildType.CHANGE_NAME);
    }

    public int getIndex() {
        return index;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void addSlots(Slot slot){
        if(slots.contains(slot) || (slot == null)){
            return;
        }
        slots.add(slot);
        notifySubscribers(slot, ChildType.ADD_CHILD);

    }

    public void removeSlots(Slot slot){
        if(!slots.contains(slot) || (slot == null)){
            return;
        }
        slots.remove(slot);
        notifySubscribers(slot, ChildType.REMOVE_CHILD);
    }

    public Image getImg() {
        return img;
    }

    public String getIme() {
        return ime;
    }

}
