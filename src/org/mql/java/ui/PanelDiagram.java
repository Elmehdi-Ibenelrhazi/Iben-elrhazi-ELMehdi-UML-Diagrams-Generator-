package org.mql.java.ui;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelDiagram extends JPanel{
 
	
	private static final long serialVersionUID = 1L;
	private JButton buttonClasse,buttonPackage;
	
	
	
	public PanelDiagram() {
		setLayout(new BorderLayout());
		JPanel p = new JPanel();
		JPanel c = new JPanel();
		JPanel pk = new JPanel();
		buttonClasse = new JButton("Diagramme de classe");
		buttonPackage = new JButton("Diagrame de package");
		buttonClasse.setBorder(new EmptyBorder(10,12,10,12));
		buttonPackage.setBorder(new EmptyBorder(10,12,10,15));
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS ));
		p.setBorder(new EmptyBorder(10,10,10,10));
		c.add(buttonClasse);
		p.add(c);
		pk.add(buttonPackage);
		p.add(pk);
		add(p, BorderLayout.CENTER);
		}

}
