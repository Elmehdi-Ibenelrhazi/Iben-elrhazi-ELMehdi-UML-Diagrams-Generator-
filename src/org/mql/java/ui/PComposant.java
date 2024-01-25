package org.mql.java.ui;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mql.java.complements.MyPackage;

public class PComposant extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private MyPackage pkg;
	private int cols, rows, hgap = 50, vgap = 50;
	
	public PComposant(MyPackage p) {
		this.pkg = p;
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(50, 50, 50, 50));
		if(p.getListePackages().size() == 0) {
			add(Box.createRigidArea(new Dimension(250,180)));
		}
		else {
			cols = (int)Math.floor(Math.sqrt(p.getListePackages().size()));
			rows = (int)Math.ceil(Math.sqrt(p.getListePackages().size()));
			
			setLayout(new GridLayout(rows, cols, hgap, vgap));
			for(MyPackage pkg : p.getListePackages()) {
				add(new PComposant(pkg));
			}
		}
		setOpaque(false);
	}
		
	}


