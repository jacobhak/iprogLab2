package se.kth.csc.iprog.dinnerplanner.view;

import se.kth.csc.iprog.dinnerplanner.model.Dish;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: jacob
 * Date: 2013-02-01
 * Time: 13:52
 * To change this template use File | Settings | File Templates.
 */
public class DishTitleImageView extends Container {
    public DishTitleImageView(Dish dish) {
        JPanel panel = new JPanel();
        ImageIcon imageIcon = new ImageIcon(dish.getImage());

    }
}
