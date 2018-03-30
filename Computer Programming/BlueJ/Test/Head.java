import java.util.Scanner;
public class Head
{
    // instance variables - replace the example below with your own
    public static void main () {
        System.out.println("Hello, world!");
        
        Scanner s = new Scanner(System.in);
        
        System.out.print("What is your name? ");
        String name = s.nextLine();
        System.out.println("Hello, " + name);
        
        Game Mario = new Game("Mario", "Nintendo", 40.0, 60.0, 45.0, false);
        System.out.println(Mario.checkPrice());
        System.out.println(Mario.checkSale());
        Mario.changeSale(true);
        System.out.println(Mario.checkSale());
    }
}
