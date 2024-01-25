package org.mql.java.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.mql.java.complements.MyClass;

public class ClassComposants extends JPanel{


	private static final long serialVersionUID = 1L;
	private MyClass cls;

	public ClassComposants(MyClass cls) {
		this.cls = cls;
		setLayout(new BorderLayout());
		JPanel classBody = new JPanel();
		classBody.setLayout(new BorderLayout());
		classBody.setBorder(new LineBorder(Color.black));
		addName();
		addFields(classBody);
		addMethod(classBody);
		add(classBody, BorderLayout.CENTER);

	}
	public void addMethod(JPanel classBody) {
		JPanel methods = new JPanel();
		methods.setLayout(new BoxLayout(methods, BoxLayout.Y_AXIS));
		methods.setBorder(new LineBorder(Color.black));
		for(Method m : cls.getMethods()) {
			String labelText = getModifier(m.getModifiers()) + " " + m.getReturnType().getSimpleName() + " : " + m.getName() + "()";
			JLabel label = new JLabel(labelText);
			label.setBorder(new EmptyBorder(2,0,2,0));
			methods.add(label);
		}
		
		classBody.add(methods, BorderLayout.SOUTH);
	}
	public void addFields(JPanel classBody) {
		JPanel fields = new JPanel();
		fields.setBorder(new LineBorder(Color.black));
		fields.setLayout(new BoxLayout(fields, BoxLayout.Y_AXIS));


		for(Field f: cls.getAttributes()) {
			String labelText = getModifier(f.getModifiers()) + " " + f.getType().getSimpleName() + " : " + f.getName();
			JLabel label = new JLabel(labelText);
			label.setBorder(new EmptyBorder(2,0,2,0));
			fields.add(label);
		
		
	}
		classBody.add(fields, BorderLayout.NORTH);
	}
	
	public void addName() {
		JPanel namePanel = new  JPanel();
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
		namePanel.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.black),new EmptyBorder(0, 5, 0, 5)));
		namePanel.setOpaque(false);
		JLabel nameLabel = new JLabel(cls.getClasseName());
		nameLabel.setAlignmentX(CENTER_ALIGNMENT);
		namePanel.add(nameLabel);
		add(namePanel,BorderLayout.NORTH);
		
	}
	



	private String getModifier(int modifier) {
		if(Modifier.isPublic(modifier)) {
			return "+";
		}
		else if(Modifier.isPrivate(modifier)) {
			return "-";
		}
		else if(Modifier.isProtected(modifier)) {
			return "~";
		}
		return " ";
	}
}
