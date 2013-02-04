package se.kth.csc.iprog.dinnerplanner.view;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;



public class DragAndDropMenu extends Container {

	public DragAndDropMenu(DinnerModel dm){
		setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        
        JLabel numGuests = new JLabel("Number of guests: ");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(numGuests,constraints);
        
        IncrementField inField = new IncrementField();
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(inField,constraints);
        
        JLabel tot = new JLabel("Total cost: ");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(tot,constraints);
        
        JLabel cost = new JLabel("$ "+dm.getTotalMenuPrice());
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(cost,constraints);
        
        JLabel dinnerMenuText = new JLabel("Dinner Menu");
        dinnerMenuText.setFont(new Font("Serif", Font.BOLD, 36));
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        panel.add(dinnerMenuText,constraints);
        
        JTextArea dragDropArea = new JTextArea(
        	    "Drag your dishes here " +
        	    "to complete a menu! ",
        	    1,1
        	);
        dragDropArea.setFont(new Font("Serif", Font.ITALIC, 10));
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        panel.add(dragDropArea,constraints);
        
        DishTitleImageView showDishInMenu = new DishTitleImageView(dm.getSelectedDish(0));
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        panel.add(showDishInMenu,constraints);
        
        JButton deleteDish = new JButton("Delete");
        deleteDish.setBackground(Color.red);
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        panel.add(deleteDish,constraints);
        
        JButton prep = new JButton("Preparations");
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        panel.add(prep,constraints);
        
        JButton ingr = new JButton("Ingredients");
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        panel.add(ingr,constraints);
        
        this.add(panel,BorderLayout.PAGE_START);
        
        
	}
}
