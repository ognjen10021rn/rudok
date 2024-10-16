package controller.serialization;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class ProjectFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        return (f.isDirectory() || f.getName().toLowerCase().endsWith(".rde"));
    }

    @Override
    public String getDescription() {
        return "RuDok Project files (*.rde)";
    }
}
