package se.kth.csc.iprog.dinnerplanner.view;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: jacob
 * Date: 2013-02-01
 * Time: 15:41
 * To change this template use File | Settings | File Templates.
 */
public class PreparationsFrame extends JFrame {
    public PreparationsFrame (DinnerModel model){
        JPanel panel = new JPanel(new GridLayout(0,1));
        panel.setBackground(Color.WHITE);
        for (Dish dish : model.getFullMenu()){
            panel.add(dishPreparationPanel(dish));
        }
        setSize(400,500);
        add(panel);

    }
    private JPanel dishPreparationPanel(Dish dish){
        JPanel panel = new JPanel(new GridLayout(0,1));
        panel.setBackground(Color.WHITE);
        JLabel label = new JLabel(dish.getTypeText() +": "+dish.getName());
        label.setFont(new Font("Serif", Font.BOLD, 30));
        label.setBackground(Color.WHITE);
        panel.add(label);
        JTextArea textArea = new JTextArea(dish.getDescription());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setSize(300,400);
        panel.add(textArea);
        return panel;
    }
}
