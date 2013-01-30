package se.kth.csc.iprog.dinnerplanner.view;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainView extends JPanel {
	
	public MainView(DinnerModel model){
		JLabel label = new JLabel();
		label.setText(""+model.getTotalMenuPrice());
		this.add(label);
		
		//here you set other layout elements
	}
}
