package model.workspace.runode;

import model.workspace.MyTreeNode;
import model.workspace.Project;
import observer.ChildType;
import observer.IPublisher;
import observer.ISubscriber;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class RuNode extends DefaultMutableTreeNode implements IPublisher, Serializable {

    private String ime;
    private transient List<ISubscriber> subscribers = new ArrayList<>();
    private RuNodeComposit parent;

    public RuNode() {

    }


    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getIme() {
        return ime;
    }


    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<ISubscriber> subscribers) {
        this.subscribers = subscribers;
    }

    @Override
    public void addSubscriber(ISubscriber subscriber) {
        if (subscriber == null)
            return;
        if (this.subscribers == null)
            this.subscribers = new ArrayList<>();
        if (this.subscribers.contains(subscriber))
            return;
        this.subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(ISubscriber subscriber) {
        if (subscriber == null || this.subscribers == null || !this.subscribers.contains(subscriber))
            return;
        this.subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(Object notification, ChildType childType) {
        if (notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for (ISubscriber listener : subscribers) {
            listener.update(notification, childType);
        }

    }
}
