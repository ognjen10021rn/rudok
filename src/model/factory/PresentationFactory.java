package model.factory;

import model.workspace.Presentation;
import model.workspace.runode.RuNode;

public class PresentationFactory extends AbstractNodeFactory{
    private static int i = 1;
    @Override
    public RuNode createNode(Object o) {

        return new Presentation("Prezentacija " + i++);
    }
}
