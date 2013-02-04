package se.kth.csc.iprog.dinnerplanner.view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class CoursesTabbedPane extends Container{
	// Tabs for starter, main, desert
	public CoursesTabbedPane(DishPickerView[] dpv) {
			setLayout(new BorderLayout());
			JTabbedPane coursesTabbedPane = new JTabbedPane();
			//String[] coursesTitle = {"Starter", "Main", "Dessert"};
			
			String[] coursesTitle = new String[3];
			coursesTitle[0] = "Starter";
			coursesTitle[1] = "Main";
			coursesTitle[2] = "Dessert";
			
			for(int t = 0; t<coursesTitle.length;t++) {
				JPanel tmpPanel = new JPanel();
				tmpPanel.add(dpv[t]);
				coursesTabbedPane.addTab(coursesTitle[t],tmpPanel);
			}
			setSize(600,800);
			this.add(coursesTabbedPane,BorderLayout.PAGE_START);
	}
}
