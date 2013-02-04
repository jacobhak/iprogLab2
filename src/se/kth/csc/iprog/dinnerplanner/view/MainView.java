package se.kth.csc.iprog.dinnerplanner.view;

import java.awt.BorderLayout;
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
		JLabel label = new JLabel();
		setLayout(new BorderLayout());
		
		label.setText(""+model.getTotalMenuPrice());
		
		JSeparator sep = new JSeparator();
		sep.setOrientation(JSeparator.NORTH);
		
		this.add(new dishPickerView(),BorderLayout.WEST);
		this.add(sep,BorderLayout.CENTER);
		this.add(new DragAndDropMenu(model),BorderLayout.EAST);
		
		//here you set other layout elements
	}
}
