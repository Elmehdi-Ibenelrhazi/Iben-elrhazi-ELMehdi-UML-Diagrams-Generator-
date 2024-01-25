package org.mql.java.ui;



import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mql.java.complements.MyPackage;

public class PackageComposant extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private MyPackage pkg;
	private int cols, rows, hgap = 50, vgap = 50;
	
	public PackageComposant(MyPackage p) {
		this.pkg = p;
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(50, 50, 50, 50));
		List<MyPackage> list = p.getListePackages().stream().filter(item -> item != null).toList();
		if(list.size() == 0) {
			add(Box.createRigidArea(new Dimension(250,180)));
		}
		else {
			cols = (int)Math.floor(Math.sqrt(p.getListePackages().size()));
			rows = (int)Math.ceil(Math.sqrt(p.getListePackages().size()));
			
			setLayout(new GridLayout(rows, cols, hgap, vgap));
			addPackages(list);
		}
		setOpaque(false);
	}
	
	//Ajouter des composants graphiques représentant les sous-packages à la vue actuelle.
 
	 private void addPackages(List<MyPackage> packages) {
	        for (MyPackage subPackage : packages) {
	            add(new PackageComposant(subPackage));
	        }
	    }



	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
		Graphics2D d = (Graphics2D)g;
		d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		d.setFont(new Font("Arial", Font.BOLD, 16));
		FontMetrics fm = g.getFontMetrics();
		Rectangle2D rect = fm.getStringBounds(pkg.getNamePackage(), g);
		d.setStroke(new BasicStroke(2f));
		d.setColor(new Color(45, 88, 134)); 
		d.fillRoundRect(0, 0, (int)rect.getWidth() + 10, (int)rect.getHeight() + 10, 5, 5);
		d.drawRoundRect(1, (int)rect.getHeight() + 10, getWidth() - 3, getHeight() - (int)rect.getHeight() - 10 - 2, 4, 4);
		d.drawLine(1, (int)rect.getHeight(), 1, (int)rect.getHeight() + 20);
		d.setColor(Color.white);
		d.drawString(pkg.getNamePackage(),5, (int)rect.getHeight());
		
		
	}
	
	}
		
	


