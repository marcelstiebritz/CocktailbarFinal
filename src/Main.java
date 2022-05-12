import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        CocktailBook test = new CocktailBook();
        ArrayList<Ingredient> testArray = new ArrayList<>();
        Ingredient ingredient1 = new Ingredient("Wasser");
        testArray.add(ingredient1);
        Recipe testrecipe = new Recipe("Test",testArray,"E",2,Glass.Cocktailglas);
        try {
            test.addRecipe(testrecipe);
            System.out.println(test.findRecipeByName("Test"));
        } catch (CocktailException e) {
            e.getMessage();
        }


    }
}
