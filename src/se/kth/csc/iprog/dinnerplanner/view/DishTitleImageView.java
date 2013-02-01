package se.kth.csc.iprog.dinnerplanner.view;

import se.kth.csc.iprog.dinnerplanner.model.Dish;

import javax.swing.*;
import java.awt.*;

import static java.awt.Font.*;

/**
 * Created with IntelliJ IDEA.
 * User: jacob
 * Date: 2013-02-01
 * Time: 13:52
 * To change this template use File | Settings | File Templates.
 */
public class DishTitleImageView extends Container {
    public DishTitleImageView(Dish dish) {
        setLayout(new BorderLayout());
        setSize(600,200);
        setBackground(Color.WHITE);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setSize(getSize());

        GridBagConstraints constraints = new GridBagConstraints();

        //Image
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        constraints.gridwidth = 1;
        ImageIcon imageIcon = new ImageIcon(dish.getImage());
        JPanel panel1 = new JPanel(new BorderLayout());
        JLabel label = new JLabel("", imageIcon, JLabel.LEADING);
        panel1.add(label);
        panel.add(panel1,constraints);

        //Title Label
        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        JLabel label1 = new JLabel(dish.getName());
        JPanel panel2 = new JPanel();
        panel2.add(label1);
        panel.add(panel2,constraints);

        //Detail Label
        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        JLabel label2 = new JLabel(""+dish.getCost(4)+" serves 4 people.");
        JPanel panel3 = new JPanel();
        panel3.add(label2);
        panel.add(panel3,constraints);

        add(panel);
    }
}
