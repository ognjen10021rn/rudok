package model.workspace;

import model.workspace.runode.RuNode;
import model.workspace.runode.RuNodeComposit;
import observer.ChildType;
import observer.IPublisher;
import observer.ISubscriber;

import javax.swing.tree.TreeNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Project extends RuNodeComposit {

    private String ime;
    private List<Presentation> prezentacije = new ArrayList<>();
    private File file;
    private List<Presentation> sharedPres = new ArrayList<>();
    private transient boolean changed;
    public Project(String ime) {
        this.ime = ime;
    }
    public Project(){

    }

    public boolean isChanged() {
        return changed;
    }
    public void addSharedPres(Presentation pres){
        sharedPres.add(pres);
    }

    public List<Presentation> getSharedPres() {
        return sharedPres;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public void addPrezentacija(Presentation prez){
        if(prezentacije.contains(prez) || (prez == null)){
            return;
        }
        prezentacije.add(prez);
        notifySubscribers(prez, ChildType.ADD_CHILD);
    }

    public void removePrezentacija(Presentation prez){
        if(!prezentacije.contains(prez) || (prez == null)){
            return;
        }
        prezentacije.remove(prez);
        notifySubscribers(prez, ChildType.REMOVE_CHILD);
    }

    public List<Presentation> getPrezentacije() {
        return prezentacije;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setIme(String ime) {
        this.ime = ime;
        notifySubscribers(this, ChildType.CHANGE_NAME);
    }

    public String getIme() {
        return ime;
    }

    @Override
    public String toString() {
        return getIme();
    }


}
