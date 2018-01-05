import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class head {

	public static void main(String[] args) throws FileNotFoundException {
		StoreObject[] Inventory = {new Game ("Game 1", 5.0, 10.0, "Console 1", "Nintendo"), new Console ("Console 1", 5.0, 10.0, "Nintendo", "Home"), new Controller ("Controller 1", 5.0, 10.0, "Console 1", "Nintendo")};
		System.out.println("New store Opening!\n");

		System.out.println("===========\n Inventory \n===========");
		for(int i = 0; i < Inventory.length; i++){
			System.out.println(Inventory[i].itemName);
		}
		System.out.println("\n");
		
		File f = new File("/H:/My Stuff/Java/StoreProjectCP2/src/testing.txt");
		System.out.println(ScanFile(f));
	}
	
	public static String[] ScanFile(File f) throws FileNotFoundException {
		int length = 0;
		int sections = 0;
		
		Scanner s = new Scanner(f);
		while (s.hasNextLine()){
			length += 1;
			s.nextLine();
		}
		s.close();
		
		s = new Scanner(f);
		String [] file = new String[length+2];
		for (int i = 0; i < file.length-2; i++) {
			file[i+2] = s.nextLine();
			if (file[i+2].equals("..")) {
				sections += 1;
			}
		}
		file[0] = Integer.toString(length);
		file[1] = Integer.toString(sections);
		s.close();
		
		return(file);
	}
}