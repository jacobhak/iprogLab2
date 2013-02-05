package se.kth.csc.iprog.dinnerplanner.model;

import java.util.HashSet;
import java.util.Set;

public class Dish {
	
	public static final int STARTER = 0;
	public static final int MAIN = 1;
	public static final int DESERT = 2;
    public static final String STARTER_TEXT = "Starter";
    public static final String MAIN_TEXT = "Main";
    public static final String DESSERT_TEXT = "Dessert";

	
	String name;
	int type; // starter (1), main (2) or desert (3)  
	String image;
	String description;
	
	Set<Ingredient> ingredients = new HashSet<Ingredient>();
	
	public Dish(String name, int type, String image, String description) {
		this.name = name;
		this.type = type;
		this.image = image;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

    public String getTypeText() {
        switch (type){
            case Dish.STARTER:
                return STARTER_TEXT;
            case Dish.MAIN:
                return MAIN_TEXT;
            case Dish.DESERT:
                return DESSERT_TEXT;
        }
        return "";
    }

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Ingredient> getIngredients(){
		return ingredients;
	}
	
	public void addIngredient(Ingredient ing){
		ingredients.add(ing);
	}
	
	public void removeIngredient(Ingredient ing){
		ingredients.remove(ing);
	}

    public double getCost(int numberOfServings) {
        int totalCost = 0;
        for (Ingredient ingredient : getIngredients()) {
            totalCost += ingredient.price * numberOfServings;
        }
        return totalCost;
    }
	
	public boolean contains(String filter){
		if(name.toLowerCase().contains(filter.toLowerCase())){
			return true;
		}
		for(Ingredient i : ingredients){
			if(i.getName().toLowerCase().contains(filter.toLowerCase())){
				return true;
			}
		}
		return false;
	}

}
