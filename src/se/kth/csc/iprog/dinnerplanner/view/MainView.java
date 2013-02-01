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
		
		
		//Images on our avaliable dishes
		Icon dishIcon = new ImageIcon("images/icecream.jpg");
		
		//Text for our avaliable dishes
		String[] avaliableDishes = new String[8];
		avaliableDishes[0] = "Bakedbrie";
		avaliableDishes[1] = "Icecream";
		avaliableDishes[2] = "Meatballs";
		avaliableDishes[3] = "Sourdough";
		avaliableDishes[4] = "Toast";
		avaliableDishes[5] = "Pizza";
		avaliableDishes[6] = "Pancake";
		avaliableDishes[7] = "Salmon";
		
		int numberOfDishes = avaliableDishes.length;
		
		for(int i = 0; i<numberOfDishes;i++) {
		//	dishesPanel.add(new JButton("dish"+i));
			JButton dishButton = new JButton(avaliableDishes[i],dishIcon);
			dishButton.setVerticalTextPosition(AbstractButton.BOTTOM);
			dishButton.setHorizontalTextPosition(AbstractButton.CENTER);
			dishesPanel.add(dishButton);
		}
		
		
		
		//dishPickerView.add(label);
		//dishesPanel.add(new JButton("dish2"));
		//dishesPanel.add(new JButton("dish3"));
		//dishesPanel.add(new JButton("dish4"));
		//dishesPanel.add(new JButton("dish5"));
		//dishesPanel.add(new JButton("dish6"));
		//dishesPanel.add(new JButton("dish7"));
		//dishesPanel.add(new JButton("dish8"));
		
		dishPickerView.add(searchBarPanel, BorderLayout.PAGE_START);
		dishPickerView.add(dishesPanel, BorderLayout.CENTER);
		
		this.add(dishPickerView);
		
		//here you set other layout elements
	}
}
