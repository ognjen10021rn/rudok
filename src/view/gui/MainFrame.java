package view.gui;

import controller.actions.ActionManager;
import controller.MainFrameWindowController;
import controller.commands.CommandManager;
import view.povrsinaview.ProjectView;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    private static MainFrame instance = null;
    private EditPane editPane;
    private ActionManager manager;
    private Toolbar toolbar;
    private Menu menu;
    private Stablo stablo;
    private RadnaPovrsina povrsina;
    private CommandManager commandManager;
    private JSplitPane splitPane;
    private List<ProjectView> listaProjectView = new ArrayList<>();
    private ProjectView projectView;


    private MainFrame(){
    }
    private void initialize(){

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        setTitle("RuDok");
        int width = dim.width/2;
        int height = dim.height/2;
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        editPane = new EditPane();
        manager = new ActionManager();
        commandManager = new CommandManager();
        toolbar = new Toolbar();
        menu = new Menu();
        stablo = new Stablo();
        povrsina = new RadnaPovrsina();

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, stablo, povrsina);
        splitPane.setDividerLocation(200);
        editPane.add(toolbar, BorderLayout.NORTH);
        setJMenuBar(menu);
        editPane.add(splitPane);
        MainFrame.getInstance().setContentPane(editPane);
        this.addWindowListener(new MainFrameWindowController());

    }
    public void addProjectView(ProjectView pv){
        if(listaProjectView.contains(pv) || (pv == null)){
            return;
        }
        listaProjectView.add(pv);
        povrsina.add(pv);
    }
    public void removeProjectView(ProjectView pv){
        if(listaProjectView.contains(pv) || (pv == null)){
            return;
        }
        listaProjectView.remove(pv);
        povrsina.remove(pv);
    }

    public void setProjectView(ProjectView projectView) {
        this.projectView = projectView;
        povrsina.add(projectView);
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    public EditPane getEditPane() {
        return editPane;
    }

    public ProjectView getProjectView() {
        return projectView;
    }

    public List<ProjectView> getListaProjectView() {
        return listaProjectView;
    }

    public Stablo getStablo() {
        return stablo;
    }

    public ActionManager getManager() {
        return manager;
    }

    public RadnaPovrsina getPovrsina() {
        return povrsina;
    }

    public static MainFrame getInstance() {
        if(instance == null){
            instance = new MainFrame();
            instance.initialize();
        }
        return instance;
    }
}
