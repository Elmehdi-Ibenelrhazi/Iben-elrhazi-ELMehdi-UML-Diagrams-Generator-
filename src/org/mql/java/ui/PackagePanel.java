package org.mql.java.ui;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

import org.mql.java.complements.MyPackage;
import org.mql.java.complements.Project;

public class PackagePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private int rows,cols,hgap=50,vgap=50;
	private Project projet;
	
	public PackagePanel(Project p) {
		rows = (int)Math.floor((double) Math.sqrt(p.getListePackages().size()));
		cols = (int)Math.ceil((double) Math.sqrt(p.getListePackages().size()));
		
		this.setProjet(p);
		setLayout(new GridLayout(rows, cols, hgap, vgap));
		// Filtrer les éventuels packages null avant de les ajouter à la grille.
		List<MyPackage> list = projet.getListePackages().stream().filter(item -> item != null).toList();
		addPackages(list);
		
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
	}
	

}
