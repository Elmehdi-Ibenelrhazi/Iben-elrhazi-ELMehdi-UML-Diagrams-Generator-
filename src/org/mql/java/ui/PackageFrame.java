package org.mql.java.ui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import org.mql.java.complements.Project;

public class PackageFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	

	public PackageFrame(Project p) {
		setTitle("Diagrame de package");
		setLocationRelativeTo(null);
		setContentPane(new JScrollPane(new PackagePanel(p)));
		pack();
		setSize(700,800);
	    setLocation(630,0);
		setVisible(true);
	}

}
