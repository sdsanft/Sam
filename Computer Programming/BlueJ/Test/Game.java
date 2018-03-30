
public class Game
{
    String name;
    String console;
    double storePrice;
    double retailPrice;
    double salePrice;
    boolean sale;
    
    public Game (String argName, String argCon, 
                double argStP, double argRP, double argSaP, boolean argSale)
    {
        name = argName;
        console = argCon;
        storePrice = argStP;
        retailPrice = argRP;
        salePrice = argSaP;
        sale = argSale;
    }
    
    public String checkPrice () {
        if(sale) return("The price of " + name + " is $" + salePrice);
        else return("The price of " + name + " is $" + retailPrice);
    }
    
    public String checkSale () {
        if(sale) return(name + " is on sale for $" + salePrice + 
            ". The game is $" + (retailPrice - salePrice) + " off!");
        else return(name + " is not on sale");
    }
    
    public void changeSale (boolean argSale) {
        sale = argSale;
    }
}
