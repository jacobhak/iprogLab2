package se.kth.csc.iprog.dinnerplanner.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class dishPickerView extends Container{
	
	private JTextField searchInput;
	private JPanel searchBarPanel;
	private JPanel dishesPanel;
	private int numberOfDishes;
	
	
	public dishPickerView() {
		setLayout(new BorderLayout());
		
		searchInput = new JTextField();
		searchInput.setText("Enter dish to search");
		
		searchBarPanel = new JPanel(new FlowLayout());
		searchBarPanel.add(new JLabel("SEARCH: "));
		searchBarPanel.add(searchInput);
		

		dishesPanel = new JPanel(new GridLayout(2,4));
		
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
		
		numberOfDishes = avaliableDishes.length;
		
		//Images on our avaliable dishes
		Icon dishIcon = new ImageIcon("images/icecream.jpg");

		for(int i = 0; i<numberOfDishes;i++) {
			JButton dishButton = new JButton(avaliableDishes[i],dishIcon);
			dishButton.setVerticalTextPosition(AbstractButton.BOTTOM);
			dishButton.setHorizontalTextPosition(AbstractButton.CENTER);
			dishesPanel.add(dishButton);
		}
		this.add(searchBarPanel, BorderLayout.PAGE_START);
		this.add(dishesPanel, BorderLayout.CENTER);
	}
}
