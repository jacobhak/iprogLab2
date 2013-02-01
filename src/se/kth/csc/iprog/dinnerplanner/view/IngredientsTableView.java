package se.kth.csc.iprog.dinnerplanner.view;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import se.kth.csc.iprog.dinnerplanner.model.*;

import java.util.ArrayList;


public class IngredientsTableView extends JTable  {
    private static final String[] columnNames = {"Ingredients","Quantity","Cost"};

    public IngredientsTableView(DinnerModel model) {
          super(getDataFromModel(model),columnNames);
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

