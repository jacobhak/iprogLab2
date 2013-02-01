package se.kth.csc.iprog.dinnerplanner;

import javax.swing.JFrame;

import se.kth.csc.iprog.dinnerplanner.model.*;
import se.kth.csc.iprog.dinnerplanner.view.*;


public class DinnerPlanner extends JFrame {

	private DinnerModel model = new DinnerModel();

	public DinnerModel getModel() {
		return model;
	}

	public void setModel(DinnerModel model) {
		this.model = model;
	}

	public static void main(String[] args) {
		//Initiating the main JFrame
		DinnerPlanner dinnerPlanner = new DinnerPlanner();
		dinnerPlanner.setTitle("Dinner Planner");
		
		//Creating the first view
		MainView mainView = new MainView(dinnerPlanner.getModel());
		
		//Adding the view to the main JFrame
		dinnerPlanner.getContentPane().add(mainView);
		
		//and starting the JFrame
		dinnerPlanner.setVisible(true);

        //Init IngredientsFrame
        IngredientsFrame ingredientsFrame = new IngredientsFrame(dinnerPlanner.model);
        ingredientsFrame.setTitle("Ingredients");
        ingredientsFrame.setVisible(true);

	}

}
