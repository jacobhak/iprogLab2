package se.kth.csc.iprog.dinnerplanner.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;


public class MainView extends JPanel {
	
	public MainView(DinnerModel model){
		setLayout(new GridBagLayout());
		setSize(600,400);

		GridBagConstraints mainConstraints = new GridBagConstraints();
		
		//JSeparator vertical = new JSeparator(JSeparator.VERTICAL);
		JSeparator vertical = new JSeparator();
		vertical.setOrientation(JSeparator.NORTH);
		vertical.setPreferredSize(new Dimension(5,2));
		mainConstraints.gridx = 1;
		mainConstraints.gridy = 0;
		mainConstraints.fill = GridBagConstraints.VERTICAL;
		this.add(vertical,mainConstraints);
		
		DishPickerView[] listDPV = new DishPickerView[3];
		listDPV[0] = new DishPickerView(model, 1);
		listDPV[1] = new DishPickerView(model, 2);
		listDPV[2] = new DishPickerView(model, 3);
		
		CoursesTabbedPane tabs = new CoursesTabbedPane(listDPV);
		mainConstraints.gridx = 0;
		mainConstraints.gridy = 0;
		this.add(tabs,mainConstraints);	
		
		
		DragAndDropMenu mainDragAndDropMenu = new DragAndDropMenu(model);
		mainConstraints.gridx = 2;
		mainConstraints.gridy = 0;
		this.add(mainDragAndDropMenu,mainConstraints);
		
		//JSeparator sep = new JSeparator();
		//sep.setOrientation(JSeparator.NORTH);
		
		
		
		/*
		this.add(new CoursesTabbedPane(dishPV), BorderLayout.CENTER);
		this.add(dishPV,BorderLayout.WEST);
		this.add(sep,BorderLayout.CENTER);
		this.add(new DragAndDropMenu(model),BorderLayout.EAST);
		*/
		//here you set other layout elements
	}
}
