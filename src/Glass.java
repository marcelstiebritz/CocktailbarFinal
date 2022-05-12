public enum Glass {

    Sektglas ("Sektglas"),
    Cocktailglas("Cocktailglas"),
    Limoglas ("Limoglas");


    private final String name;
    Glass(String s) {
        this.name= s;
    }

    public static Glass stringToGlas(String s) throws CocktailException{
        Glass returnglass= null;

            if (s.equals(Sektglas.name)){
                returnglass = Sektglas;
            }else if(s.equals(Cocktailglas.name)){
                returnglass = Cocktailglas;
            }else if(s.equals(Limoglas.name)) {
                returnglass = Limoglas;
            }


        if (returnglass.equals(null)){
            throw new CocktailException("Kein Glas mit diesem Namen");
        }return returnglass;
    }
}
