package org.mql.java.ui;

import java.awt.GridLayout;
import java.util.List;
import javax.swing.JPanel;
import org.mql.java.complements.MyPackage;
import org.mql.java.complements.Project;

public class PackagePanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private int rows, cols, hgap = 50, vgap = 50;
    private Project projet;

    public PackagePanel(Project p) {
        this.projet = p;

        List<MyPackage> list = p.getListePackages().stream().filter(item -> item != null).toList();
        if (!list.isEmpty()) {
            rows = (int) Math.floor(Math.sqrt(list.size()));
            cols = (int) Math.ceil(Math.sqrt(list.size()));
            setLayout(new GridLayout(rows, cols, hgap, vgap));
            addPackages(list);
        }
    }

    private void addPackages(List<MyPackage> packages) {
        for (MyPackage p : packages) {
            add(new PackageComposant(p));
        }
    }

    public Project getProjet() {
        return projet;
    }

    public void setProjet(Project projet) {
        this.projet = projet;
        rows = (int) Math.floor(Math.sqrt(projet.getListePackages().size()));
        cols = (int) Math.ceil(Math.sqrt(projet.getListePackages().size()));
        revalidate();
        repaint();
    }
}