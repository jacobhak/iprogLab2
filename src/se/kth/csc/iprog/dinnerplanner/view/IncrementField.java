package se.kth.csc.iprog.dinnerplanner.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class IncrementField extends Container implements Observer{
	
	private JLabel number;
	private JButton plusButton;
	private JButton minusButton;
	private DinnerModel dm;

	public IncrementField (DinnerModel dm){
		setLayout(new FlowLayout());
		this.dm = dm;
		dm.addObserver(this);
		plusButton= new JButton("+");
		minusButton= new JButton("-");
		this.number = new JLabel(""+dm.getNumberOfGuests());
		
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

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1.getClass().equals(Integer.class)){
			number.setText(""+arg1);
		}
		
	}
	
	
}
