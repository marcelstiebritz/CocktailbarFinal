import java.util.ArrayList;

public class Recipe implements Comparable<Recipe> {

    private String name;
    private ArrayList<Ingredient> ingredients;
    private double alc;
    private Glass glassType;
    private String occasion;
    private ArrayList<Accesories> usedAccesories;
    private String zubereitung;

    public Recipe(String name, ArrayList<Ingredient> ingredients, double alc, Glass glassType, String occasion, ArrayList<Accesories> usedAccesories) {
        this.name = name;
        this.ingredients = ingredients;
        this.alc = alc;
        this.glassType = glassType;
        this.occasion = occasion;
        this.usedAccesories = usedAccesories;
    }

    public Recipe(String name, ArrayList<Ingredient> ingredients,String zubereitung ,double alc, Glass glassType) {
        this.name = name;
        this.ingredients = ingredients;
        this.alc = alc;
        this.glassType = glassType;
        this.zubereitung = zubereitung;
    }


    public String getName() {
        return this.name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return name+ "\n"+ingredients.toString().substring(1,ingredients.toString().length()-1)+
                "\n"+zubereitung +
                "\n"+ this.alc+"%";
    }

    @Override
    public int compareTo(Recipe o) {
        return this.getName().compareTo(o.getName());
    }
}
