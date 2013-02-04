package se.kth.csc.iprog.dinnerplanner.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class IncrementField extends Container{
	
	private int numClicks = 4;
	private JLabel number;

	public IncrementField (){
		setLayout(new FlowLayout());
		JButton plusButton = new JButton("+");
		JButton minusButton = new JButton("-");
		this.number = new JLabel("4");
		
		plusButton.addActionListener(new ActionListener() {
 
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
        });
		this.add(number);
		this.add(plusButton);
		this.add(minusButton);
		
	}
	
	
}
