import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		String input;
		String[] split;
		while (true) {
			Scanner kbScanner = new Scanner(System.in);
			System.out.print("Type in a sentence and press enter: ");
			input = kbScanner.nextLine();
			input = input.toUpperCase();
			if(input.equals("EXIT")) {
				break;
			}
			input += " AAA";
			split = input.split("S");
			System.out.println("There are " + (split.length - 1) + " occurences.\n\n");
		}
		*/
		
		char[] ch = new char[26];
		for (char i = 0; i < 26; i ++){
			ch[i] = (char) (i + 'A');
		}
		for (int i = 0; i < 26; i++) {
			System.out.print(ch[i] + ", ");
		}
		
	}

}
