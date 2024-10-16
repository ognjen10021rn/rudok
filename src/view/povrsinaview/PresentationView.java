package view.povrsinaview;

import model.workspace.MyTreeNode;
import model.workspace.Presentation;
import model.workspace.Slide;
import observer.ChildType;
import observer.ISubscriber;
import view.gui.MainFrame;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PresentationView extends JPanel implements ISubscriber {
    private Presentation pres;
    private Image background;
    private Box leftThumnnail;
    private Box rightSlideView;
    private SlideShowPane slideShowPane;
    private List<SlideView> slajdovi = new ArrayList<>();
    private List<ThumbnailView> thumbnails = new ArrayList<>();
    private JSplitPane splitPane;
    private JToolBar jToolBar = new JToolBar();
    public PresentationView(Presentation pres){
        this.pres = pres;
        this.pres.addSubscriber(this);
        setLayout(new BorderLayout());
        jToolBar.setFloatable(false);
        jToolBar.setOrientation(SwingConstants.HORIZONTAL);
        jToolBar.add(MainFrame.getInstance().getManager().getEditAction());
        jToolBar.add(MainFrame.getInstance().getManager().getPresentationShareAction());
        jToolBar.add(MainFrame.getInstance().getManager().getSlideShowAction());
        jToolBar.add(MainFrame.getInstance().getManager().getRectangleAction());
        jToolBar.add(MainFrame.getInstance().getManager().getChangeSlotState());
        jToolBar.add(MainFrame.getInstance().getManager().getSelectSlotAction());
        //jToolBar.add(MainFrame.getInstance().getManager().getImageSlotAction());
        //jToolBar.add(MainFrame.getInstance().getManager().getTextSlotAction());
        jToolBar.add(MainFrame.getInstance().getManager().getChangeSlotColorAction());
        jToolBar.add(MainFrame.getInstance().getManager().getMoveAction());
        jToolBar.add(MainFrame.getInstance().getManager().getDeleteSlotAction());
        leftThumnnail = Box.createVerticalBox();
        slideShowPane = new SlideShowPane();
        rightSlideView = Box.createVerticalBox();
        add(jToolBar, BorderLayout.NORTH);
        makeSlideView();
        JScrollPane leftScroll = new JScrollPane(leftThumnnail);
        JScrollPane rightScroll = new JScrollPane(rightSlideView);
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftScroll, rightScroll);
        splitPane.setDividerLocation(150);
        add(splitPane, BorderLayout.CENTER);

    }

    private void makeSlideView(){
        for(Slide slide : pres.getSlajdovi()){
            ThumbnailView tv = new ThumbnailView(slide);
            SlideView sv = new SlideView(slide);
            slajdovi.add(sv);
            slideShowPane.addSlajdShowSlajdovi(slide);
            thumbnails.add(tv);
            leftThumnnail.add(tv, slide.getIndex() - 1);
            rightSlideView.add(sv, slide.getIndex() - 1);
        }
    }
    public SlideShowPane getSlideShowPane() {
        return slideShowPane;
    }

    public List<SlideView> getSlajdovi() {
        return slajdovi;
    }

    public List<ThumbnailView> getThumbnails() {
        return thumbnails;
    }

    public Presentation getPres() {
        return pres;
    }

    public void setPrez(Presentation prez) {
        this.pres = prez;
    }


    @Override
    public void update(Object notification, ChildType childType) {
        if(notification instanceof Slide && childType.equals(ChildType.ADD_CHILD)){
            SlideView sv = new SlideView((Slide) notification);
            ThumbnailView tv = new ThumbnailView((Slide) notification);
            MyTreeNode node = new MyTreeNode(pres);
            int index = node.getIndex((Slide)notification);
            System.out.println(index);
            slajdovi.add(sv);
            slideShowPane.addSlajdShowSlajdovi((Slide)notification);
            thumbnails.add(tv);
            leftThumnnail.add(tv, ((Slide)notification).getIndex() - 1);
            rightSlideView.add(sv, ((Slide)notification).getIndex() - 1);
            //leftThumnnail.add(Box.createVerticalStrut(50));
            //rightSlideView.add(Box.createVerticalStrut(100));
            this.revalidate();
        }
        if(notification instanceof Slide && childType.equals(ChildType.REMOVE_CHILD)){
            MyTreeNode node = new MyTreeNode(pres);
            int index = node.getIndex((Slide)notification) + 1;
            System.out.println(index);
            slajdovi.remove(index);

            leftThumnnail.remove(index);
            //leftThumnnail.remove(index*2);

            rightSlideView.remove(index);
            //rightSlideView.remove(index*2);

            this.revalidate();
        }
        if(notification instanceof Image && childType == null){
            this.background = (Image) notification;
            for(SlideView slideView : slajdovi){
                slideView.setImage(background);
            }
        }
    }
}
