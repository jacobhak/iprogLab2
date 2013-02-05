package se.kth.csc.iprog.dinnerplanner.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class DragAndDropController implements ActionListener{

	DinnerModel model;
	DragAndDropMenu dndMenu;
	
	public DragAndDropController(DinnerModel model, DragAndDropMenu dndMenu){
		this.model = model;
		this.dndMenu = dndMenu;
		
		dndMenu.getPrepButton().addActionListener(this);
		dndMenu.getIngrButton().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == dndMenu.getPrepButton()) {
			PreparationsFrame preparationsFrame = new PreparationsFrame(model);
	        preparationsFrame.setTitle("Preparation");
	        preparationsFrame.setVisible(true);
		}
		if(e.getSource() == dndMenu.getIngrButton()) {
			IngredientsFrame ingredientsFrame = new IngredientsFrame(model);
	        ingredientsFrame.setTitle("Ingredients");
	        ingredientsFrame.setVisible(true);
		}
	}
}
