package se.kth.csc.iprog.dinnerplanner.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

import javax.swing.JPanel;
import javax.swing.JSeparator;


public class MainView extends JPanel {
    DragAndDropController dragAndDropController;
    DishPickerViewController controllerDPVstarter,controllerDPVmain,controllerDPVdessert;
	
	public MainView(DinnerModel model){
		setLayout(new GridBagLayout());
        setSize(1024,386);

		GridBagConstraints mainConstraints = new GridBagConstraints();
		

		
		DishPickerView[] listDPV = new DishPickerView[3];
		listDPV[0] = new DishPickerView(model, Dish.STARTER);
		controllerDPVstarter = new DishPickerViewController(model, listDPV[0]);
		listDPV[1] = new DishPickerView(model, Dish.MAIN);
		controllerDPVmain = new DishPickerViewController(model, listDPV[1]);
		listDPV[2] = new DishPickerView(model, Dish.DESERT);
		controllerDPVdessert = new DishPickerViewController(model, listDPV[2]);
		
		CoursesTabbedPane tabs = new CoursesTabbedPane(listDPV);
		mainConstraints.gridx = 0;
		mainConstraints.gridy = 0;
        mainConstraints.gridwidth = 5;
		this.add(tabs,mainConstraints);


        JSeparator vertical = new JSeparator();
        vertical.setOrientation(JSeparator.NORTH);
        mainConstraints = new GridBagConstraints();
        mainConstraints.gridx = 5;
        mainConstraints.gridy = 0;
        mainConstraints.fill = GridBagConstraints.VERTICAL;
        this.add(vertical,mainConstraints);
		
		DragAndDropMenu mainDragAndDropMenu = new DragAndDropMenu(model);
        dragAndDropController = new DragAndDropController(model,mainDragAndDropMenu);
        mainConstraints = new GridBagConstraints();
		mainConstraints.gridx = 6;
		mainConstraints.gridy = 0;
        mainConstraints.gridwidth = 1;
		this.add(mainDragAndDropMenu,mainConstraints);
	}
}
