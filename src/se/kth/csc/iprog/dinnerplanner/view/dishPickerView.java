package se.kth.csc.iprog.dinnerplanner.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.HashSet;
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
	private JButton searchButton;
	private JPanel dishesPanel;
	private JScrollPane scrollPane;
	private Set<Dish> dishes;
	private Set<JButton> dishButtons;
    private int dishType;
	
	
	public DishPickerView(DinnerModel dm, int dishType) {
		setLayout(new BorderLayout());
		dishes = dm.getDishesOfType(dishType);
		dishButtons = new HashSet<JButton>();
        this.dishType = dishType;
		
		//searchBar panel
		searchInput = new JTextField();
		searchInput.setText("Enter dish to search");
        searchInput.setColumns(20);
		
		searchBarPanel = new JPanel(new FlowLayout());
		searchBarPanel.add(new JLabel("SEARCH: "));
		searchBarPanel.add(searchInput);
		searchButton = new JButton("Search");
		searchBarPanel.add(searchButton);
		
		
		dishesPanel = new JPanel(new GridLayout(2,4));
        setDishes(dishes);
		
		// Make scrollbar for dishes
		scrollPane = new JScrollPane(dishesPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		// Add this to main layout
		this.add(searchBarPanel, BorderLayout.PAGE_START);
		this.add(scrollPane, BorderLayout.CENTER);
	}
	
	public JButton getSearchButton(){
		return searchButton;
	}
	
	public Set<JButton> getDishButtons(){
		return dishButtons;
	}

    public String getSearchInput() {
        return searchInput.getText().toString();
    }

    public int getDishType() {
        return dishType;
    }

    public void setDishes(Set<Dish> dishes) {
        if (dishes != this.dishes) this.dishes.clear();
        this.dishesPanel.removeAll();
        this.dishButtons.clear();
        this.dishes = dishes;
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
            dishButtons.add(dishButton);
        }
        this.updateUI();
    }
}
