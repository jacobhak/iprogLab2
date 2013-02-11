package se.kth.csc.iprog.dinnerplanner.view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class MenuItem extends JPanel{

    private JButton deleteDish;
	private DishTitleImageView showDishInMenu;
    private Dish dish;
	
	public MenuItem (Dish dish) {
        this.dish = dish;
        deleteDish = new JButton("Delete");
        deleteDish.setBackground(Color.red);
        showDishInMenu = new DishTitleImageView(dish);
    	this.add(showDishInMenu);
    	this.add(deleteDish);
	}

    public JButton getDeleteDish() {
        return deleteDish;
    }

    public Dish getDish() {
        return dish;
    }
}
