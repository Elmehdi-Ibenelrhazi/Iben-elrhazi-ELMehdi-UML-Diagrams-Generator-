package org.mql.java.ui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mql.java.complements.MyClass;
import org.mql.java.complements.Project;

public class ClassPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private int rows,cols,hgap=50,vgap=50;
	private Project projet;

	public ClassPanel(Project p) {
		rows = (int)Math.floor((double) Math.sqrt(p.getListeClasses().size()));
		cols = (int)Math.ceil((double) Math.sqrt(p.getListeClasses().size()));
		this.projet = p;
		
		setLayout(new GridLayout(rows, cols, hgap, vgap));
		addEntity();
	}

	private void addEntity() {
		for(MyClass cls : projet.getListeClasses()) {
			JPanel pl = new JPanel();
			JPanel e = new ClassComposants(cls);
			e.setBorder(new EmptyBorder(20,20,20,20));
			pl.add(e);
			add(pl);
			
		}
		
	}
	

}
