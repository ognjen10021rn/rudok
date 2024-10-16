package controller.serialization;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class PresentationFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        return (f.isDirectory() || f.getName().toLowerCase().endsWith(".rdep"));
    }

    @Override
    public String getDescription() {
        return "RuDok Presentation files (*.rdep)";
    }
}
