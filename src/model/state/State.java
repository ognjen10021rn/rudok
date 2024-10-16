package model.state;

import model.paintmodel.Slot;
import model.workspace.Slide;
import view.povrsinaview.SlideView;

import java.io.Serializable;

public abstract class State implements Serializable {
    public void showPanel(){

    }
    public void mousePressed(Slide slide, SlideView slideView, int x, int y){

    }

    public void mouseClicked(Slide slide, SlideView slideView, int x, int y){

    }
    public void mouseDragged(int x, int y){

    }
    public void mouseReleased(int x, int y){

    }
    //void mouseDragged();
}
