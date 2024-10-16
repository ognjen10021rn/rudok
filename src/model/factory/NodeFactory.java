package model.factory;

import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Workspace;

public class NodeFactory {
    private final ProjectFactory projectFactory = new ProjectFactory();
    private final PresentationFactory presentationFactory = new PresentationFactory();
    private final SlideFactory slideFactory = new SlideFactory();

    public AbstractNodeFactory returnNodeFactory(Object o){
        if(o instanceof Workspace){
            return projectFactory;
        }
        if(o instanceof Project){
            return presentationFactory;
        }
        if(o instanceof Presentation){
            return slideFactory;
        }
        return projectFactory;
    }
}
