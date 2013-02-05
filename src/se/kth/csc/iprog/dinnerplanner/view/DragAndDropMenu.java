package se.kth.csc.iprog.dinnerplanner.view;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;



public class DragAndDropMenu extends Container implements Observer {
	private JButton prep;
	private JButton ingr;
    private JLabel costLabel;
    private DinnerModel model;
	
	public DragAndDropMenu(DinnerModel dm){
		setLayout(new BorderLayout());
        model = dm;

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        
        JLabel numGuests = new JLabel("Number of guests: ");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(numGuests,constraints);
        
        IncrementField inField = new IncrementField(dm);
        IncrementController ic = new IncrementController(dm, inField);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(inField,constraints);
        
        JLabel tot = new JLabel("Total cost: ");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(tot,constraints);
        
        costLabel = new JLabel("$ "+dm.getTotalMenuPrice());
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(costLabel,constraints);
        
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
        
        this.prep = new JButton("Preparations");
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        panel.add(prep,constraints);
        
        this.ingr = new JButton("Ingredients");
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        panel.add(ingr,constraints);

        setSize(400,200);
        this.add(panel,BorderLayout.PAGE_START);
        dm.addObserver(this);
	}
	
	public JButton getIngrButton() {
		return this.ingr;
	}
	
	public JButton getPrepButton() {
		return this.prep;
	}

    @Override
    public void update(Observable observable, Object o) {
        costLabel.setText("$ "+model.getTotalMenuPrice());
    }
}
