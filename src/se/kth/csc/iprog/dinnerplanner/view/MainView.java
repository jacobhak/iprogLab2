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
import javax.swing.JTextField;


public class MainView extends JPanel {
	
	public MainView(DinnerModel model){
		JLabel label = new JLabel();
		
		label.setText(""+model.getTotalMenuPrice());
		JPanel dishPickerView = new JPanel(new BorderLayout());
		JPanel searchBarPanel = new JPanel(new FlowLayout());
		JTextField searchInput = new JTextField();
		searchInput.setText("Enter dish to search");
		JPanel dishesPanel = new JPanel(new GridLayout(2,4));
		searchBarPanel.add(new JLabel("SEARCH: "));
		searchBarPanel.add(searchInput);
		
		Icon dishIcon = new ImageIcon("images/icecream.jpg");
		
		JButton b1 = new JButton("iskräm",dishIcon);
		b1.setVerticalTextPosition(AbstractButton.BOTTOM);
		b1.setHorizontalTextPosition(AbstractButton.CENTER);
		
		//dishPickerView.add(label);
		dishesPanel.add(b1);
		dishesPanel.add(new JButton("dish2"));
		dishesPanel.add(new JButton("dish3"));
		dishesPanel.add(new JButton("dish4"));
		dishesPanel.add(new JButton("dish5"));
		dishesPanel.add(new JButton("dish6"));
		dishesPanel.add(new JButton("dish7"));
		dishesPanel.add(new JButton("dish8"));
		
		dishPickerView.add(searchBarPanel, BorderLayout.PAGE_START);
		dishPickerView.add(dishesPanel, BorderLayout.CENTER);
		
		this.add(dishPickerView);
		
		//here you set other layout elements
	}
}
