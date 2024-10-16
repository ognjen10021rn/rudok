package model.workspace;

import model.stateaction.StateManager;
import model.workspace.runode.RuNode;
import model.workspace.runode.RuNodeComposit;
import observer.ChildType;
import observer.IPublisher;
import observer.ISubscriber;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Presentation extends RuNodeComposit{

    private StateManager stateManager;
    private Image img;
    private String ime;
    private int index;
    private String autor;
    private List<Project> sharedProjects = new ArrayList<>();
    private List<Slide> slajdovi = new ArrayList<>();
    private File file;

    public Presentation(String ime){
        this.ime = ime;
        this.index = Integer.parseInt(ime.substring(ime.lastIndexOf(" ") + 1));
        stateManager = new StateManager();
    }

    public Presentation(){

    }

    public void addSharedProjects(Project p){
        if(sharedProjects.contains(p) || p == null){
            return;
        }
        sharedProjects.add(p);
    }
    public StateManager getStateManager() {
        return stateManager;
    }

    public List<Project> getSharedProjects() {
        return sharedProjects;
    }

    @Override
    public String toString() {
        return getIme();
    }

    public int getIndex() {
        return index;
    }

    public void addSlajd(Slide slajd){
        if(slajdovi.contains(slajd) || (slajd == null)){
            return;
        }

        slajdovi.add(slajd);
        notifySubscribers(slajd, ChildType.ADD_CHILD);
        for(Project pr : sharedProjects){
            for(Presentation pres : pr.getPrezentacije()){
                if(pres.getIme().equals(getIme())){
                    Slide slide = (Slide)slajd.clone();
                    pres.add(slide);
                }
            }
        }
    }
    public void removeSlajd(Slide slajd){
        if(!slajdovi.contains(slajd) || (slajd == null)){
            return;
        }
        slajdovi.remove(slajd);
        notifySubscribers(slajd, ChildType.REMOVE_CHILD);
    }
    public void setIme(String ime) {
        this.ime = ime;
        notifySubscribers(this, ChildType.CHANGE_NAME);
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setSlideBackground(Image img) {
        this.img = img;
        notifySubscribers(img, null);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public List<Slide> getSlajdovi() {
        return slajdovi;
    }

    public String getIme() {
        return ime;
    }

    public String getAutor() {
        return autor;
    }
}
