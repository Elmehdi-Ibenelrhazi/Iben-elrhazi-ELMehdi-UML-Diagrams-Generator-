package org.mql.java.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mql.java.Extractor.ProjectAnalyzer;
import org.mql.java.complements.Project;

public class Form extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton button;


	public Form() {
		button = new JButton("Parcourir");
		button.addActionListener(this);
		button.setBorder(new EmptyBorder(20,20,20,20));
		button.setPreferredSize(new Dimension(100, 40));
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		add(button);
		
		

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String path = "";
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setApproveButtonText("Selectionner");
		fileChooser.setDialogTitle("Selectionner un dossier");
		int val = fileChooser.showOpenDialog(this);
		if(val == JFileChooser.APPROVE_OPTION) {
			path = fileChooser.getSelectedFile().getAbsolutePath();
		} else {
			return;
		}
		if("".equals(path)) {
			return;
		}
		ProjectAnalyzer analyser= new ProjectAnalyzer(path);
		Project project = analyser.traverseProject();
		if(project == null) {
			System.out.println(" projet introuvable");
			return;
		}

		new ClassFrame(project);
		new PackageFrame(project);////affichage incorrete á revenir 



	}

}
