import java.util.ArrayList;

public class Util {

    public static ArrayList<Ingredient> arrayToArrayListIngredient(String [] input ){
        ArrayList<Ingredient> returnString = new ArrayList<>();
        for (String currentString : input){
            Ingredient currentOne = new Ingredient(currentString);
            returnString.add(currentOne);
        }
        return returnString;
    }
}
