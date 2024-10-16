package controller;

import main.Main;
import model.workspace.MyTreeNode;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Workspace;
import view.gui.MainFrame;
import view.povrsinaview.PresentationView;
import view.povrsinaview.ProjectView;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Scanner;

public class MainFrameWindowController extends WindowAdapter {
    private String[] options = {"Yes", "No"};
    int result;

    @Override
    public void windowOpened(WindowEvent e) {
        File fw = new File("./workspace.txt");
        if(fw.length() == 0){
            return;
        }

        result = JOptionPane.showOptionDialog(MainFrame.getInstance(), "Da li zelite da otvorite prethodne komponente",
                "Poruka",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if(result == 0){
            Scanner sc = null;
            try {
                sc = new Scanner(fw);
                while (sc.hasNextLine()){
                    String path = sc.nextLine();
                    ObjectInputStream os = new ObjectInputStream(new FileInputStream(path));
                    Project p = null;
                    try{
                        p = (Project) os.readObject();
                    }catch (ClassNotFoundException ex){
                        ex.printStackTrace();
                    }
                    MyTreeNode node = new MyTreeNode((Workspace)MainFrame.getInstance().getStablo().getModel().getRoot());
                    node.add(p);
                    ProjectView pv = new ProjectView(p);
                    MainFrame.getInstance().addProjectView(pv);
                    for(Presentation pres : p.getPrezentacije()){
                        PresentationView pv2 = new PresentationView(pres);
                        pv.addPrezentacija(pv2);
                        pv.getTabovi().insertTab(pv2.getPres().getIme(), null,pv2, null, pres.getIndex() - 1);

                    }

                }
            }catch (IOException ex){
                ex.printStackTrace();
            }finally {
                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getStablo().getTree());
                if(sc != null){
                    sc.close();
                }
            }
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if(MainFrame.getInstance().getListaProjectView().isEmpty()){
            return;
        }
        int i = 0;
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(".//workspace.txt", false));
            for (ProjectView pv : MainFrame.getInstance().getListaProjectView()) {
                File file = pv.getProject().getFile();
                if (file == null) {
                    //ne mogu da se setim za directory kako da nadjem relativan tako da samo promenite :)
                    file = new File("C:\\Users\\ognje\\IdeaProjects\\rudok-ognjen10021rn3\\src\\pathtoworkspace\\project" + ++i + ".rde");
                        pw.println(file);
                } else {
                    return;
                }
                ObjectOutputStream os;
                try {
                    os = new ObjectOutputStream(new FileOutputStream(file));
                    os.writeObject(pv.getProject());
                    pv.getProject().setFile(file);

                    pv.getProject().setChanged(false);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }finally {
            if(pw != null){
                pw.close();
            }
        }
    }
    }
