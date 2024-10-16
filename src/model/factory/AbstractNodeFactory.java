package model.factory;

import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Workspace;
import model.workspace.runode.RuNode;

public abstract class AbstractNodeFactory{
    public RuNode nodeForTree(Object o){
        RuNode node = null;

        if(o instanceof Workspace || o == null){
            node = (Workspace)o;
        }else if(o instanceof Project){
            node = (Project)o;
        }
        else if(o instanceof Presentation){
            node = (Presentation)o;
        }
        return node;
    }

    public abstract RuNode createNode(Object o);

}
