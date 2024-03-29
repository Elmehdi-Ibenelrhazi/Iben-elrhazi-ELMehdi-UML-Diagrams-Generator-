package org.mql.java.ui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import org.mql.java.complements.Project;


public class ClassFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	public ClassFrame(Project p) {
		setTitle("Diagrame de classe");
		setLocationRelativeTo(null);
		setContentPane(new JScrollPane(new ClassPanel(p)));
		pack();
		setSize(650, 700);
	    setLocation(0, 0);
		setVisible(true);
		

	}

}
