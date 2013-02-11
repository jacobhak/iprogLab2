package se.kth.csc.iprog.dinnerplanner.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class DishPickerViewController implements ActionListener{

			private DinnerModel model;
			private DishPickerView dishPV;
			private Set<JButton> dishButtons;
			
			public DishPickerViewController(DinnerModel model, DishPickerView dishPV){
				this.model = model;
				this.dishPV = dishPV;
				
				dishPV.getSearchButton().addActionListener(this);
				
				dishButtons = dishPV.getDishButtons();
				
				Iterator<JButton> it = dishButtons.iterator();
				while(it.hasNext()) {
					JButton currentDishButton = it.next();
					currentDishButton.addActionListener(this);
				}
			
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == dishPV.getSearchButton()) {
//                    System.out.print("Search handled "+dishPV.getSearchInput());
//					dishPV.setDishes(model.filterDishesOfType(dishPV.getDishType(),dishPV.getSearchInput()));
				}
				
				Iterator<JButton> it = dishButtons.iterator();
				while(it.hasNext()) {
					JButton currentDishButton = it.next();
					if(e.getSource() == currentDishButton) {
						String dishName = currentDishButton.getText();
						Dish currentDish = model.getSpecificDish(dishName);
						DishFrame dishFrame = new DishFrame(currentDish);
						dishFrame.setVisible(true);
					}
				}
				
			}
}
