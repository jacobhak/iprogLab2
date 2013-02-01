package se.kth.csc.iprog.dinnerplanner.view;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import se.kth.csc.iprog.dinnerplanner.model.*;

import java.awt.*;
import java.util.ArrayList;


public class IngredientsTableView extends Container {
    private static final String[] columnNames = {"Ingredients","Quantity","Cost"};

    public IngredientsTableView(DinnerModel model) {
        JTable table = new JTable(getDataFromModel(model),columnNames);
        setLayout(new BorderLayout());
        add(table.getTableHeader(), BorderLayout.PAGE_START);
        add(table, BorderLayout.CENTER);
        setSize(table.getPreferredSize());

    }

    private static Object[][] getDataFromModel(DinnerModel model) {
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>(model.getAllIngredients());
        Object[][] data = new Object[ingredients.size()][3];
        for (int i = 0; i < ingredients.size();i++) {
            data[i][0] = ingredients.get(i).getName();
            data[i][1] = new Double(ingredients.get(i).getQuantity());
            data[i][2] = new Double(ingredients.get(i).getPrice());
        }
        return data;
    }
 }

