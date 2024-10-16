package view.povrsinaview;

import controller.MouseController;
import model.paintmodel.Slot;
import model.workspace.Slide;
import observer.ChildType;
import observer.ISubscriber;
import view.painterview.SlotView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SlideView extends JPanel implements ISubscriber {
    private Slide slide;
    private Dimension dim = new Dimension(500, 300);
    private Image image;
    private List<SlotView> slotViewList = new ArrayList<>();

    public SlideView(Slide slide){
        this.slide = slide;
        this.slide.addSubscriber(this);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(Color.WHITE);
        setPreferredSize(dim);
        setMinimumSize(dim);
        setMaximumSize(dim);
        this.addMouseListener(new MouseController(slide, this));
        this.addMouseMotionListener(new MouseController(slide, this));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
        if(slotViewList.isEmpty()){
            addSlotViews();
        }

        for(SlotView slotView : slotViewList){
            slotView.paint((Graphics2D) g);
        }
    }

    public void setImage(Image image) {
        this.image = image;
    }
    public void addSlotViews(){
        for(Slot slot : slide.getSlots()){
            SlotView sv = new SlotView(slot);
            slotViewList.add(sv);
        }
    }
    public void addSlotView(SlotView sv){
        if(slotViewList.contains(sv) || (sv == null)){
            return;
        }
        slotViewList.add(sv);
    }
    public void removeSlotView(SlotView sv){
        if(!slotViewList.contains(sv) || (sv == null)){
            return;
        }
        slotViewList.remove(sv);
    }

    public List<SlotView> getSlotViewList() {
        return slotViewList;
    }

    public Slide getSlide() {
        return slide;
    }

    public void setSlide(Slide slide) {
        this.slide = slide;
    }

    @Override
    public void update(Object notification, ChildType childType) {
        if(notification instanceof Image && childType == null){
            this.image =(Image) notification;
            this.revalidate();
        }
        if(notification instanceof Slot && childType.equals(ChildType.ADD_CHILD)){
            SlotView sv = new SlotView((Slot) notification);
            addSlotView(sv);
            this.repaint();
        }
        if(notification instanceof Slot && childType.equals(ChildType.PAINT_RECTANGLE)){
            repaint();
        }
        if(notification instanceof Slot && childType.equals(ChildType.REMOVE_CHILD)){
            repaint();
        }
    }
}
