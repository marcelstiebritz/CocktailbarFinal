import java.util.ArrayList;
import java.util.Collections;

public class CocktailBook {

    private ArrayList<Recipe> recipes;

    public CocktailBook() {
        this.recipes = new ArrayList<>();
    }



    public Recipe findRecipeByName(String name) throws CocktailException {
        Recipe returnRecipe=null;
        for (Recipe currentRecipe : recipes) {
            if (currentRecipe.getName().equals(name)) {
                returnRecipe = currentRecipe;
            }
        }
        if (returnRecipe == null) {
            throw new CocktailException("Kein Rezept mit diesem Namen");
        } else {
            return returnRecipe;
        }
    }


    public void removeRecipe(String name) throws CocktailException{
        boolean flag =false;
        for (Recipe currentRecipe : recipes) {
            if (currentRecipe.getName().equals(name)) {
                recipes.remove(currentRecipe);
                flag=true;
            }
        }if (flag== false){
            throw new CocktailException("Kein Rezept mit dem Namen ");
        }
    }

    public void addRecipe(Recipe recipe) throws CocktailException {
        boolean flag=false;
        for (Recipe currentRecipe : recipes) {
            if (currentRecipe.getName().equals(recipe.getName())) {
                flag=true;
            }
        }
        Collections.sort(recipes);
        if (flag){
            throw new CocktailException("Ein Rezept mit diesem Namen existiert bereits");
        }else {
            recipes.add(recipe);
        }


    }


    public ArrayList<Recipe> findRecipeByIngredient(ArrayList<Ingredient> ingredients) throws CocktailException {
        ArrayList<Recipe> returnArray = new ArrayList<>();
        for (Recipe currentRecipe : recipes) {
            if (currentRecipe.getIngredients().containsAll(ingredients)) {
                returnArray.add(currentRecipe);
            }
        }
        if (returnArray.isEmpty()){
            throw new CocktailException("Kein Rezept mit diesen Zutaten");
        }else {
            return returnArray;
        }

    }
}
