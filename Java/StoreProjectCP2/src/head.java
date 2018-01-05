import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class head {

	public static void main(String[] args) throws FileNotFoundException {
		StoreObject[] Inventory = {new StoreObject ("Game 1", 5.0, 10.0), new StoreObject ("Game 2", 5.0, 10.0), new StoreObject ("Game 3", 5.0, 10.0)};
		System.out.println("New store Opening!");
		
		File f = new File("H:/My Stuff/Java/StoreProjectCP2/src/testing.txt");
		Scanner s = new Scanner(f);
		for (int i = 0; i < 4; i++)
		{
			System.out.println(s.nextLine());
		}
		s.close();
	}
}