import java.util.Scanner;
public class head {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.print("What is your name? ");
		String name1, name2;
		name1 = s.nextLine();
		name1 = name1.toLowerCase();
		name2 = "";
		for (int i = 0; i < name1.length(); i++) {
			name2 += name1.substring(name1.length() - i - 1, name1.length() - i);
		}
		System.out.println(name2);
		s.close();
	}
}
