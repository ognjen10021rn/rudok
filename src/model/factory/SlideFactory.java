package model.factory;

import model.workspace.Slide;
import model.workspace.runode.RuNode;

public class SlideFactory extends AbstractNodeFactory{
    private static int i = 1;
    @Override
    public RuNode createNode(Object o) {
        return new Slide("Slajd " + i++);
    }
}
