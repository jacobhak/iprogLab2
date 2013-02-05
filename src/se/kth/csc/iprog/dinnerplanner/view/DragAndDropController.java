package se.kth.csc.iprog.dinnerplanner.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import se.kth.csc.iprog.dinnerplanner.DinnerPlanner;
import se.kth.csc.iprog.dinnerplanner.JButton;

public class DragAndDropController implements ActionListener{

	DinnerPlanner planner;
	DragAndDropMenu dndMenu;
	
	public DragAndDropController(DinnerPlanner planner, DragAndDropMenu dndMenu){
		this.dndMenu = dndMenu;
		
		dndMenu.getPrepButton().addActionListener(this);
		dndMenu.getIngrButton().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == dndMenu.getPrepButton()) {
			planner.popupWindows()
		}
		if(e.getSource() == dndMenu.getIngrButton()) {
			
		}
	}
	
	
	public void popupWindows (JButton typeOfButton) {
		if(typeOfButton.equals()) {
			//PreparationsFrame
	        PreparationsFrame preparationsFrame = new PreparationsFrame(dinnerPlanner.model);
	        preparationsFrame.setTitle("Preparation");
	        preparationsFrame.setVisible(true);
		}
		if(typeOfButton.equals(ingredientsFrame.getTitle())) {
			//Init IngredientsFrame
			IngredientsFrame ingredientsFrame = new IngredientsFrame(dinnerPlanner.model);
	        ingredientsFrame.setTitle("Ingredients");
	        ingredientsFrame.setVisible(true);
		}
	}


}
