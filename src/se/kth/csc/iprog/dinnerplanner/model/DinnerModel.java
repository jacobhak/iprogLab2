package se.kth.csc.iprog.dinnerplanner.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

public class DinnerModel extends Observable implements IDinnerModel {
	

	private Set<Dish> dishes = new HashSet<Dish>();
    private int numberOfGuests;
    private ArrayList<Dish> currentMenu = new ArrayList<Dish>(3);
	
	/**
	 * The constructor of the overall model. Set the default values here
	 */
	public DinnerModel(){
        numberOfGuests = 0;
		addExampleData();
	}

	public Set<Dish> getDishes(){
		return dishes;
	}
	
	/**
	 * Returns the set of dishes of specific type.
	 */
	public Set<Dish> getDishesOfType(int type){
		Set<Dish> result = new HashSet<Dish>();
		for(Dish d : dishes){
			if(d.getType() == type){
				result.add(d);
			}
		}
		return result;
	}
	
	/**
	 * Returns the set of dishes of specific type, that contain filter in their name
	 * or name of any ingredient. 
	 */
	public Set<Dish> filterDishesOfType(int type, String filter){
		Set<Dish> result = new HashSet<Dish>();
		for(Dish d : dishes){
			if(d.getType() == type && d.contains(filter)){
				result.add(d);
			}
		}
		return result;
	}


    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        if (numberOfGuests < 0) return;
        this.numberOfGuests = numberOfGuests;
        setChanged();
        notifyObservers(new Integer(numberOfGuests));
    }

    public void addDishToMenu(Dish dish) {
        if (currentMenu.size()-1 < dish.getType())
            currentMenu.add(dish);
        // Handling wrong dish at wrong index
        else if (currentMenu.get(dish.getType()).getType() != dish.getType()) {
            Dish dish1 = currentMenu.get(dish.getType());
            currentMenu.set(dish.getType(),dish);
            currentMenu.add(dish1);
        } else currentMenu.set(dish.getType(),dish);
        setChanged();
        notifyObservers(currentMenu);
    }

    public void removeDishFromMenu(Dish dish) {
        currentMenu.remove(dish);
        setChanged();
        notifyObservers(currentMenu);
    }

    public Dish getSelectedDish(int type) {
         return currentMenu.get(type);
    }
    
    public Dish getSpecificDish(String name){
    	Dish result = null;
		for(Dish d : dishes){
			if(d.getName().equals(name)){
				result=d;
			}
		}
		return result;
    }

    public Set<Dish> getFullMenu() {
        return new HashSet<Dish>(currentMenu);
    }
    
    public ArrayList<Dish> getCurrentMenu(){
    	return currentMenu;
    }

    public Set<Ingredient> getAllIngredients() {
        HashSet<Ingredient> allIngredients = new HashSet<Ingredient>();
        for (Dish dish :currentMenu) {
            for (Ingredient ingredient : dish.ingredients) {
                allIngredients.add(ingredient);
            }
        }
        return allIngredients;
    }

    public float getTotalMenuPrice() {
        int totalPrice = 0;
        for (Ingredient ingredient : getAllIngredients()) {
            totalPrice += ingredient.price * numberOfGuests;
        }
        return totalPrice;
    }

    private void addExampleData() {
        //Adding some example data, you can add more
        Dish dish1 = new Dish("French toast",Dish.STARTER,"toast.jpg","In a large mixing bowl, beat the eggs. Add the milk, brown sugar and nutmeg; stir well to combine. Soak bread slices in the egg mixture until saturated. Heat a lightly oiled griddle or frying pan over medium high heat. Brown slices on both sides, sprinkle with cinnamon and serve hot.");
        Ingredient dish1ing1 = new Ingredient("eggs",0.5,"",1);
        Ingredient dish1ing2 = new Ingredient("milk",30,"ml",6);
        Ingredient dish1ing3 = new Ingredient("brown sugar",7,"g",1);
        Ingredient dish1ing4 = new Ingredient("ground nutmeg",0.5,"g",12);
        Ingredient dish1ing5 = new Ingredient("white bread",2,"slices",2);
        dish1.addIngredient(dish1ing1);
        dish1.addIngredient(dish1ing2);
        dish1.addIngredient(dish1ing3);
        dish1.addIngredient(dish1ing4);
        dish1.addIngredient(dish1ing5);
        dishes.add(dish1);
        currentMenu.add(Dish.STARTER,dish1);

        Dish dish2 = new Dish("Meat balls",Dish.MAIN,"meatballs.jpg","Preheat an oven to 400 degrees F (200 degrees C). Place the beef into a mixing bowl, and season with salt, onion, garlic salt, Italian seasoning, oregano, red pepper flakes, hot pepper sauce, and Worcestershire sauce; mix well. Add the milk, Parmesan cheese, and bread crumbs. Mix until evenly blended, then form into 1 1/2-inch meatballs, and place onto a baking sheet. Bake in the preheated oven until no longer pink in the center, 20 to 25 minutes.");
        Ingredient dish2ing1 = new Ingredient("extra lean ground beef",115,"g",20);
        Ingredient dish2ing2 = new Ingredient("sea salt",0.7,"g",3);
        Ingredient dish2ing3 = new Ingredient("small onion, diced",0.25,"",2);
        Ingredient dish2ing4 = new Ingredient("garlic salt",0.6,"g",3);
        Ingredient dish2ing5 = new Ingredient("Italian seasoning",0.3,"g",3);
        Ingredient dish2ing6 = new Ingredient("dried oregano",0.3,"g",3);
        Ingredient dish2ing7 = new Ingredient("crushed red pepper flakes",0.6,"g",3);
        Ingredient dish2ing8 = new Ingredient("Worcestershire sauce",16,"ml",7);
        Ingredient dish2ing9 = new Ingredient("milk",20,"ml",4);
        Ingredient dish2ing10 = new Ingredient("grated Parmesan cheese",5,"g",8);
        Ingredient dish2ing11 = new Ingredient("seasoned bread crumbs",115,"g",4);
        dish2.addIngredient(dish2ing1);
        dish2.addIngredient(dish2ing2);
        dish2.addIngredient(dish2ing3);
        dish2.addIngredient(dish2ing4);
        dish2.addIngredient(dish2ing5);
        dish2.addIngredient(dish2ing6);
        dish2.addIngredient(dish2ing7);
        dish2.addIngredient(dish2ing8);
        dish2.addIngredient(dish2ing9);
        dish2.addIngredient(dish2ing10);
        dish2.addIngredient(dish2ing11);
        dishes.add(dish2);
        currentMenu.add(Dish.MAIN,dish2);
        
        
        Dish dish3 = new Dish("Baked Brie",Dish.STARTER,"bakedbrie.jpg","Cut a cross in the Brie. Preheat oven to 225C. Pour white wine and garlic into brie. Place in oven for 20 min.");
        Ingredient dish3ing1 = new Ingredient("Brie",1,"",4);
        Ingredient dish3ing2 = new Ingredient("White wine",100,"ml",6);
        Ingredient dish3ing3 = new Ingredient("Garlic",2,"cloves",1);
        dish3.addIngredient(dish3ing1);
        dish3.addIngredient(dish3ing2);
        dish3.addIngredient(dish3ing3);
        dishes.add(dish3);

        Dish dish4 = new Dish("Sourdough",Dish.STARTER,"sourdough.jpg","Preheat oven to 225C. Mix ingredients. Work the dough. Place in oven for 1 hour.");
        Ingredient dish4ing1 = new Ingredient("Flour",1,"l",1);
        Ingredient dish4ing2 = new Ingredient("Yiest",50,"g",1);
        Ingredient dish4ing3 = new Ingredient("Salt",1,"pinch",0.10);
        dish4.addIngredient(dish4ing1);
        dish4.addIngredient(dish4ing2);
        dish4.addIngredient(dish4ing3);
        dishes.add(dish4);
        dishes.add(new Dish("Baked Brie",Dish.STARTER,"bakedbrie.jpg","Cut a cross in the Brie. Preheat oven to 225C. Pour white wine and garlic into brie. Place in oven for 20 min."));
        dishes.add(new Dish("Baked Brie",Dish.STARTER,"bakedbrie.jpg","Cut a cross in the Brie. Preheat oven to 225C. Pour white wine and garlic into brie. Place in oven for 20 min."));
        dishes.add(new Dish("Baked Brie",Dish.STARTER,"bakedbrie.jpg","Cut a cross in the Brie. Preheat oven to 225C. Pour white wine and garlic into brie. Place in oven for 20 min."));
        dishes.add(new Dish("Baked Brie",Dish.STARTER,"bakedbrie.jpg","Cut a cross in the Brie. Preheat oven to 225C. Pour white wine and garlic into brie. Place in oven for 20 min."));


    }
}
