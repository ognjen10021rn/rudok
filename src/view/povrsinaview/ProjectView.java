package view.povrsinaview;

import model.workspace.MyTreeNode;
import model.workspace.Presentation;
import model.workspace.Project;
import observer.ChildType;
import observer.ISubscriber;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectView extends JPanel implements ISubscriber {
    private Project project;
    private JLabel imeProjekta = new JLabel();
    private JTabbedPane tabovi;
    private List<PresentationView> prezentacije = new ArrayList<>();
    public ProjectView(Project project){
        this.project = project;
        this.project.addSubscriber(this);
        initialize();

    }

    private void initialize(){
        setVisible(false);
        setLayout(new BorderLayout());
        imeProjekta.setText(project.getIme());
        tabovi = new JTabbedPane();
        add(imeProjekta, BorderLayout.NORTH);
        add(tabovi, BorderLayout.CENTER);
    }

    public void removePrezentacija(PresentationView pv){
        prezentacije.remove(pv);
    }

    public void addPrezentacija(PresentationView pv){
        prezentacije.add(pv);
    }

    public void setPrezentacije(List<PresentationView> prezentacije) {
        this.prezentacije = prezentacije;
    }

    public JLabel getImeProjekta() {
        return imeProjekta;
    }

    public JTabbedPane getTabovi() {
        return tabovi;
    }

    public List<PresentationView> getPrezentacije() {
        return prezentacije;
    }

    public Project getProject() {
        return project;
    }

    @Override
    public void update(Object notification, ChildType childType) {
        revalidate();
        if(notification instanceof Project && childType.equals(ChildType.CHANGE_NAME)){
            imeProjekta.setText(project.getIme());
            imeProjekta.revalidate();
        }
        if(notification instanceof Presentation && childType.equals(ChildType.ADD_CHILD)){
            PresentationView pv = new PresentationView((Presentation) notification);
            MyTreeNode node = new MyTreeNode(project);
            int index = node.getIndex((Presentation)notification);
            prezentacije.add(pv);
            tabovi.insertTab(pv.getPres().getIme(), null,pv, null, ((Presentation)notification).getIndex() - 1);
            tabovi.revalidate();
        }
        if(notification instanceof Presentation && childType.equals(ChildType.REMOVE_CHILD)){
            MyTreeNode node = new MyTreeNode(project);
            int index = node.getIndex((Presentation)notification) + 1;
            tabovi.removeTabAt(index);
            prezentacije.remove(index);
            tabovi.revalidate();
        }
    }
}
