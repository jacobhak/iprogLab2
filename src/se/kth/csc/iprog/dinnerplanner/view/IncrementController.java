package se.kth.csc.iprog.dinnerplanner.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class IncrementController implements ActionListener{

		 DinnerModel model;
		 IncrementField incrementField;

		 public IncrementController(DinnerModel model, IncrementField incrementField ) {
			 this.model = model;
			 this.incrementField = incrementField;

			 incrementField.getPlusButton().addActionListener(this);
			 incrementField.getMinusButton().addActionListener(this);
		 }

		 @Override
		 public void actionPerformed(ActionEvent e) {
			 if(e.getSource() == incrementField.getPlusButton()) {
				 model.setNumberOfGuests(model.getNumberOfGuests() + 1);
			 }
			 if(e.getSource() == incrementField.getMinusButton()) {
				 model.setNumberOfGuests(model.getNumberOfGuests() - 1);
			 }
		 }
}
