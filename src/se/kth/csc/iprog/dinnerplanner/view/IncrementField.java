package se.kth.csc.iprog.dinnerplanner.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class IncrementField extends Container{
	
	private JLabel number;
	private JButton plusButton;
	private JButton minusButton;
	private DinnerModel dm;

	public IncrementField (DinnerModel dm){
		setLayout(new FlowLayout());
		this.dm = dm;
		plusButton= new JButton("+");
		minusButton= new JButton("-");
		this.number = new JLabel(""+dm.getNumberOfGuests());
		
		/*plusButton.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
            	if(numClicks<Integer.MAX_VALUE) {
            		numClicks++;
            		number.setText(""+numClicks);
            	}
            }
        });
		
		minusButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	if(numClicks>0) {
            		numClicks--;
            		number.setText(""+numClicks);
            	}
            }
        });*/
		this.add(number);
		this.add(plusButton);
		this.add(minusButton);
		
	}
	
	public JButton getPlusButton() {
		return this.plusButton;
	}
	
	public JButton getMinusButton() {
		return this.minusButton;
	}
	
	
}
