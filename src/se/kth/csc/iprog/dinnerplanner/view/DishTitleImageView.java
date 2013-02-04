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
        setBackground(Color.WHITE);
        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        //Image
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        constraints.gridwidth = 1;
        String imageURL = "images/"+dish.getImage();
		Icon imageIcon = new ImageIcon(imageURL);
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
        constraints.fill = GridBagConstraints.HORIZONTAL;
        JLabel label1 = new JLabel(dish.getName());
        label1.setFont(new Font("Serif", Font.PLAIN, 20));

        JPanel panel2 = new JPanel();
        panel2.add(label1);
        panel.add(panel2,constraints);

        //Detail Label
        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        JLabel label2 = new JLabel(""+dish.getCost(4)+"$, serves 4 people.");
        JPanel panel3 = new JPanel();
        panel3.add(label2);
        panel.add(panel3,constraints);

        panel.setSize(500,1000);
        add(panel, BorderLayout.LINE_START);
    }
}
