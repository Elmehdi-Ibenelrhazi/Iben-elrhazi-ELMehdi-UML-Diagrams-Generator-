package org.mql.java.ui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
		addEntity();
		
	}

	private void addEntity() {
		for (MyPackage p : projet.getListePackages()) {
			JPanel pl = new JPanel();
			JPanel e = new PComposant(p);
			e.setBorder(new EmptyBorder(20,20,20,20));
			pl.add(e);
			add(pl);
			
		}
	}
		
		

	public Project getProjet() {
		return projet;
	}

	public void setProjet(Project projet) {
		this.projet = projet;
	}
	

}
