package se.kth.csc.iprog.dinnerplanner.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class DishPickerView extends JPanel{
	
	private JTextField searchInput;
	private JPanel searchBarPanel;
	private JPanel dishesPanel;
	private JScrollPane scrollPane;
	private int numberOfDishes;
	private Set<Dish> dishes;
	
	
	public DishPickerView(DinnerModel dm, int dishType) {
		setLayout(new BorderLayout());
		dishes = dm.getDishesOfType(dishType);
		
		//searchBar panel
		searchInput = new JTextField();
		searchInput.setText("Enter dish to search");
		
		searchBarPanel = new JPanel(new FlowLayout());
		searchBarPanel.add(new JLabel("SEARCH: "));
		searchBarPanel.add(searchInput);
		
		
		dishesPanel = new JPanel(new GridLayout(2,4));

		Iterator<Dish> it = dishes.iterator();
		
		while(it.hasNext()) {
			Dish currentDish = it.next();
			String dishName = currentDish.getName();
			String imageURL = "images/"+currentDish.getImage();
			Icon dishIcon = new ImageIcon(imageURL);
			
			JButton dishButton = new JButton(dishName,dishIcon);
			dishButton.setVerticalTextPosition(AbstractButton.BOTTOM);
			dishButton.setHorizontalTextPosition(AbstractButton.CENTER);
			dishesPanel.add(dishButton);
		}			
		
		// Make scrollbar for dishes
		scrollPane = new JScrollPane(dishesPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		// Add this to main layout
		this.add(searchBarPanel, BorderLayout.PAGE_START);
		this.add(scrollPane, BorderLayout.CENTER);
	}
}
