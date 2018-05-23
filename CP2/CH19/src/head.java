import java.util.Arrays;


public class head {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ss = {"Bill", "Mary", "Lee", "Agnes", "Alfred", "Thomas", "Alvin", "Bernard", "Ezra",
				"Herman"};
		Arrays.sort(ss);
		System.out.println("Ascend\tDescend\n");
		for(int i = 0; i < ss.length; i++) {
			//System.out.println(ss[i]);
			System.out.println(ss[i] + "\t" + ss[ss.length-1-i]);
		}
	}
}