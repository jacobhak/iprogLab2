package se.kth.csc.iprog.dinnerplanner.view;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: jacob
 * Date: 2013-02-01
 * Time: 11:38
 * To change this template use File | Settings | File Templates.
 */
public class DishFrame extends JFrame {
    public DishFrame(DinnerModel model){
        JPanel panel = new JPanel(new GridBagLayout());
        setSize(500, 330);

        //Top panel
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(new DishTitleImageView(model.getSelectedDish(0)), constraints);

        //Horizontal Separator
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        JSeparator separator = new JSeparator();
        panel.add(separator,constraints);

        //Bottom left panel
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.VERTICAL;
        JPanel bottomLeftPanel = new JPanel();
        JTextArea textArea = new JTextArea();
        textArea.setText(model.getSelectedDish(0).getDescription());
        textArea.setColumns(20);
        textArea.setLineWrap(true);
        bottomLeftPanel.add(textArea);
        bottomLeftPanel.setBackground(Color.WHITE);
        Container container = new Container();
        container.setLayout(new BorderLayout());
        container.add(bottomLeftPanel, BorderLayout.CENTER);
        panel.add(container, constraints);

        //Vertical Separator
        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.VERTICAL;
        JSeparator separator2 = new JSeparator();
        separator2.setOrientation(JSeparator.NORTH);
        panel.add(separator2,constraints);

        //Table
        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.VERTICAL;
        panel.add(new IngredientsTableView(model.getSelectedDish(0)),constraints);

        add(panel);
    }
}
