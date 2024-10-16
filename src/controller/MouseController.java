package controller;

import model.workspace.Slide;
import view.gui.MainFrame;
import view.povrsinaview.PresentationView;
import view.povrsinaview.SlideView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseController extends MouseAdapter {

    private SlideView slideView;
    private Slide slide;

    public MouseController(Slide slide, SlideView slideView){
        this.slide = slide;
        this.slideView = slideView;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        ((PresentationView)MainFrame.getInstance().getProjectView().getTabovi().getSelectedComponent()).
                getPres().getStateManager().getCurrentState().mousePressed(slide, slideView, e.getX(), e.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        ((PresentationView)MainFrame.getInstance().getProjectView().getTabovi().getSelectedComponent()).
                getPres().getStateManager().getCurrentState().mouseDragged(e.getX(), e.getY());

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ((PresentationView)MainFrame.getInstance().getProjectView().getTabovi().getSelectedComponent()).
                getPres().getStateManager().getCurrentState().mouseReleased( e.getX(), e.getY());

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){
            ((PresentationView)MainFrame.getInstance().getProjectView().getTabovi().getSelectedComponent()).
                    getPres().getStateManager().getCurrentState().mouseClicked(slide, slideView, e.getX(), e.getY());
        }
    }

    public SlideView getSlideView() {
        return slideView;
    }

    public void setSlideView(SlideView slideView) {
        this.slideView = slideView;
    }

    public Slide getSlide() {
        return slide;
    }

    public void setSlide(Slide slide) {
        this.slide = slide;
    }
}
