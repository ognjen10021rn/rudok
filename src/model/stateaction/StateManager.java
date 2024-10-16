package model.stateaction;

import model.state.State;

import java.io.Serializable;

public class StateManager implements Serializable {
    private AddSlotState addSlotState;
    private SlideShowState slideShowState;
    private EditState editState;
    private MoveRecState moveRecState;
    private PaintSlotState paintSlotState;
    private DeleteSlotState deleteSlotState;
    private ImageSlotState imageSlotState;
    private TextSlotState textSlotState;
    private SelectSlotState selectSlotState;

    private State currentState;

    public StateManager(){
        addSlotState = new AddSlotState();
        slideShowState = new SlideShowState();
        editState = new EditState();
        moveRecState = new MoveRecState();
        deleteSlotState = new DeleteSlotState();
        paintSlotState = new PaintSlotState();
        imageSlotState = new ImageSlotState();
        textSlotState = new TextSlotState();
        selectSlotState = new SelectSlotState();
        currentState = editState;
    }

    public void setSelectSlotState() {
        this.currentState = selectSlotState;
    }

    public void setImageSlotState() {
        this.currentState = imageSlotState;
    }

    public void setTextSlotState() {
        this.currentState = textSlotState;
    }

    public void setPaintSlotState() {
        this.currentState = paintSlotState;
    }

    public void setDeleteSlotState() {
        this.currentState = deleteSlotState;
    }

    public void setMoveRecState() {
        this.currentState = moveRecState;
    }

    public void setEditState() {
        this.currentState = editState;
    }

    public void setSlideShowState() {
        this.currentState = slideShowState;
    }

    public void setPaintState() {
        this.currentState = addSlotState;
    }

    public AddSlotState getAddSlotState() {
        return addSlotState;
    }

    public SlideShowState getSlideShowState() {
        return slideShowState;
    }

    public State getCurrentState() {
        return currentState;
    }
}
