package controller.actions;

import controller.actions.*;
import controller.serialization.OpenPresentationAction;
import controller.serialization.OpenProjectAction;
import controller.serialization.SavePresentationAction;
import controller.serialization.SaveProjectAction;

public class ActionManager{

    private InfoAction infoAction;
    private NewAction newAction;
    private DeleteAction deleteAction;
    private AddImageAction addImageAction;
    private EditAction editAction;
    private SlideShowAction slideShowAction;
    private RectangleAction rectangleAction;
    private MoveAction moveAction;
    private ImageSlotAction imageSlotAction;
    private TextSlotAction textSlotAction;
    private DeleteSlotAction deleteSlotAction;
    private ChangeSlotColorAction changeSlotColorAction;
    private ChangeSlotAction changeSlotAction;
    private SelectSlotAction selectSlotAction;
    private UndoAction undoAction;
    private RedoAction redoAction;
    private BoldAction boldAction;
    private ItalicAction italicAction;
    private UnderlineAction underlineAction;
    private PresentationShareAction presentationShareAction;
    private SubmitAction submitAction;
    private SaveProjectAction saveProjectAction;
    private OpenProjectAction openProjectAction;
    private SavePresentationAction savePresentationAction;
    private OpenPresentationAction openPresentationAction;

    public ActionManager(){
        loadActions();
    }

    private void loadActions(){
        newAction = new NewAction();
        redoAction = new RedoAction();
        infoAction = new InfoAction();
        openPresentationAction = new OpenPresentationAction();
        savePresentationAction = new SavePresentationAction();
        saveProjectAction = new SaveProjectAction();
        openProjectAction = new OpenProjectAction();
        boldAction = new BoldAction();
        italicAction = new ItalicAction();
        underlineAction = new UnderlineAction();
        submitAction = new SubmitAction();
        undoAction = new UndoAction();
        deleteAction = new DeleteAction();
        addImageAction = new AddImageAction();
        editAction = new EditAction();
        slideShowAction = new SlideShowAction();
        rectangleAction = new RectangleAction();
        moveAction = new MoveAction();
        deleteSlotAction = new DeleteSlotAction();
        changeSlotColorAction = new ChangeSlotColorAction();
        imageSlotAction = new ImageSlotAction();
        textSlotAction = new TextSlotAction();
        changeSlotAction = new ChangeSlotAction();
        selectSlotAction = new SelectSlotAction();
        presentationShareAction = new PresentationShareAction();
    }

    public OpenPresentationAction getOpenPresentationAction() {
        return openPresentationAction;
    }

    public SavePresentationAction getSavePresentationAction() {
        return savePresentationAction;
    }

    public OpenProjectAction getOpenProjectAction() {
        return openProjectAction;
    }

    public SaveProjectAction getSaveProjectAction() {
        return saveProjectAction;
    }

    public UnderlineAction getUnderlineAction() {
        return underlineAction;
    }

    public ItalicAction getItalicAction() {
        return italicAction;
    }

    public BoldAction getBoldAction() {
        return boldAction;
    }

    public SubmitAction getSubmitAction() {
        return submitAction;
    }

    public PresentationShareAction getPresentationShareAction() {
        return presentationShareAction;
    }

    public RedoAction getRedoAction() {
        return redoAction;
    }

    public UndoAction getUndoAction() {
        return undoAction;
    }

    public ChangeSlotAction getChangeSlotAction() {
        return changeSlotAction;
    }

    public SelectSlotAction getSelectSlotAction() {
        return selectSlotAction;
    }

    public ChangeSlotAction getChangeSlotState() {
        return changeSlotAction;
    }

    public ImageSlotAction getImageSlotAction() {
        return imageSlotAction;
    }

    public TextSlotAction getTextSlotAction() {
        return textSlotAction;
    }

    public ChangeSlotColorAction getChangeSlotColorAction() {
        return changeSlotColorAction;
    }

    public DeleteSlotAction getDeleteSlotAction() {
        return deleteSlotAction;
    }

    public MoveAction getMoveAction() {
        return moveAction;
    }

    public RectangleAction getRectangleAction() {
        return rectangleAction;
    }

    public EditAction getEditAction() {
        return editAction;
    }

    public SlideShowAction getSlideShowAction() {
        return slideShowAction;
    }

    public AddImageAction getAddImageAction() {
        return addImageAction;
    }

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public NewAction getNewAction() {
        return newAction;
    }

    public InfoAction getInfo() {
        return infoAction;
    }
}
