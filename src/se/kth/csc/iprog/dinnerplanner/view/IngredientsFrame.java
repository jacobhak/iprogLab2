package se.kth.csc.iprog.dinnerplanner.view;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: jacob
 * Date: 2013-02-01
 * Time: 10:40
 * To change this template use File | Settings | File Templates.
 */
public class IngredientsFrame extends JFrame {
    public IngredientsFrame(DinnerModel model) {
        IngredientsTableView table = new IngredientsTableView(model);
        Container container = new Container();
        container.setLayout(new BorderLayout());
        container.add(table.getTableHeader(), BorderLayout.PAGE_START);
        container.add(table, BorderLayout.CENTER);
        setContentPane(container);
    }
}
