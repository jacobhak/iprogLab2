package se.kth.csc.iprog.dinnerplanner.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

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
        setSize(1024,386);

		GridBagConstraints mainConstraints = new GridBagConstraints();
		

		
		DishPickerView[] listDPV = new DishPickerView[3];
		listDPV[0] = new DishPickerView(model, Dish.STARTER);
		listDPV[1] = new DishPickerView(model, Dish.MAIN);
		listDPV[2] = new DishPickerView(model, Dish.DESERT);
		
		CoursesTabbedPane tabs = new CoursesTabbedPane(listDPV);
		mainConstraints.gridx = 0;
		mainConstraints.gridy = 0;
        mainConstraints.gridwidth = 5;
		this.add(tabs,mainConstraints);


        JSeparator vertical = new JSeparator();
        vertical.setOrientation(JSeparator.NORTH);
        mainConstraints = new GridBagConstraints();
        mainConstraints.gridx = 5;
        mainConstraints.gridy = 0;
        mainConstraints.fill = GridBagConstraints.VERTICAL;
        this.add(vertical,mainConstraints);
		
		DragAndDropMenu mainDragAndDropMenu = new DragAndDropMenu(model);
        mainConstraints = new GridBagConstraints();
		mainConstraints.gridx = 6;
		mainConstraints.gridy = 0;
        mainConstraints.gridwidth = 1;
		this.add(mainDragAndDropMenu,mainConstraints);
	}
}
