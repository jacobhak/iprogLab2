package se.kth.csc.iprog.dinnerplanner.view;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 * User: jacob
 * Date: 2013-02-01
 * Time: 10:40
 * To change this template use File | Settings | File Templates.
 */
public class IngredientsFrame extends JFrame implements Observer {
    IngredientsTableView tableView;
    DinnerModel model;
    public IngredientsFrame(DinnerModel model) {
        this.model = model;
        tableView = new IngredientsTableView(model);
        setContentPane(tableView);
        setSize(tableView.getSize());
    }

    @Override
    public void update(Observable observable, Object o) {
        if (o.getClass().equals(ArrayList.class)) {
            tableView = new IngredientsTableView(model);
        }
    }
}
